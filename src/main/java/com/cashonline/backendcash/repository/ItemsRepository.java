/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cashonline.backendcash.repository;

import com.cashonline.backendcash.model.Items;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{	
    
    public List<Items> findByUserId(Integer userId);  
    
//    public List<Items> findAll(Pageable pageable);
    
    public Items removeById(Integer id);
    
    public List<Items> removeByUserId(Integer userId);
    
}
