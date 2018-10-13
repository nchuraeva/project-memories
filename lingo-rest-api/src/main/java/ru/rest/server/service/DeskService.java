package ru.rest.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rest.server.model.Desk;
import ru.rest.server.model.DeskType;
import ru.rest.server.repository.DeskRepository;

import java.util.List;

@Service
public class DeskService {


    private DeskRepository deskRepository;

    public void createDefaultDesks(String username) {
      deskRepository.save(new Desk("English", username, "DEFAULT_LANGUAGE"));
      deskRepository.save(new Desk("Japanese", username, "JAPANESE_LANGUAGE"));
    }

    public List<Desk> getDesks(String username) {
      return deskRepository.findAllByUsername(username);

    }


   @Autowired
    public void setDeskRepository(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

}

