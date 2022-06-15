package com.vestra.pp3bootstrap.service;

import com.vestra.pp3bootstrap.model.Role;
import com.vestra.pp3bootstrap.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void removeRoleById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
