package kg.itschool.demo.controller;

import kg.itschool.demo.dao.PassengerDAO;
import kg.itschool.demo.dao.dto.RegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class PassengerController{

    @Autowired
    private PassengerDAO passengerDAO;

    @RequestMapping("/passenger-registration")
    public String showRegistrationForm(){
        return "passenger-registration";
    }
    @RequestMapping("/passenger-added")
    public String passengerAdded(){
        return "passenger-added";
    }

}
