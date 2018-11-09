package org.tact.base.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;
import org.tact.base.domain.FacebookFeed;
import org.tact.base.service.SocialFeedService;

@Service
public class SocialFeedServiceImpl implements SocialFeedService {
	
	/**
	 * 
		facebook.app.id=
		facebook.app.secret=
		facebook.callback=
		facebook.scope=
		facebook.return.url=
		facebook.like.callback=
		facebook.page=
		facebook.competitive.page=
		facebook.like.redirect=	
	  
	 * 
	 */
	
	private static Logger _log = LoggerFactory.getLogger(FacebookFeed.class);
	
	private static String FACEBOOK = "Facebook";
	
	//@Value("${facebook.app.id}")
	private String fbAppId = "";
	
	//@Value("${facebook.app.secret}")
	private String fbAppSecret = "";

	//@Value("${facebook.page}")
	private String fbPageId = "";
	
	//@Value("${social.feed.filter}")
	private String feedFilter = "#feed";

	@Override
	public List<FacebookFeed> getFacebookPosts() {
		
		List<FacebookFeed> socialList = new LinkedList<FacebookFeed>();
		
		try {
			Facebook facebook = new FacebookTemplate(fbAppId+ "|"+fbAppSecret);
			
			PagingParameters pagedListParameters = new PagingParameters(5, 0, null, null);
			List<Post> statusposts = facebook.feedOperations().getPosts(fbPageId, pagedListParameters);
			
			_log.info("{getFacebookPosts} fbAppId="+ fbAppId + " fbAppSecret=" + fbAppSecret + " size " + statusposts.size());
			
			for (Post post : statusposts) {
				
				String strFeedID = post.getId();
				//String strMessage = post.getMessage();
				String strMessage = post.getMessage() == null ? post.getDescription() : post.getMessage();
				
				String [] fields = { "id", "picture", "message", "link","created_time","from","type","name" ,"full_picture" };
				post = facebook.fetchObject(strFeedID, Post.class, fields);
				
				if(!StringUtils.containsIgnoreCase(strMessage, feedFilter)){
					// insert only feeds with specific hashtag
					continue;
				}
				
				FacebookFeed sf = new FacebookFeed();
				sf.setFeedId(strFeedID);
				sf.setSource(SocialFeedServiceImpl.FACEBOOK);
				sf.setLink(post.getLink());
				sf.setMessage(strMessage);
				sf.setSync_date(new Date());
				sf.setTitle("");
				sf.setType(post.getType().toString());
				sf.setUploaded_date(post.getCreatedTime());

				try{
					String picture = post.getPicture();
					picture = post.getExtraData().get("full_picture") != null ? post.getExtraData().get("full_picture").toString() : picture;			
					sf.setThumbnail_link(picture);
				}catch(Exception e){
					e.printStackTrace();					
				}
				
				if(post != null && post.getFrom() != null){
					sf.setUser_id(post.getFrom().getName());
				}
				_log.info("{getFacebookPosts} sf : "+sf);
				
				socialList.add(sf);				
			}
			
			return socialList;
			
		}catch (Exception e) {
			e.printStackTrace();	
			
			return null;
		}		
	}
}
