package com.subhuntmaster.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.subhuntmaster.commons.helper.CustomTimeDeserializer;
import com.subhuntmaster.enums.competitionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Temporal(TemporalType.DATE) // by default, it is TemporalType.TIMESTAMP
    private Date date;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    @Temporal(TemporalType.TIME)
    private Date endTime;

    private Integer numberOfParticipants;

    private String location;

    private float amount;

    @Enumerated(EnumType.STRING)
    private competitionStatus status;

    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankings = new ArrayList<>();

 }
