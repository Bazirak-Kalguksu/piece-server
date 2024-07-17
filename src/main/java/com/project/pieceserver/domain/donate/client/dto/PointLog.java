package com.project.pieceserver.domain.donate.client.dto;

import com.project.pieceserver.domain.donate.domain.entity.BankLogEntity;
import com.project.pieceserver.domain.donate.domain.entity.PointLogEntity;
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
public class PointLog {

    private String email;
    private int point;

    public PointLogEntity toEntity(PointLog pointLog){
        return PointLogEntity.builder()
                .email(pointLog.getEmail())
                .point(pointLog.getPoint())
                .build();
    }

    public PointLog toPointLog (PointLogEntity pointLogEntity){
        return PointLog.builder()
                .email(pointLogEntity.getEmail())
                .point(pointLogEntity.getPoint())
                .build();
    }

}
