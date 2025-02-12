package com.example.profile_service.controller;

import com.example.profile_service.dto.request.UserProfileCreationRequest;
import com.example.profile_service.dto.response.UserProfileCreationResponse;
import com.example.profile_service.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping
    UserProfileCreationResponse createProfile(@RequestBody UserProfileCreationRequest request) {
        return userProfileService.createProfile(request);
    }

    @GetMapping("/{userProfileId}")
    UserProfileCreationResponse getProfile(@PathVariable String userProfileId) {
        return userProfileService.getUserProfileById(userProfileId);
    }
}
