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
public class Fish {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private int id;

        private String name;
        private float averageWeight;

        @OneToMany(mappedBy = "fish")
        private List<Hunting> hunting;

        @ManyToOne
        @JoinColumn(name = "level_id")
        private Level level;
}
