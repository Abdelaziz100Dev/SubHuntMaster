package com.subhuntmaster.mappers;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Fish;
import com.subhuntmaster.domain.Member;
import com.subhuntmaster.domain.Ranking;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.dto.FishDto;
import com.subhuntmaster.dto.MemberDto;
import com.subhuntmaster.dto.responseDto.RankingDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProjectMapper {
    @Autowired
    private ModelMapper modelMapper;

    public <S, T> T mapToDto(S source, Class<T> targetClass) {
        return Objects.isNull(source) ? null : modelMapper.map(source, targetClass);
    }

    public MemberDto toDto(Member memberEntity) {
        return Objects.isNull(memberEntity) ? null : modelMapper.map(memberEntity, MemberDto.class);
    }

    public CompetitionDto toDto(Competition competitionEntity) {
        return Objects.isNull(competitionEntity) ? null : modelMapper.map(competitionEntity, CompetitionDto.class);
    }
    public FishDto toDto(Fish fish) {
        return Objects.isNull(fish) ? null : modelMapper.map(fish, FishDto.class);
    }
    public RankingDto toRankingDto(Ranking ranking) {
//        RankingDto rankingDto = new RankingDto();
////        rankingDto.setCompetition(CompetitionDto.builder().id(ranking.getCompetition().getId()).build());
//        rankingDto.setMember(MemberDto.builder().id(ranking.getMember().getId()).build());
//        rankingDto.setRank(ranking.getRank());
//        rankingDto.setScore(ranking.getScore());
//        rankingDto.setCompetition(toDto(ranking.getCompetition()));
//        rankingDto.setMember(toDto(ranking.getMember()));
        RankingDto rankingDto = RankingDto.builder()
                .rank(ranking.getRank())
                .score(ranking.getScore())
                .competition(CompetitionDto.builder().id(ranking.getCompetition().getId()).build())
                .member(MemberDto.builder().id(ranking.getMember().getId()).build())
                .build();
//        System.out.println("jjjjjj :"+ranking.getCompetition().getId());
        return rankingDto;

//        return Objects.isNull(ranking) ? null : modelMapper.map(ranking, RankingDto.class);
    }

}
