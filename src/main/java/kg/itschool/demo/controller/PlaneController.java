package kg.itschool.demo.controller;

import kg.itschool.demo.dao.PlaneDAO;
import kg.itschool.demo.entity.Plane;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class PlaneController {
    @Autowired
    private final PlaneDAO planeDAO;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/add-plane")
    public String addPlaneForm(Model model){
        model.addAttribute("plane",new Plane());

        return "add-plane-form";
    }

    @RequestMapping("/plane-added")
    public String planeAddedForm(@Valid @ModelAttribute("plane") Plane plane, Model model, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "add-plane-form";
        }else {
            planeDAO.addPlane(plane);
            model.addAttribute("company", "Company owner: " + plane.getCompany());
            model.addAttribute("model", "Model of plane: " + plane.getModel());
            model.addAttribute("seats", "Number of seats available: " + plane.getSeats());
            return "plane-added-form";
        }
    }


}
