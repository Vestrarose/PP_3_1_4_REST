package com.vestra.pp3bootstrap.service;

import com.vestra.pp3bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Role getRoleByID(Long id);
    Role getRoleByName(String name);
    void addRole(Role role);
}
