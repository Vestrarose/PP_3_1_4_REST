package com.vestra.pp3bootstrap.service;

import com.vestra.pp3bootstrap.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void updateRole(Role role);

    void removeRoleById(long id);

    void addRole(Role role);

    Role getRoleByName(String name);
}
