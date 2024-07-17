package com.project.pieceserver.domain.donate.domain.repository.jpa;

import com.project.pieceserver.domain.donate.domain.entity.PointLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointLogRepository extends JpaRepository<PointLogEntity, String> {
}
