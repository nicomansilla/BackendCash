/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashonline.backendcash.repository;

import com.cashonline.backendcash.model.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{
    
    public Optional<Users> findById(Integer id);
    
    public List<Users> findAll();
    
    //public Users removeById(Integer id);
    
}
