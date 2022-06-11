package com.vestra.pp3bootstrap.repository;

import com.vestra.pp3bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findUserByName(String name);
    User findUserById(Long id);

}
