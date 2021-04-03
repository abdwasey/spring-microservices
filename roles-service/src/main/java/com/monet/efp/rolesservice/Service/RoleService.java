package com.monet.efp.rolesservice.Service;

import com.monet.efp.rolesservice.Entity.RoleEntity;
import com.monet.efp.rolesservice.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<RoleEntity> getAll() {
        return roleRepo.findAll();
    }

    public RoleEntity create(RoleEntity body) {
        return roleRepo.save(body);
    }

    public RoleEntity getById(Long id) {
        RoleEntity roleEntity = roleRepo.findByRoleId(id);
        return roleEntity;
    }
}
