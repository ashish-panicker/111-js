package in.stackroute.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import in.stackroute.web.model.LoginViewModel;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginViewModel", new LoginViewModel());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginViewModel loginViewModel) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginViewModel", loginViewModel);
        System.out.println(loginViewModel);
        return modelAndView;
    }


}
