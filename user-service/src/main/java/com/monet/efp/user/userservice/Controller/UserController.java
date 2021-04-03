package com.monet.efp.user.userservice.Controller;

import com.monet.efp.user.userservice.DAO.ResponseDAO;
import com.monet.efp.user.userservice.Entity.UserEntity;
import com.monet.efp.user.userservice.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        List<UserEntity> list = userService.getAll();
        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id){
        ResponseDAO list = userService.getById(id);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserEntity userEntity){
        UserEntity userEntity1 = userService.create(userEntity);
        return ResponseEntity.ok(userEntity1);
    }

}
