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
    private String name;
    private int point;

    public PointLogEntity toEntity(PointLog pointLog){
        return PointLogEntity.builder()
                .email(pointLog.getEmail())
                .name(pointLog.getName())
                .point(pointLog.getPoint())
                .build();
    }

    public PointLog toPointLog (PointLogEntity pointLogEntity){
        return PointLog.builder()
                .email(pointLogEntity.getEmail())
                .name(pointLogEntity.getName())
                .point(pointLogEntity.getPoint())
                .build();
    }

}
