package com.krishantha.rentcloud.authorizationserver.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="oauth_approvals")
public class OauthApprovals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="userId")
    String userId ;

    @Column(name="clientId")
    String clientId;

    @Column(name="scope")
    String scope;

    @Column(name="status")
    String status;

    @Column(name="expiresAt")
    Timestamp expiresAt;

    @Column(name="lastModifiedAt")
    Timestamp lastModifiedAt;

}
