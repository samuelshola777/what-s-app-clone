package com.example.what.s_app_clone.appUser.data.dtos.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterAppUserResponse {
    private String message;
    private String email;
    private String phoneNumber;
    private String profilePicture;
    private String bio;
    private String status;
    private LocalDateTime lastActive;
}
