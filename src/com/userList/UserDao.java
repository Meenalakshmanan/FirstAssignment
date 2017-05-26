package com.userList;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UserDao {

		
	public void addUserDetails(int userid, String userName, String userGoldBadges, String userSilverGadges, String userBronzeBadges ){
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
			user.setId(userid);
			user.setname(userName);
			user.setUserGoldBadges(userGoldBadges);
			user.setUserSilverBadges(userSilverGadges);
			user.setUserBronzeBadges(userBronzeBadges);
			System.out.println("\n\n Details Added \n");
			transaction.commit();
			session.close();
		}catch(HibernateException e){
			System.out.println(e.getMessage());
			System.out.println("error");
			
		}
	}
	
	}
/*public List<User> getUser(int userid) {
List<User> userList = null;
Document doc;
try {
	doc = Jsoup.connect("https://stackoverflow.com/users/919514/olivier").get();		 
	String userName = doc.select("h2.user-card-name").text();
	System.out.println("User Name: " + userName);
	Elements el = doc.select("div#avatar-card");
	//System.out.println("element: " + el); 
	for(Element element : el.select("div.avatar")){
		String id = el.select("a").attr("href");
		System.out.println("User ID:"  + id);
		String uid = id.substring(32, 38);
		System.out.println("User ID:"  + uid);
		int u = Integer.parseInt(uid);
		System.out.println("User ID:"  + u);
		
		String userReputation = el.select("div.reputation").text();
		System.out.println("Reputation:"  + userReputation);
		String userGoldBadges = el.select("span.badge1-alternate").attr("title");
		String userSilverBadges = el.select("span.badge2-alternate").attr("title");
		String userBronzeBadges = el.select("span.badge3-alternate").attr("title");
		String userBadges = el.select("div.badges").text();
		System.out.println("Medals: " + userGoldBadges +", "+ userSilverBadges +", "+ userBronzeBadges);
		User user = new User(u);
		userList.add(user);
	}
} catch (IOException e) {
	
	e.printStackTrace();
}
return userList;

} */
