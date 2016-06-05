package com.doppler.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by doppler on 2016/6/1.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public ExecuteTimeinterceptor executeTimeinterceptor(){
//        return new ExecuteTimeinterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(executeTimeinterceptor());
//    }
}
