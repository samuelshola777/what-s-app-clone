package com.example.what.s_app_clone.appUser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.what.s_app_clone.appUser.data.dtos.request.LoginAppUserRequest;
import com.example.what.s_app_clone.appUser.data.dtos.request.RegisterAppUserRequest;
import com.example.what.s_app_clone.appUser.service.interphaces.AppUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/app-user/")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAppUser(@RequestBody RegisterAppUserRequest request){
        return ResponseEntity.ok(appUserService.registerAppUser(request));
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateAppUser(@RequestBody RegisterAppUserRequest request){
        return ResponseEntity.ok(appUserService.updateAppUser(request));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppUser(@PathVariable String id){
        return ResponseEntity.ok(appUserService.deleteAppUser(id));
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllAppUsers(){
        return ResponseEntity.ok(appUserService.getAllAppUsers());
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getAppUserById(@PathVariable String id){
        return ResponseEntity.ok(appUserService.getAppUserById(id));
    }
    @GetMapping("/get-by-username/{username}")
    public ResponseEntity<?> getAppUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(appUserService.getAppUserByUsername(username));
    }
    @GetMapping("/get-by-phone-number/{phoneNumber}")
    public ResponseEntity<?> getAppUserByPhoneNumber(@PathVariable String phoneNumber){
        return ResponseEntity.ok(appUserService.getAppUserByPhoneNumber(phoneNumber));
    }
    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<?> getAppUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(appUserService.getAppUserByEmail(email));
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginAppUser(@RequestBody LoginAppUserRequest request){
        return ResponseEntity.ok(appUserService.loginAppUser(request));
    }
    @PostMapping("/logout/{email}")
    public ResponseEntity<?> logoutAppUser(@PathVariable String email){
        return ResponseEntity.ok(appUserService.logoutAppUser(email));
    }
}
