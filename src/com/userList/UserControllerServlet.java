package com.userList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.userList.UserDao;


public class UserControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    
    	Document doc = Jsoup.connect("https://stackoverflow.com/users/919514/olivier").get();		 
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
			HttpSession session = request.getSession(true);
	    	try{
	    		UserDao userDAO = new UserDao();
	    		userDAO.addUserDetails(u,userName,userGoldBadges,userSilverBadges,userBronzeBadges);
	    		response.sendRedirect("Success");
	    	}catch (Exception e){
	    		e.printStackTrace();
	    	}
}
    }
}
