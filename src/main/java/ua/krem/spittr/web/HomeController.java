package ua.krem.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/30/2016
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    //Logout mapping
    @RequestMapping("/logout")
    public String showLoggedOut(){
        return "logout";
    }
}
