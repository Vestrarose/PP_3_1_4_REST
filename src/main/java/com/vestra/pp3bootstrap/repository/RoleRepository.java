package com.vestra.pp3bootstrap.repository;

import com.vestra.pp3bootstrap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Set<Role> findAll();
    Role findRoleByRole(String role);
    Role findRoleById(Long id);

}
