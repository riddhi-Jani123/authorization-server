package com.krishantha.rentcloud.authorizationserver.repository;

import com.krishantha.rentcloud.authorizationserver.model.OauthClientDetails;
import com.krishantha.rentcloud.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<OauthClientDetails,Integer> {

    public int countByUserId(int userId);



    public Optional<OauthClientDetails> findByuserId(int userId);

}
