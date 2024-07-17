package com.project.pieceserver.domain.donate.service;

import com.project.pieceserver.domain.donate.client.dto.BankLog;
import com.project.pieceserver.domain.donate.domain.repository.jpa.BankLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankLogService {

    private final BankLogRepository bankLogRepository;
    private final BankLog bankLogDTO;

    public void saveBankLog(BankLog bankLog) {
        bankLogRepository.save(bankLogDTO.toEntity(bankLog));
    }

}
