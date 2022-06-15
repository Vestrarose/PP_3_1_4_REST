package com.vestra.pp3bootstrap.repository;

import com.vestra.pp3bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User getUserById(long id);

}
