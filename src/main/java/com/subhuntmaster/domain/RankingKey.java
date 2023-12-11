package com.subhuntmaster.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class RankingKey implements Serializable{

    @Column(name = "competition_id")
    private Long competitionId;
    @Column(name = "member_id")
    private Long memberId;
}
