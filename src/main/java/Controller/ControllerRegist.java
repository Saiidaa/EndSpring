package Controller;

import entity.User;
import entity.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@ComponentScan
@RestController

public class ControllerRegist {

    @Autowired
    private UserS userS;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addU(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordCon())){
            model.addAttribute("Error password", " не совпадают пароли");
            return "registration";
        }

        if (!userS.saveU(userForm)){
            model.addAttribute("Error username", "Уже существует Пользователь с таким именем ");
            return "registration";
        }

        return "redirect:/";
    }



}
