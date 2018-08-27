package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.groups.Default;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("")
    public String login(Model model){
        model.addAttribute("tweets", tweetRepository.findAllOrderByCreatedDesc());
        model.addAttribute("user", new User());
        return "login/form";
    }

    @PostMapping("")
    public String login(@Validated({Default.class}) User user, BindingResult result, HttpSession ses, Model model){
        if(result.hasErrors()){
            return "login/form";
        }
        else {
            if(userService.checkEmail(user.getEmail(), user.getPassword())){
            User loggedUser = userRepository.findByEmail(user.getEmail());
            ses.setAttribute("id",loggedUser.getId());
            }
            else
            {
                model.addAttribute("wrongData", "true");
                return "login/form";
            }

            return "redirect:/user/main";
        }
    }
}
