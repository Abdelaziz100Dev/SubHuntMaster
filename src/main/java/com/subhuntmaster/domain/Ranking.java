package com.subhuntmaster.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
public class Ranking implements Serializable {

    @EmbeddedId
    private RankingKey id;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    Competition competition;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    Member member;

    int rank;
    int score;

}
