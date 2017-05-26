package com.userList;
import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "user") 

public class User implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private int userid; 
   private String username; 
   private String userGoldBadges; 
   private String userSilverBadges; 
   private String userBronzeBadges; 
   public User(){} 

   public User(int id,String name,String userGoldBadges,String userSilverBadges,String userBronzeBadges){
	   this.userid =id;
	   this.username = name;
	   this.userGoldBadges = userGoldBadges;
	   this.userSilverBadges = userSilverBadges;
	   this.userBronzeBadges = userBronzeBadges;    
	 }
   
   public User(int userid){
	   this.username = username;
	   this.userGoldBadges = userGoldBadges;
	   this.userSilverBadges = userSilverBadges;
	   this.userBronzeBadges = userBronzeBadges;
   }
   
   public int getId(){
	   return userid;
   }
   
   @XmlElement
   public void setId(int id){
	   this.userid = id;
   }
   
   public String getname(){
	   return username;
   }
   
   @XmlElement
   public void setname(String name){
	   this.username = name;
   }
   
   public String getUserGoldBadges() {
	return userGoldBadges;
}

   @XmlElement
public void setUserGoldBadges(String userGoldBadges) {
	this.userGoldBadges = userGoldBadges;
}

public String getUserSilverBadges() {
	return userSilverBadges;
}
 @XmlElement
public void setUserSilverBadges(String userSilverBadges) {
	this.userSilverBadges = userSilverBadges;
}

public String getUserBronzeBadges() {
	return userBronzeBadges;
}
@XmlElement
public void setUserBronzeBadges(String userBronzeBadges) {
	this.userBronzeBadges = userBronzeBadges;
}
    
}
