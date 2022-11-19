package ru.rsreu.businesssoftdevcourse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rsreu.businesssoftdevcourse.dao.UserRepository;
import ru.rsreu.businesssoftdevcourse.security.User;

import javax.validation.Valid;

@Controller
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        LOGGER.debug("Auth controller login page called");
        return "login";
    }

    @GetMapping("/reg")
    public String getRegistrationPage(Model model) {
        model.addAttribute(new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String performRegistration(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
