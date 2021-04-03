package com.monet.efp.rolesservice.Controller;

import com.monet.efp.rolesservice.Entity.RoleEntity;
import com.monet.efp.rolesservice.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleRest {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<RoleEntity> list = roleService.getAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getAll(@PathVariable("id") Long id) {
        RoleEntity list = roleService.getById(id);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody RoleEntity _body) {
        if (_body.getRoleName().isEmpty() || _body.getRoleName() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            RoleEntity roleEntity = roleService.create(_body);
            return ResponseEntity.ok(roleEntity);
        }
    }

}
