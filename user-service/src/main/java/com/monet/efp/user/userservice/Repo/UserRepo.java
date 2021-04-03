package com.monet.efp.user.userservice.Repo;

import com.monet.efp.user.userservice.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByRoleId(Long roleId);

}
