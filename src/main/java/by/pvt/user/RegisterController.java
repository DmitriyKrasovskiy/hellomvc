package by.pvt.user;

import by.pvt.pojo.AppUser;
import by.pvt.pojo.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static Logger log = Logger.getLogger("RegisterController");

    @Autowired
    UserService userService;

    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("roles", userService.getAllRoles());
        return "registerUser";
    }

    @PostMapping
    public String registerForm(@ModelAttribute AppUser user,
                               @RequestParam("role") RoleName role) {
        log.info("Request param role=" + role);
        if (!userService.saveNewUser(user, role)) {
            return "error";
        }
        return "redirect:home";
    }

}