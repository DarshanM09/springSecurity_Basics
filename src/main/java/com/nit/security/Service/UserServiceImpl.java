package com.nit.security.Service;

import com.nit.security.Entity.User;
import com.nit.security.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public String registerUser(User user) {
        // Encode the Password
     //   details.setPwd(encoder.encode(details.getPwd()));
        // save object
        return "user is registered with"+ userRepo.save(user).getUid()+" id value";

    }

    @Override
    public User createUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        User save = userRepo.save(user);
        return save;
    }

    @Override
    public User getUser(Integer id) {

        User user = userRepo.findById(id).get();
        System.out.println("1###### "+user);
        return user;
    }

    @Override
    public User findbyname(String name) {

        User byUsername = userRepo.findByUsername(name);

        return byUsername;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User details = userRepo.findByUsername(username);
        System.out.println("2##### "+details);

        org.springframework.security.core.userdetails.User user=new org.springframework.security.core.userdetails.User(
                details.getUsername(),details.getPassword(), details.getRole().stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));

        System.out.println("3####### "+user);

        return user;
    }




}
