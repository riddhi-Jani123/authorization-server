package com.krishantha.rentcloud.authorizationserver.service;

import com.krishantha.rentcloud.authorizationserver.model.OauthClientDetails;
import com.krishantha.rentcloud.authorizationserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl  implements  ClientService{

    @Autowired
    ClientRepository clientRepository;


    @Override
    public void save(OauthClientDetails clientDetails) {

        System.out.println("details "+clientDetails);
          clientRepository.save(clientDetails);

         // clientRepository.countByUserId();
    }

    @Override
    public int countById(int userId) {
        int id = clientRepository.countByUserId(userId);

        return id;
    }

    @Override
    public Optional<OauthClientDetails> findByuserId(int id) {

        return clientRepository.findByuserId(id);
    }
}
