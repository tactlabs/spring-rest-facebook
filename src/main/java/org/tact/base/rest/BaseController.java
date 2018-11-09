package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.domain.FacebookFeed;
import org.tact.base.service.SocialFeedService;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	@Autowired
	private SocialFeedService socialService;
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/base/
	 */
    @GetMapping(value = "")
    public <T> T testBase() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    public static void print(Object obj){
    	System.out.println(obj);
    }
    
    /**
     * 
     * @return
     * 
     * possible urls: 
	 * 		/fb
	 * 		/base/fb
	 * 		http://localhost:1878/base/fb
     */
    @GetMapping(value = "/fb")
    public <T> T getFB() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();

    	List<FacebookFeed> socialList = socialService.getFacebookPosts();
    	
    	map.put("apivalue", socialList);
    	map.put("apiresult", "000");
		map.put("message", "ok");
        
        return (T) map;
    }
}
