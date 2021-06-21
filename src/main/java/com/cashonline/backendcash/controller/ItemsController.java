/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cashonline.backendcash.controller;

import com.cashonline.backendcash.model.Items;
import com.cashonline.backendcash.service.ItemsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@RestController
@RequestMapping("/items")
public class ItemsController {
    
    @Autowired
    ItemsService itemsService;           
    
    @GetMapping("/{page}/{size}")
    public Page<Items> findAllUsers( @PathVariable int page, @PathVariable int size) { 
        Pageable pageable = PageRequest.of(page, size);
        return itemsService.findAllItems(pageable);
    }

    @GetMapping("/{userId}")
    public List<Items> findByIdItems(@PathVariable("userId") Integer userId) {
        return this.itemsService.findByIdUserId(userId);
    }

    @PostMapping()
    public void guardarItem(@RequestBody Items items) {
        itemsService.guardarItem(items);
    }
    
    @DeleteMapping("/{userId}")
    public void eleminarItem(@PathVariable("userId") Integer userId) {
        List<Items> item = itemsService.findByIdUserId(userId);
        itemsService.eliminarItem(item.get(0));
    }
    @DeleteMapping("/todoLosItems/{userId}")
    public void eleminarItems(@PathVariable("userId") Integer userId) {
        List<Items> item = itemsService.findByIdUserId(userId);
        itemsService.eliminarItems(item);
    }
}
