package in.stackroute.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import in.stackroute.web.model.ViewProperties;

/**
 * Create a controller in Spring MVC: 1. Create a controller class called HomeController. 2.
 * Annotate the class with @Controller.
 */

@Controller
public class HomeController {

    // @Autowired
    private ViewProperties viewProperties;

    // constructor injection by spring
    public HomeController(ViewProperties viewProperties) {
        this.viewProperties = viewProperties;
    }

    // GET -> /index
    @GetMapping({"/index", "/"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        viewProperties.setMessage("Welcome to Spring MVC Programming");
        viewProperties.setTitle("Home Page");
        modelAndView.addObject("viewProperties", viewProperties);
        return modelAndView;
    }

    // GET -> /about
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        viewProperties.setMessage("This is the about page");
        viewProperties.setTitle("About Page");
        modelAndView.addObject("viewProperties", viewProperties);
        return modelAndView;
    }
}
