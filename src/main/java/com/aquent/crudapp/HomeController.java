package com.aquent.crudapp;

import com.aquent.crudapp.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Simple controller to redirect to the person listing.  In the future, we could
 * add other landing page behavior here if we were writing a real application.
 */
@Controller
public class HomeController {
    /**
     * Redirect to the home page.
     * In a real application this could be our landing or login page.
     *
     * @return redirect to the home page
     */
// TODO: original below
//    @GetMapping("/")
//    public String index() {
//        return "redirect:/home";
//    }
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/home");
    }
}
