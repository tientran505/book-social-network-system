package com.example.profile_service.service;

import com.example.profile_service.dto.request.UserProfileCreationRequest;
import com.example.profile_service.dto.response.UserProfileCreationResponse;
import com.example.profile_service.entity.UserProfile;
import com.example.profile_service.mapper.UserProfileMapper;
import com.example.profile_service.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileCreationResponse createProfile(UserProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileCreationResponse(userProfile);
    }

    public UserProfileCreationResponse getUserProfileById(String id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found"));
        return userProfileMapper.toUserProfileCreationResponse(userProfile);
    }
}
