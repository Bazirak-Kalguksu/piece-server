package com.project.pieceserver.domain.donate.client.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UserRankingResponse {

    private String email;
    private Integer totalPoints;

    @QueryProjection
    public UserRankingResponse(String email, Integer totalPoints) {
        this.email = email;
        this.totalPoints = totalPoints;
    }

}
