package org.tact.base.service;

import java.util.List;

import org.tact.base.domain.FacebookFeed;

public interface SocialFeedService {
	
	public List<FacebookFeed> getFacebookPosts();
}
