package com.example.what.s_app_clone.appUser.data.dtos.request;

import lombok.Data;

@Data
public class RegisterAppUserRequest {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
