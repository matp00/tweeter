package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.LoginValidator;

import javax.validation.Valid;
@Controller
public class RegisterController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "register/form";
    }

    @PostMapping("/register")
    public String login(@Validated({LoginValidator.class}) User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "register/form";
        }
        if(userService.checkEmail(user.getEmail())){
            model.addAttribute("checkEmail", "true");
            return "register/form";
        }
        userService.addUser(user);
        return "redirect:/user/main";

    }
}
