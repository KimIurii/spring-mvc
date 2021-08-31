package kg.itschool.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String showGreetingMenu(){
        return "greeting-form";
    }

    @RequestMapping("/process-form")
    public String processForm(HttpServletRequest request, Model model){
        // read parameters from html/jsp form
        String firstName = request.getParameter("firstName");

        // Capitalize the name
        firstName = Character.toUpperCase(firstName.charAt(0))+firstName.substring(1).toLowerCase();

        //Add greeting to value
        firstName = "Hello "+firstName+" !";

        model.addAttribute("greetingMessage",firstName);


        return "process-form";
    }


}
