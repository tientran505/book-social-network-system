package com.example.profile_service.mapper;

import com.example.profile_service.dto.request.UserProfileCreationRequest;
import com.example.profile_service.dto.response.UserProfileCreationResponse;
import com.example.profile_service.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileCreationRequest request);
    UserProfileCreationResponse toUserProfileCreationResponse(UserProfile userProfile);
}
