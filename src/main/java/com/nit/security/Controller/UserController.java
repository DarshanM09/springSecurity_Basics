package com.nit.security.Controller;

import com.nit.security.Entity.User;
import com.nit.security.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;


    @GetMapping("/add")
    public ResponseEntity<User> creteUser(@RequestBody User user){

        User user1 = userService.createUser(user);
        System.out.println(user1);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);

    }



    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = userService.getUser(id);

        System.out.println("############  "+user);
        return  new ResponseEntity<User>(user,HttpStatus.OK);

    }


    @GetMapping("/get/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        User user2 = userService.findbyname(name);

        return  new ResponseEntity<User>(user2,HttpStatus.OK);

    }


    @GetMapping("/msg")
    public String newOp(){
        return " Welcome to SBI";
    }
}
