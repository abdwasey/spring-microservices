package com.monet.efp.user.userservice.Service;

import com.monet.efp.user.userservice.DAO.DepartmentDAO;
import com.monet.efp.user.userservice.DAO.ResponseDAO;
import com.monet.efp.user.userservice.Entity.UserEntity;
import com.monet.efp.user.userservice.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    public List<UserEntity> getAll() {
        return  userRepo.findAll();
    }

    public UserEntity create(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    public ResponseDAO getById(Long roleId) {
        ResponseDAO responseDAO = new ResponseDAO();
        UserEntity userEntity = userRepo.findByRoleId(roleId);
        if (userEntity != null) {
            DepartmentDAO departmentDAO =
                    restTemplate.getForObject("http://ROLE-SERVICE/roles/" + userEntity.getRoleId(),
                    DepartmentDAO.class);
            System.out.println(departmentDAO.getRoleId());
            responseDAO.setDepartmentDAO(departmentDAO);
            responseDAO.setUserEntity(userEntity);
        }
        return responseDAO;
    }
}
