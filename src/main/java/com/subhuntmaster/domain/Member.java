package com.subhuntmaster.domain;

import com.subhuntmaster.enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id ;



    private Integer number;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date accessionDate;

    private String nationality;

    private IdentityDocumentType identityDocument;

    private String identityNumber;

    @OneToMany(mappedBy = "member")
    private List<Ranking> rankings = new ArrayList<>();

    @OneToMany
    private List<Hunting> huntings = new ArrayList<>();
}
