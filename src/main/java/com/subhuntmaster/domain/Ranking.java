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
    private RankingKey id;

    @Column(name = "`rank`")
    private Integer rank;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "competition_id",insertable = false,updatable = false)
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "member_id",insertable = false,updatable = false)
    private Member member;



}
