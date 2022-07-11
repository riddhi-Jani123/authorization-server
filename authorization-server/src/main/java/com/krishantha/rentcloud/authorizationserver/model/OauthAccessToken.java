package com.krishantha.rentcloud.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="oauth_access_token")
public class OauthAccessToken {

    @Id
    @Column(name="authentication_id")
    String authenticationId;

    @Column(name="token_id")
    String tokenId;

    @Lob
    @Column(name="token", columnDefinition = "mediumblob")
    private byte[] token;

    @Column(name="user_name")
    String username;

    @Column(name="client_id")
    String client_id;
    @Lob
    @Column(name="authentication", columnDefinition = "mediumblob")
    private byte[] authentication;

    @Column(name="refresh_token")
    String refresh_token;


}
