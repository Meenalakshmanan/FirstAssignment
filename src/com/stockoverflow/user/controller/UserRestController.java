package com.stockoverflow.user.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockoverflow.user.*;
import com.stockoverflow.user.service.UserService;
 
@RestController
public class UserRestController {
	
	@Autowired
	    UserService userService;
	 
	@RequestMapping(value ="/user/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 public <User> ResponseEntity<User> getUser(@PathVariable("id") int id){
		//System.out.println("Fetching User with id " + id);
		User user = (User) userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
}
