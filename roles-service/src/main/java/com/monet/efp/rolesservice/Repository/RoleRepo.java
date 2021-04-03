package com.monet.efp.rolesservice.Repository;

import com.monet.efp.rolesservice.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleId(Long id);
}
