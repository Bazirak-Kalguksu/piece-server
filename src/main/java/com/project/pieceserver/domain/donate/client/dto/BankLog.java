package com.project.pieceserver.domain.donate.client.dto;

import com.project.pieceserver.domain.donate.domain.entity.BankLogEntity;
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
public class BankLog {

    private String email;
    private int money;

    public BankLogEntity toEntity(BankLog bankLog){
        return BankLogEntity.builder()
                .email(bankLog.getEmail())
                .money(bankLog.getMoney())
                .build();
    }

    public BankLog toBankLog(BankLogEntity bankLogEntity){
        return BankLog.builder()
                .email(bankLogEntity.getEmail())
                .money(bankLogEntity.getMoney())
                .build();
    }
}
