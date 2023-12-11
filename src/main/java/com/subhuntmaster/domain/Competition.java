package com.subhuntmaster.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String Code;

    @Temporal(TemporalType.DATE) // by default, it is TemporalType.TIMESTAMP
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    private Integer numberOfparticipants;
    private String location;
    private float amount;

    @OneToMany(mappedBy = "competition")
    private List<Ranking> competitions = new ArrayList<>();

 }
