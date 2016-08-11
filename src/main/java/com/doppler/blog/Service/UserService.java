package com.doppler.blog.Service;

import com.doppler.blog.GlobalConstants;
import com.doppler.blog.models.User;
import com.doppler.blog.repositories.UserRepository;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * Created by doppler on 2016/5/21.
 */
@Service
public class UserService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Bean
    private PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    @Resource
    private UserRepository userRepository;

    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return  Preconditions.checkNotNull(user,username + " Not Found");
    }

    public User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || auth instanceof AnonymousAuthenticationToken){
            return null;
        }
        String username = ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername();
        return userRepository.findByUsername(username);
    }
    public void changePassword(User user,String password, String newPassword){

        if (passwordEncoder().matches(password,user.getPassword())) {
            user.setPassword(passwordEncoder().encode(newPassword));
            userRepository.save(user);
            logger.info(GlobalConstants.UPDATEPWD.value());
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException("User Not Found");

        return createSpringUser(user);
    }
    private org.springframework.security.core.userdetails.User createSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(createAuthority(user)));
    }

    private GrantedAuthority createAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }
}
