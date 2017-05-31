package com.stockoverflow.user.test;

import org.springframework.web.client.RestTemplate;

import com.stockoverflow.user.model.User;

public class UserTestClient {

	 public static final String REST_SERVICE_URI = "https://stackoverflow.com/users";
	 /* GET */
	    private static void getUser(){
	        System.out.println("Testing getUser API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        User user = restTemplate.getForObject(REST_SERVICE_URI+"/919514/olivier", User.class);
	        System.out.println(user);
	    }
	public static void main(String[] args) {
		getUser();
        

	}

}
