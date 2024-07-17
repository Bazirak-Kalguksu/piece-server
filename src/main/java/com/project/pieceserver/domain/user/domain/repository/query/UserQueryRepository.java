package com.project.pieceserver.domain.user.domain.repository.query;

import com.project.pieceserver.domain.donate.client.dto.response.QUserRankingResponse;
import com.project.pieceserver.domain.donate.client.dto.response.UserRankingResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.pieceserver.domain.donate.domain.entity.QPointLogEntity.pointLogEntity;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<UserRankingResponse> findUserRankings(int page, int size) {
        return jpaQueryFactory
                .select(new QUserRankingResponse(pointLogEntity.email, pointLogEntity.point.sum()))
                .from(pointLogEntity)
                .offset((long) (page - 1) * size)
                .limit(size)
                .groupBy(pointLogEntity.email)
                .orderBy(pointLogEntity.point.sum().desc())
                .fetch();
    }

}
