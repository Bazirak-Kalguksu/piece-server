package com.project.pieceserver.domain.campaign.domain.repository.query;

import com.project.pieceserver.domain.campaign.client.dto.Campaign;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import com.project.pieceserver.global.exception.BadRequestException;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.pieceserver.domain.campaign.domain.entity.QCampaignEntity.campaignEntity;

@Repository
@RequiredArgsConstructor
public class CampaignQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Campaign> campaignList(int page, int size){
        return jpaQueryFactory
                .select(campaignConstructorExpression())
                .from(campaignEntity)
                .offset((long) (page - 1) * size)
                .limit(size)
                .orderBy(campaignEntity.idx.asc())
                .fetch();
    }

    public List<Campaign> campaignSearch(int page, int size, String title){
        return jpaQueryFactory
                .select(campaignConstructorExpression())
                .from(campaignEntity)
                .where(eqName(title))
                .offset((long) (page - 1) * size)
                .limit(size)
                .orderBy(campaignEntity.idx.asc())
                .fetch();
    }

    private ConstructorExpression<Campaign> campaignConstructorExpression(){
        return Projections.constructor(Campaign.class,
                campaignEntity.idx,
                campaignEntity.title,
                campaignEntity.description,
                campaignEntity.imageUrl
        );
    }

    private BooleanExpression eqName(String title) {
        if(title.isBlank()){
            throw BadRequestException.EXCEPTION;
        }
        return campaignEntity.title.eq(title);
    }

}
