package com.doppler.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by doppler on 2016/5/29. error handler for the app
 */
@ControllerAdvice
public class GlobalExceptionController {
    //handle Not Found Exception
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(HttpServletRequest request,NotFoundException ex){
        ModelAndView model = new ModelAndView("error/generic_error");
        model.addObject("path", request.getRequestURI());
        model.addObject("status",HttpStatus.NOT_FOUND.value());
        model.addObject("error",HttpStatus.NOT_FOUND.getReasonPhrase());
        return model;
    }

    //handle All Exceptions
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest request,Exception ex){
        ModelAndView model = new ModelAndView("error/generic_error");
        model.addObject("path", request.getRequestURI());
        model.addObject("status",ex.getMessage());
        model.addObject("error",ex.getCause());
        return model;
    }


}
