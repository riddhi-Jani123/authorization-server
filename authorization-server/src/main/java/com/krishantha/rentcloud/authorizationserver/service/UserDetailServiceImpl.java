package com.krishantha.rentcloud.authorizationserver.service;

import com.krishantha.rentcloud.authorizationserver.model.AuthUserDetail;
import com.krishantha.rentcloud.authorizationserver.model.User;
import com.krishantha.rentcloud.authorizationserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("koskxos");
        Optional<User> optionalUser = userDetailRepository.findByUsername(name);
        System.out.println("user:"+optionalUser.get().getUsername());
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
         new AccountStatusUserDetailsChecker().check(userDetails);

        System.out.println("token:        !!!!!!!!!!!!!!!!!!!!!1");
        System.out.println(userDetails.getAuthorities());
        return userDetails;


    }
}
