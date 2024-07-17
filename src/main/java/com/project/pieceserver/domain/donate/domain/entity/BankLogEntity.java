package com.project.pieceserver.domain.donate.domain.entity;

import com.project.pieceserver.global.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "tb_bank_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BankLogEntity extends BaseTimeEntity {

    @Id
    private String email;

    private int money;

}
