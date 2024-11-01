package com.example.what.s_app_clone.appUser.data.repository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.what.s_app_clone.appUser.data.model.AppUser;

@Repository
public class AppUserRepository {
    
    private final HashMap<String, AppUser> userMap = new HashMap<>();
    
    public AppUser save(String id, AppUser user) {
        return userMap.put(id, user);
    }
    
    public AppUser findById(String id) {
        return userMap.get(id);
    }
    
    public Set<AppUser> findAll() {
        return new HashSet<>(userMap.values());
    }
    
    public void deleteById(String id) {
        userMap.remove(id);
    }
    
    public HashMap<String, AppUser> getUserMap() {
        return userMap;
    }
    public boolean existsByAnyId(String... ids) {
        for (String id : ids) {
            if (userMap.containsKey(id)) {
                return true;
            }
        }
        return false;
    }
    public boolean existsByUsername(String username){
        return userMap.values().stream()
        .anyMatch(user -> user.getUsername().equals (username));
    }
    public boolean existsByPhoneNumber(String phoneNumber){
        return userMap.values().stream()
        .anyMatch(user -> user.getPhoneNumber().equals (phoneNumber));
    }
}
