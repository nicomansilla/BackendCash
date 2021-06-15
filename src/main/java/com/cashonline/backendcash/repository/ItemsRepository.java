/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cashonline.backendcash.repository;

import com.cashonline.backendcash.model.Items;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Repository
public interface ItemsRepository extends CrudRepository<Items, Integer>{	

    public List<Items> findByUserId(Integer userId);  
    
    public List<Items> findAll();
    
    public Items removeById(Integer id);
    
    public List<Items> removeByUserId(Integer userId);
    
}
