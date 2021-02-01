package ru.geekbrains.spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public Score incScore(Score score) {
        score.setValue(score.getValue() + 1);
        return scoreRepository.save(score);
    }

    public Score decScore(Score score) {
        score.setValue(score.getValue() - 1);
        return scoreRepository.save(score);
    }

}
