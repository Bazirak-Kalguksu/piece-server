package com.project.pieceserver.domain.donate.domain.repository.jpa;

import com.project.pieceserver.domain.donate.domain.entity.BankLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankLogRepository extends JpaRepository<BankLogEntity, String> {
}
