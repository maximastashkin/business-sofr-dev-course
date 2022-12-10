package ru.rsreu.businesssoftdevcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rsreu.businesssoftdevcourse.dao.UserRepository;
import ru.rsreu.businesssoftdevcourse.security.User;

import javax.validation.Valid;

@RestController
@Validated
public class RegistrationController {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegistrationDto registrationDto) {
        userRepository.save(new User(registrationDto.getUsername(),
                passwordEncoder.encode(registrationDto.getPassword())));
    }
}
