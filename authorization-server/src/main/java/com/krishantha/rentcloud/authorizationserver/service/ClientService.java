package com.krishantha.rentcloud.authorizationserver.service;

import com.krishantha.rentcloud.authorizationserver.model.OauthClientDetails;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public void save(OauthClientDetails clientDetails);

    public int countById(int userId);

    Optional<OauthClientDetails> findByuserId(int id);


}
