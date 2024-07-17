package com.project.pieceserver.domain.user.client.dto;

import com.project.pieceserver.domain.user.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String password;
    private String name;
    private String birth;

    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .birth(user.getBirth())
                .build();
    }

    public User toUser(UserEntity userEntity){
        return User.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .birth(userEntity.getBirth())
                .build();
    }

}
