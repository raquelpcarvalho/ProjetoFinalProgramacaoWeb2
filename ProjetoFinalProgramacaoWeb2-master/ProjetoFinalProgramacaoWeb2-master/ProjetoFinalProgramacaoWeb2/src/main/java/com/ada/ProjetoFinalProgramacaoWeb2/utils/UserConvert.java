package com.ada.ProjetoFinalProgramacaoWeb2.utils;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static User toEntity(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setCpf(userRequest.getCpf());
        return user;
    }

    public static UserResponse toResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

    public static List<UserResponse> toResponseList(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users){
            UserResponse userResponse = UserConvert.toResponse(user);
            userResponses.add(userResponse);
        }
        return userResponses;
        //return users.stream().map(user -> UserConvert.toResponse(user)).collect(Collectors.toList());
    }


    public static Page<UserResponse> toResponsePage(Page<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users){
            UserResponse userResponse = UserConvert.toResponse(user);
            userResponses.add(userResponse);
        }
        return new PageImpl<>(userResponses);
    }

}
