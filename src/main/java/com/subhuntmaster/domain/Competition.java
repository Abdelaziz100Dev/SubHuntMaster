package com.subhuntmaster.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.subhuntmaster.commons.helper.CustomTimeDeserializer;
import com.subhuntmaster.enums.competitionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Code cannot be blank")
    private String code;

    @Temporal(TemporalType.DATE) // by default, it is TemporalType.TIMESTAMP
    @NotNull(message = "Date cannot be null")
    private Date date;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    @Temporal(TemporalType.TIME)
    @NotNull(message = "StartTime cannot be null")
    private Date startTime;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    @Temporal(TemporalType.TIME)
    @NotNull(message = "EndTime cannot be null")
    private Date endTime;

    @Min(value = 0, message = "NumberOfParticipants cannot be negative")
    private Integer numberOfParticipants;

    private String location;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be a positive number")
    private float amount;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status cannot be null")
    private competitionStatus status;

    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankings = new ArrayList<>();

 }
