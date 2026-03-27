package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.dto.Email;
import ru.otus.hw.repositories.EmailRepository;

@RequiredArgsConstructor
@Service
public class EmailService {
    private  final EmailRepository emailRepository;

    @Transactional(readOnly = true)
    public Flux<Email> findEmailsByUserName(String userName){
        return emailRepository.findEmailsByUserName(userName);
    }
}
