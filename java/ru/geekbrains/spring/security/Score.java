package ru.geekbrains.spring.security;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long id;

    @Column(name = "value")
    private int value;

    @OneToOne(mappedBy = "scoreId")
    private User userId;

}
