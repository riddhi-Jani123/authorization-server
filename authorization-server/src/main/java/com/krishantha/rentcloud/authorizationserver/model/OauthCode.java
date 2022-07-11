package com.krishantha.rentcloud.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="oauth_code")
public class OauthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Column(name="code")
    private String code;

    @Lob
    @Column(name="authentication", columnDefinition = "mediumblob")
    private byte[] authentication;
}
