/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashonline.backendcash.controller;

import com.cashonline.backendcash.model.Users;
import com.cashonline.backendcash.service.UsersService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping()
    public List<Users> findAllUsers() {
        return usersService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Users> findByIdUsers(@RequestParam("id") Integer id) {
        return this.usersService.findByIdUsers(id);
    }

    @PostMapping()
    public void guardarUser(@RequestBody Users users) {
        usersService.guardarUser(users);
    }
    
    @DeleteMapping("/{id}")
    public void eleminarUser(@PathVariable("id") Integer id) {
        Optional<Users> user = usersService.findByIdUsers(id);
        usersService.eliminarUser(user.get());
    }
}
