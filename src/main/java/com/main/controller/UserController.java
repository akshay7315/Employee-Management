package com.main.controller;

import com.main.dao.Userrepo;
import com.main.entity.User_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private Userrepo u1;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returns login.html template
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Returns register.html template
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username,
                                 @RequestParam String password) {
        User_1 user = new User_1();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole("USER"); // Set role for new user (could also be ADMIN if needed)
        u1.save(user);
        return "redirect:/login"; // Redirect to login after registration
    }

    @GetMapping("/project")
    public String showProjectPage() {
        return "redirect:/home"; // Returns project page after login
    }
}
