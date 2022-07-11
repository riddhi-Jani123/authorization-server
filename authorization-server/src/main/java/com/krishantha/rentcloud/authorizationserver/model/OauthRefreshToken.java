package com.krishantha.rentcloud.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="oauth_refresh_token")
@Data
public class OauthRefreshToken {
    @Id
    String token_id;

    @Lob
    @Column(name="token", columnDefinition = "mediumblob")
    private byte[] token;

    @Lob
    @Column(name="authentication", columnDefinition = "mediumblob")
    private byte[] authentication;

}
