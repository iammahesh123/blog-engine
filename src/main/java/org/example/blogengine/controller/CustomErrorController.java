package org.example.blogengine.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        // Return generic error page
        return "error";
    }

    @GetMapping("/403")
    public String accessDenied() {
        // Return 403 error page
        return "403";
    }


    public String getErrorPath() {
        return "/error";
    }
}

