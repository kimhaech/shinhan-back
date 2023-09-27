package com.example.service;

import com.example.domain.entity.Log;
import com.example.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW) // propagation전파 옵션 - requires_new -> 매번 새로운 트랜잭션으로 만들겠다.
    public void saveLog() {
        logRepository.save(new Log());
    }
}
