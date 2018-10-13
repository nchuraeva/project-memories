package ru.auth.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.auth.server.model.User;
import ru.auth.server.model.UserAuthority;
import ru.auth.server.repository.UserAuthorityRepository;

@Service
public class AuthorityService {


    private UserAuthorityRepository authorityRepository;


    @Autowired
    public void setAuthorityRepository(UserAuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }


    public void  createAuthority(UserAuthority userAuthority) {
        this.authorityRepository.save(userAuthority);
    }
}
