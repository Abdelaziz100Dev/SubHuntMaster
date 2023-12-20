package com.subhuntmaster.domain;

import com.subhuntmaster.enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @ToString.Exclude
    private List<Ranking> rankings = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Hunting> huntings = new ArrayList<>();
}
