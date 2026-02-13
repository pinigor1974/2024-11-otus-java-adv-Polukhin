package ru.otus.hw.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.otus.hw.dto.Email;

@Repository
public interface EmailRepository extends ReactiveCrudRepository<Email, Integer> {

    @Query("select e.id, e.address, e.user_id from Emails e inner join Users u on u.id = e.user_id where u.name = :user_name ")
    Flux<Email> findEmailsByUserName(@Param("user_name") String userName);
}
