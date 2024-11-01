package com.example.what.s_app_clone.appUser.service.implementations;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.what.s_app_clone.appUser.data.dtos.request.LoginAppUserRequest;
import com.example.what.s_app_clone.appUser.data.dtos.request.RegisterAppUserRequest;
import com.example.what.s_app_clone.appUser.data.dtos.response.LoginAppUserResponse;
import com.example.what.s_app_clone.appUser.data.dtos.response.RegisterAppUserResponse;
import com.example.what.s_app_clone.appUser.data.model.AppUser;
import com.example.what.s_app_clone.appUser.data.repository.AppUserRepository;
import com.example.what.s_app_clone.appUser.service.interphaces.AppUserService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AppUserServiceIMPL implements AppUserService {
    private final AppUserRepository appUserRepository;

    // @Value("${app.user.default-profile-picture}")
    // private String defaultProfilePicture;

    @Override
    public RegisterAppUserResponse registerAppUser(RegisterAppUserRequest request) {
           if(ifUserExist(request.getUsername(), request.getEmail(), request.getPhoneNumber())){
            throw new RuntimeException("User already exists");
           }
           validateUserValueInput(request);
           AppUser user = AppUser.builder()
                   .username(request.getUsername())
                   .password(request.getPassword()) 
                   .email(request.getEmail())
                   .phoneNumber(request.getPhoneNumber())
                   .build();
           AppUser savedUser = appUserRepository.save(user.getEmail(), user);
           return RegisterAppUserResponse.builder()
                   .message("User registered successfully")
                   .email(savedUser.getEmail())
                   .phoneNumber(savedUser.getPhoneNumber())
                   .profilePicture(savedUser.getProfilePicture())
                   .bio(savedUser.getBio())
                   .status(savedUser.getStatus())
                   .lastActive(savedUser.getLastActive())
                   .build();
    }

    @Override
    public LoginAppUserResponse loginAppUser(LoginAppUserRequest request) {
        if(ifUserExist(request.getUsername(), request.getPassword())){
            throw new RuntimeException("User does not exist");
        }
        AppUser user = appUserRepository.findById(request.getUsername());
        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return LoginAppUserResponse.builder()
                .message("User logged in successfully")
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .profilePicture(user.getProfilePicture())
                .bio(user.getBio())
                .status(user.getStatus())
                .lastActive(user.getLastActive())
                .build();
    }

    @Override
    public RegisterAppUserResponse updateAppUser(RegisterAppUserRequest request) {
        if(ifUserExist(request.getUsername(), request.getEmail(), request.getPhoneNumber())){
            throw new RuntimeException("User does not exist");
        }
        AppUser user = appUserRepository.findById(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        AppUser savedUser = appUserRepository.save(user.getEmail(), user);
        return RegisterAppUserResponse.builder()
                .message("User updated successfully")
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .build();
    }

    @Override
    public RegisterAppUserResponse deleteAppUser(String id) {
        appUserRepository.deleteById(id);
        return RegisterAppUserResponse.builder()
                .message("User deleted successfully")
                .build();
    }
    @Override
    public RegisterAppUserResponse getAppUserById(String id) {
        AppUser user = appUserRepository.findById(id);
        return RegisterAppUserResponse.builder()
                .message("User retrieved successfully")
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    @Override
    public RegisterAppUserResponse getAppUserByUsername(String username) {
        AppUser user = appUserRepository.findById(username);
        return RegisterAppUserResponse.builder()
                .message("User retrieved successfully")
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    @Override
    public Set<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }
    @Override
    public RegisterAppUserResponse getAppUserByPhoneNumber(String phoneNumber) {
        AppUser user = appUserRepository.findById(phoneNumber);
        return RegisterAppUserResponse.builder()
                .message("User retrieved successfully")
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    @Override
    public RegisterAppUserResponse getAppUserByEmail(String email) {
        AppUser user = appUserRepository.findById(email);
        return RegisterAppUserResponse.builder()
                .message("User retrieved successfully")
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    @Override
    public RegisterAppUserResponse logoutAppUser(String email) {
        AppUser user = appUserRepository.findById(email);
        user.setStatus("offline");
        AppUser savedUser = appUserRepository.save(user.getEmail(), user);
        return RegisterAppUserResponse.builder()
                .message("User logged out successfully")
                .build();
    }

    private boolean ifUserExist(String ids, String username,  String phoneNumber){
         if(appUserRepository.existsByAnyId(ids)){
            throw new RuntimeException("User with id " + ids + " already exists");
         }
         if(appUserRepository.existsByUsername(username)){
            throw new RuntimeException("User with username " + username + " already exists");
         }
         if(appUserRepository.existsByUsername(phoneNumber)){
            throw new RuntimeException("User with phone number " + phoneNumber + " already exists");
         }
         return false;
    }
    private boolean ifUserExist(String ids, String username){
         if(appUserRepository.existsByAnyId(ids)){
            throw new RuntimeException("User with id " + ids + " already exists");
         }
         if(appUserRepository.existsByUsername(username)){
            throw new RuntimeException("User with username " + username + " already exists");
         }
         
         return false;
    }
    private void validateUserValueInput(RegisterAppUserRequest request){
        if(request.getUsername().isEmpty()){
            throw new RuntimeException("Username cannot be empty");
        }
        if(request.getPassword().isEmpty()){
            throw new RuntimeException("Password cannot be empty");
        }
        if(request.getEmail().isEmpty()){
            throw new RuntimeException("Email cannot be empty");
        }
        if(request.getPhoneNumber().isEmpty()){
            throw new RuntimeException("Phone number cannot be empty");
        }
    }
}
