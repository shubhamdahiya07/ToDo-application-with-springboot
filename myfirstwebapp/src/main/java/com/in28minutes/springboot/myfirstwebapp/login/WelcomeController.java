package com.in28minutes.springboot.myfirstwebapp.login;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController { // Use a more conventional class name
 
    @GetMapping("/") // Use @GetMapping for conciseness
    public String gotoWelcomePage(ModelMap model) { // Use a descriptive method name
    	model.put("name", getLoggedinUsername());
        return "welcome";
    }
    private String getLoggedinUsername() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	return authentication.getName();
    }
}
