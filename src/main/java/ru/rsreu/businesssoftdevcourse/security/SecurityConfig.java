package ru.rsreu.businesssoftdevcourse.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    private final SecurityPropertiesConfig securityPropertiesConfig;

    @Autowired
    public SecurityConfig(
            UserDetailsService userDetailsService,
            SecurityPropertiesConfig securityPropertiesConfig
    ) {
        this.userDetailsService = userDetailsService;
        this.securityPropertiesConfig = securityPropertiesConfig;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(encoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authenticationProvider(authenticationProvider())
                .authorizeRequests()
                .antMatchers("/work-order/**").hasAuthority("USER")
                .and()
                .formLogin()
                .loginPage(securityPropertiesConfig.getLoginPageUrl())
                .and().build();
    }
}
