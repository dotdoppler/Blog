package com.doppler.blog.Service;

import com.doppler.blog.models.User;
import com.doppler.blog.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by doppler on 2016/5/29.
 */
@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return buildUserForAuthentication(user,authorities);
    }

    private org.springframework.security.core.userdetails.User
    buildUserForAuthentication(User user, List<GrantedAuthority> grantedAuthorities){
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,
        true,true,true,grantedAuthorities);
    }
}
