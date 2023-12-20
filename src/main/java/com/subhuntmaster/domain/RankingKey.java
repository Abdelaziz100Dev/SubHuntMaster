package com.subhuntmaster.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingKey implements Serializable{


    private Long competition_id;

    private Long member_id;
}
