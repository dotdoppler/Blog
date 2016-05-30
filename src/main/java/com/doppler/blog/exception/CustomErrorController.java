package com.doppler.blog.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by doppler on 2016/5/30.
 */
@Controller
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = PATH)
    public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("error/generic_error");
        model.addObject("path", request.getRequestURI());
        model.addObject("status",response.getStatus());
        model.addObject("error",HttpStatus.NOT_FOUND.getReasonPhrase());
        return model;
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
