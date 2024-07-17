package com.project.pieceserver.domain.campaign.domain.repository.query;

import com.project.pieceserver.domain.campaign.client.dto.Campaign;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.pieceserver.domain.campaign.domain.entity.QCampaignEntity.campaignEntity;

@Repository
@RequiredArgsConstructor
public class CampaignQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Campaign> campaignList(PageRequest request){
        return jpaQueryFactory
                .select(campaignConstructorExpression())
                .from(campaignEntity)
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
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

}
