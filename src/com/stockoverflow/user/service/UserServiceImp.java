package com.stockoverflow.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.stockoverflow.user.model.User;

@Service("userService")
public class UserServiceImp implements UserService {

	 private static List<User> users;
	    
static{
	users= populateUsers();
}

private static List<User> populateUsers(){
	Document doc;
	try {
		doc = Jsoup.connect("https://stackoverflow.com/users/919514/olivier").get();
		String userName = doc.select("h2.user-card-name").text();
		System.out.println("User Name: " + userName);
		Elements el = doc.select("div#avatar-card");
		//System.out.println("element: " + el); 
		for(Element element : el.select("div.avatar")){
			String id = el.select("a").attr("href");
			//System.out.println("User ID:"  + id);
			String uid = id.substring(32, 38);
			//System.out.println("User ID:"  + uid);
			int userid = Integer.parseInt(uid);
			System.out.println("User ID:"  + userid);
			
			String userReputation = el.select("div.reputation").text();
			System.out.println("Reputation:"  + userReputation);
			String userGoldBadges = el.select("span.badge1-alternate").attr("title");
			String userSilverBadges = el.select("span.badge2-alternate").attr("title");
			String userBronzeBadges = el.select("span.badge3-alternate").attr("title");
			String userBadges = el.select("div.badges").text();
			System.out.println("Medals: " + userGoldBadges +", "+ userSilverBadges +", "+ userBronzeBadges);
			 List<User> users = new ArrayList<User>();
		        users.add(new User(userid,"userName","userReputation", "userGoldBadges","userSilverBadges","userBronzeBadges"));
		        
	}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		 
	return users;
	}
	
public User findById(int id) {
    for(User user : users){
        if(user.getId() == id){
            return user;
        }
    }
    return null;
}	
	

}

