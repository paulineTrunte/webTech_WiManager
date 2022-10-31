package de.htwberlin.webtech.wiManager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping(path = "/")
    public ModelAndView displayHello(){
        return new ModelAndView("helloWorld");
    }

}
