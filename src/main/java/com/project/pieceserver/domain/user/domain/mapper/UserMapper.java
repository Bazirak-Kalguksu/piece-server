package com.project.pieceserver.domain.user.domain.mapper;

import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

//@Mapper
@Component
public class UserMapper {

    public UserEntity toEdit(User user){
        return UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .birth(user.getBirth())
                .build();
    }
}
