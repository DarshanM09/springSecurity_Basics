package com.nit.security.Service;


import com.nit.security.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {


    public  String registerUser(User user);



    User createUser(User user);

    User getUser(Integer id);

    User findbyname(String name);



}
