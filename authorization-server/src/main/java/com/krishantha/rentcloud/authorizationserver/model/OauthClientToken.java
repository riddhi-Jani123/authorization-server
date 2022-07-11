package com.krishantha.rentcloud.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="oauth_client_token")
public class OauthClientToken {

    @Id
    @Column(name="authentication_id")
    private String authenticationId;

    @Column(name="token_id")
    private String tokenId;

    @Lob
    @Column(name="token", columnDefinition = "mediumblob")
    private byte[] token;


    @Column(name="user_name")
    private String userName;

    @Column(name="client_id")
    private String clientId;

}
