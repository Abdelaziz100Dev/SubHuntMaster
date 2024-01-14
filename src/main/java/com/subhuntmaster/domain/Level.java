package com.subhuntmaster.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String Code;
    private String description;
    private String points;

    @OneToMany(mappedBy = "level")
    private List<Fish> fish;

}
