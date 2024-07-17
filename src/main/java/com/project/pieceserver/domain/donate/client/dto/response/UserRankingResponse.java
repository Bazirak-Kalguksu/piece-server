package com.project.pieceserver.domain.donate.client.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UserRankingResponse {

    private String name;
    private Integer totalPoints;

    @QueryProjection
    public UserRankingResponse(String name, Integer totalPoints) {
        this.name = name;
        this.totalPoints = totalPoints;
    }

}
