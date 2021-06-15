/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashonline.backendcash.service;

import com.cashonline.backendcash.model.Users;
import com.cashonline.backendcash.repository.UsersRepository;
import java.util.List;
import java.util.Optional;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Service
public class UsersService {

    @Autowired
    UsersRepository usersRespository;

    public List<Users> findAllUsers() {
        LOGGER.info("INGRESO A BUSCAR TODOS LOS USERS");
        return usersRespository.findAll();
    }

    public Optional<Users> findByIdUsers(Integer id) {
        LOGGER.info("INGRESO A BUSCAR EL USER POR ID");
        return usersRespository.findById(id);
    }

    //Guardar User "POST"
    public void guardarUser(Users users) {
        LOGGER.info("INGRESO A GUARDAR EL USERS");
        try {
            usersRespository.save(users);
            LOGGER.info("EL USER SE GUARDO CON EXITO" + users);
        } catch (Exception e) {
            LOGGER.error("ERROR AL GUARDAR USER", e);
        }

        }

    //Eleminar User "Delete"
    public void eliminarUser(Users user) {
        LOGGER.info("INGRESO A BORRAR EL USERS");
        try {
            usersRespository.delete(user);
            LOGGER.info("EL USER SE BORRO CON EXITO" + user);
        } catch (Exception e) {
            LOGGER.error("ERROR AL BORRAR USER", e);
        }
        usersRespository.delete(user);
    }
}
