package ru.rsreu.businesssoftdevcourse.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationDto {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
