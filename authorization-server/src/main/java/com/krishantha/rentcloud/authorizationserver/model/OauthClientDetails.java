package com.krishantha.rentcloud.authorizationserver.model;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = " oauth_client_details ")
public class OauthClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="client_id")
    @NotNull
    String clientId;

    @Column(name="client_secret")
    @NotNull
    private String clientSecret;

    @Column(name="scope")
    @NotNull
    private String scope;

    @Column(name="web_server_redirect_uri")
    @NotNull
    private String webServerRedirectUri;

    @Column(name="resource_ids")
    private String resourceIds;


    @Column(name="authorized_grant_types")
    private String authorizedGrantTypes;


    @Column(name="authorities")
    private String authorities;

    @Column(name="access_token_validity", length=11)
    private Integer accessTokenValidity;

    @Column(name="refresh_token_validity", length=11)
    private Integer refreshTokenValidity;

    @Column(name="additional_information", length=4096)
    private String additionalInformation;

    @Column(name="autoapprove", columnDefinition = "TINYINT(4)")
    private Integer autoapprove;

    //custom property to be used to get client id and secret by userId
    @Column(name="userId")
    int userId;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {

       PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.clientSecret = passwordEncoder.encode(clientSecret);

    }
}
