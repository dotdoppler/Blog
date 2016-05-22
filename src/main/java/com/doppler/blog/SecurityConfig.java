//package com.doppler.blog;
//
//import com.doppler.blog.Service.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//
///**
// * Created by doppler on 2016/5/12.
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//    @Bean
//    public UserService userService(){
//        return new UserService();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new StandardPasswordEncoder();
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .antMatchers("/admin/**").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/signin")
//                .permitAll()
//                .failureUrl("/signin?error=1")
//                .loginProcessingUrl("/authenticate")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .permitAll()
//                .logoutSuccessUrl("/signin?logout")
//                .and()
//                .csrf().disable();
////                .and()
////                .rememberMe()
////                .rememberMeServices(rememberMeServices())
////                .key("remember-me-key");
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userService()).passwordEncoder(passwordEncoder());
//    }
//}
