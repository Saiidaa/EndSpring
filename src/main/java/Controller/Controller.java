package Controller;

import entity.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController


public class Controller {
    @Autowired
    private UserS userS;

    @GetMapping ("/user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userS.allUsers());
        return "admin";
    }


    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action, Model model) {
        if (action.equals("delete")){
            userS.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userS.UList(userId));
        return "admin";
    }

}
