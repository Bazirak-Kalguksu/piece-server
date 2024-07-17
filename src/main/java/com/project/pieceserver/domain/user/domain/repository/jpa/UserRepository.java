package com.project.pieceserver.domain.user.domain.repository.jpa;

import com.project.pieceserver.domain.user.domain.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

    UserEntity getByEmail(String email);

}
