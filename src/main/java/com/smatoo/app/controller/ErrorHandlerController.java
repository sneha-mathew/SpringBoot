package com.smatoo.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

@Controller
public class ErrorHandlerController implements ErrorController{

	
    public String getErrorPath() {
        return "/error";
    }
}
