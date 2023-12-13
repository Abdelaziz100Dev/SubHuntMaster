package com.subhuntmaster.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private Integer numberOfFish;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;
}
