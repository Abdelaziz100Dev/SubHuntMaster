package com.subhuntmaster.domain;

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

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    private Integer numberOfParticipants;

    private String location;

    private float amount;

    @OneToMany(mappedBy = "competition")
    private List<Ranking> competitions = new ArrayList<>();

 }
