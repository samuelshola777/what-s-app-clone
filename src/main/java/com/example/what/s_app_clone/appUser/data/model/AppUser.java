package com.example.what.s_app_clone.appUser.data.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String profilePicture;
    private String bio;
    private String status;
    private LocalDateTime lastActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
    private boolean isActive;
    private boolean isLocked;
    private boolean isOnline;
    
}
