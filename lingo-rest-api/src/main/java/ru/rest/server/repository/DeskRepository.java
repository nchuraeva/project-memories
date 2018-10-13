package ru.rest.server.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.rest.server.model.Desk;

import java.util.List;

@Component
public interface DeskRepository extends CrudRepository<Desk, Long> {
    List<Desk> findAllByUsername(String username);
}

