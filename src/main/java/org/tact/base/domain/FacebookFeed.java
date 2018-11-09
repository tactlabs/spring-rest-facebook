package org.tact.base.domain;

import java.lang.reflect.Field;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FacebookFeed {
	
	@JsonIgnore
	private static Logger _log = LoggerFactory.getLogger(FacebookFeed.class);

	@JsonProperty("Id")
	private int Id;
	
	@JsonIgnore
	private String feed_id;
	
	@JsonProperty("Feed_Source")
	private String source;
	
	@JsonProperty("Link")
	private String link;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Type")
	private String type;
	
	@JsonIgnore
	private Date sync_date;
	
	@JsonIgnore
	private Date uploaded_date;
	
	@JsonProperty("Game_Type")
	private Integer game_type;
	
	@JsonIgnore
	private Date start_date;
	
	@JsonIgnore
	private Date end_date;
	
	@JsonProperty("User_Id")
	private String user_id;
	
	@JsonProperty("Is_Sticky")
	private boolean is_sticky;
	
	@JsonProperty("Is_Live")
	private boolean is_live;
	
	@JsonProperty("Thumbnail")
	private String thumbnail_link;
	
	@JsonProperty("Thumbnail_Link_1")
	private String thumbnail_link_1;
	
	@JsonProperty("Thumbnail_Link_2")
	private String thumbnail_link_2;
	
	@JsonProperty("Thumbnail_Link_3")
	private String thumbnail_link_3;	
	
	@JsonProperty("Is_Active")
	private boolean is_valid;

	public boolean isIs_valid() {
		return is_valid;
	}
	public void setIs_valid(boolean is_valid) {
		this.is_valid = is_valid;
	}
	public boolean isIs_sticky() {
		return is_sticky;
	}
	public void setIs_sticky(boolean Is_sticky) {
		this.is_sticky = Is_sticky;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@JsonIgnore
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFeedId() {
		return feed_id;
	}
	public void setFeedId(String feedId) {
		this.feed_id = feedId;
	}

	public String getSource() {
		if(source != null)
			return source;
		else
			return "";
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getLink() {
		if(link != null)
			return link;
		else
			return "";
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getMessage() {
		if(message != null)
			return message;
		else
			return "";
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		if(title != null)
			return title;
		else
			return "";
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		if(type != null)
			return type;
		else
			return "";
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getSync_date() {
		return sync_date;
	}
	public void setSync_date(Date sync_date) {
		this.sync_date = sync_date;
	}
	
	@JsonProperty("Upload_Date")
	public String getUploadDateFormatted() {
		if(uploaded_date != null)
			return uploaded_date.getTime() + "";
		else return "";
		
	}

	public void setUploaded_date(Date upload_date) {
		this.uploaded_date = upload_date;
	}
	
	public String getThumbnail_link() {
		return thumbnail_link;
	}
	public void setThumbnail_link(String thumbnail_link) {
		this.thumbnail_link = thumbnail_link;
	}
	
	public String getThumbnail_link_1() {
		return thumbnail_link_1;
	}

	public void setThumbnail_link_1(String img) {
		this.thumbnail_link_1 = img;
	}
	
	public String getThumbnail_link_2() {
		return thumbnail_link_2;
	}

	public void setThumbnail_link_2(String img) {
		this.thumbnail_link_2 = img;
	}
	
	public String getThumbnail_link_3() {
		return thumbnail_link_3;
	}

	public void setThumbnail_link_3(String img) {
		this.thumbnail_link_3 = img;
	}
	
	public boolean isIs_live() {
		return is_live;
	}
	public void setIs_live(boolean is_live) {
		this.is_live = is_live;
	}
	
	@JsonIgnore
	@Override
	public String toString() {
		super.toString();
		StringBuilder result = new StringBuilder();

		result.append(this.getClass().getName());
		result.append(" {");

		// determine fields declared in this class only (no fields of
		// superclass)
		Field[] fields = this.getClass().getDeclaredFields();

		// print field names paired with their values
		for (Field field : fields) {
			try {
				if (field.getName().equals("_log"))
					continue;
				result.append(field.getName());
				result.append("=");
				result.append("[" + field.get(this) + "], ");
			} catch (IllegalAccessException ex) {
				_log.error("{toString} error - ", ex);
			}
		}
		result.append("}");
		return result.toString();
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	@JsonProperty("Start_Date")
	public String getStart_dateFormatted() {
		if(start_date != null)
			return start_date.getTime() + "";
		else return "";
		
	}
	
	@JsonProperty("End_Date")
	public String getEnd_dateFormatted() {
		if(end_date != null)
			return end_date.getTime() + "";
		else return "";
		
	}

	public void setGame_type(Integer game_type){
		this.game_type = game_type;
	}
	
	public Integer getGame_type(){
		return this.game_type;
	}
}
