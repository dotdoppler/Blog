package com.doppler.blog.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by doppler on 2016/6/1.
 */

public class ExecuteTimeinterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(ExecuteTimeinterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        modelAndView.addObject("executeTime", executeTime);
        logger.info("[" + request.getRemoteAddr() + "-request :" +
                request.getRequestURI() + "] executeTime : " + executeTime + " ms");
    }
}
