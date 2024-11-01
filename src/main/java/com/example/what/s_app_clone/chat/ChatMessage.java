package com.example.what.s_app_clone.chat;

import java.time.LocalDateTime;

import com.example.what.s_app_clone.appUser.data.model.AppUser;

import lombok.Data;

@Data
public class ChatMessage {
   

    private String content;
    private ChatEnum contentType;
    private AppUser sender;
    private LocalDateTime timestamp;
}
