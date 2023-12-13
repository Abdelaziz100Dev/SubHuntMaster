package com.subhuntmaster.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "rankings")
public class Ranking {

    @EmbeddedId
    private RankingKey id = new RankingKey();
    @Column(name = "`rank`")
    private Integer rank;
    private Integer score;

    @ManyToOne
    @MapsId("competitionCode")
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;



}
