package com.krishantha.rentcloud.authorizationserver.repository;

import com.krishantha.rentcloud.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
