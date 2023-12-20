package com.subhuntmaster.dto.responseDto;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private Integer rank;
    private Integer score;
    private CompetitionDto competition;
    private MemberDto member;


}
