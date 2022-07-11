package com.krishantha.rentcloud.authorizationserver.controller;

import com.krishantha.rentcloud.authorizationserver.model.OauthClientDetails;
import com.krishantha.rentcloud.authorizationserver.model.User;
import com.krishantha.rentcloud.authorizationserver.repository.UserRepository;
import com.krishantha.rentcloud.authorizationserver.service.ClientService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class UserController {

    @Autowired
    ClientService clientService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/add")
    public String saveClientDetails (@RequestParam int userId) throws Exception {

        System.out.println("in controller ");
        // Check If client already exists
        if(clientService.countById(userId) > 0) {
                throw new Exception("already exist");

        }


        OauthClientDetails clientDetails = new OauthClientDetails();


        // Generate Client ID
        UUID randomId = UUID.randomUUID();

        String uuidAsString = randomId.toString();

        clientDetails.setClientId(uuidAsString.toString());


        // Generate Client Secret

        UUID randomSecret = UUID.randomUUID();

        String uuidAsString1 = randomSecret.toString();
        clientDetails.setClientSecret("123");


        clientDetails.setUserId(userId);
        clientDetails.setResourceIds("inventory,payment");

        clientDetails.setAccessTokenValidity(6400);
        clientDetails.setScope("Read");

// uri where authorization code will be sent
        clientDetails.setWebServerRedirectUri("dhgfhgh");

        clientDetails.setAuthorizedGrantTypes("authorization_code,password,refresh_token,implicit");

        clientDetails.setUserId(userId);

        clientService.save(clientDetails);


        return "successfully";

    }


    @GetMapping("/get")
    public OauthClientDetails getOAuthClient(@RequestParam int userId) {

        System.out.println("id " + userId);

        Optional<OauthClientDetails> clientDetails = clientService.findByuserId(userId);

        clientDetails.orElseThrow(()->new RuntimeException("User not found "));

        return  clientDetails.get();
    }

    @PostMapping("/add_user")
    public User createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }


}
