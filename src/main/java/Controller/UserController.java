package Controller;

import Repository.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PatchMapping("/{id}")
    public User updateUserAge(@PathVariable Long id,
                              @RequestParam Integer age) {
        User user = userRepository.findById(id).get();
        user.setAge(age);
        return userRepository.saveAndFlush(user);
    }


}
