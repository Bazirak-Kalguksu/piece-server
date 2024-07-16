package com.project.pieceserver.domain.user.domain.repository.jpa;

import com.project.pieceserver.domain.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
