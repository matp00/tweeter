package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        String hashedPassword = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public boolean checkEmail(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user != null){
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }

    public User getLogedUser(){
        //how to get data from session??
        return null;
    }

    public boolean checkEmail(String email){
        List<String> emails = userRepository.getAllEmails();
        for(String line: emails){
            if(email.equals(line))
                return true;
        }
        return false;
    }

}
