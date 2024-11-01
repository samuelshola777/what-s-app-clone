package com.example.what.s_app_clone.chat;
import lombok.Data;

import java.util.List;

import com.example.what.s_app_clone.appUser.data.model.AppUser;

import java.time.LocalDateTime;

@Data
public class ChatRoom {
    private String id;
    private List<AppUser> participants;
    private List<ChatMessage> messages;
    private LocalDateTime lastMessageTimestamp;
    private String name;
    private boolean isGroupChat;
    private String groupPicture;
    
}
