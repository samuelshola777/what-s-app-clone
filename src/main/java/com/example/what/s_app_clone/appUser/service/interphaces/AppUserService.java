package com.example.what.s_app_clone.appUser.service.interphaces;

import java.util.Set;

import com.example.what.s_app_clone.appUser.data.dtos.request.LoginAppUserRequest;
import com.example.what.s_app_clone.appUser.data.dtos.request.RegisterAppUserRequest;
import com.example.what.s_app_clone.appUser.data.dtos.response.LoginAppUserResponse;
import com.example.what.s_app_clone.appUser.data.dtos.response.RegisterAppUserResponse;
import com.example.what.s_app_clone.appUser.data.model.AppUser;

public interface AppUserService {

    RegisterAppUserResponse registerAppUser(RegisterAppUserRequest request);
    LoginAppUserResponse loginAppUser(LoginAppUserRequest request);
    RegisterAppUserResponse updateAppUser(RegisterAppUserRequest request);
    RegisterAppUserResponse deleteAppUser(String id);
    Set<AppUser> getAllAppUsers();
    RegisterAppUserResponse getAppUserById(String id);
    RegisterAppUserResponse getAppUserByUsername(String username);
    RegisterAppUserResponse getAppUserByPhoneNumber(String phoneNumber);
    RegisterAppUserResponse getAppUserByEmail(String email);
    RegisterAppUserResponse logoutAppUser(String email);
}   
