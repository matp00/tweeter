package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/main")
    public String start(Model model, HttpSession ses){
        model.addAttribute("tweets", tweetRepository.findAllOrderByCreatedDesc());
        model.addAttribute("tweet", new Tweet());
        return "user/main";
    }

    @PostMapping("/main")
    public String start(@ModelAttribute Tweet tweet, HttpSession ses, Model model){
        if(tweet.getText() != null){
            tweet.setUser(userRepository.findById((Long)ses.getAttribute("id")));
            tweetRepository.save(tweet);
            model.addAttribute("tweets", tweetRepository.findAllOrderByCreatedDesc());
            model.addAttribute("tweet", new Tweet());
            return "user/main";

        }
        return "user/main";
    }

    @GetMapping("/main/{id}")
    public String userMain(@PathVariable Long id, Model model){
        model.addAttribute(tweetRepository.findAllByUserIdOrderByCreatedDesc(id));

        return "user/main";
    }

}
