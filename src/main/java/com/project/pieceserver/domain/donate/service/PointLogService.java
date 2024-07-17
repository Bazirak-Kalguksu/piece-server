package com.project.pieceserver.domain.donate.service;

import com.project.pieceserver.domain.donate.client.dto.PointLog;
import com.project.pieceserver.domain.donate.domain.repository.jpa.PointLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointLogService {

    private final PointLogRepository pointLogRepository;
    private final PointLog pointLogDTO;

    public void savePointLog(PointLog pointLog) {
        pointLogRepository.save(pointLogDTO.toEntity(pointLog));
    }

}
