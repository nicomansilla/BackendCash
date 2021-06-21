/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashonline.backendcash.service;

import com.cashonline.backendcash.model.Items;
import com.cashonline.backendcash.repository.ItemsRepository;
import java.util.List;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Service
public class ItemsService{

    @Autowired
    ItemsRepository itemsRespository;

    public Page<Items> findAllItems(Pageable pageable) {         
        return itemsRespository.findAll(pageable);
    }

    public List<Items> findByIdUserId(Integer id) {
        return itemsRespository.findByUserId(id);
    }

    //Guardar User "POST"
    public void guardarItem(Items items) {
        
        LOGGER.info("INGRESO A BORRAR EL ITEM");
        try {
            itemsRespository.save(items);
            LOGGER.info("EL ITEM SE GUARDO CON EXITO" + items);
        } catch (Exception e) {
            LOGGER.error("ERROR AL BORRAR USER", e);
        } 
    }

    //Guardar item "Delete"
    public void eliminarItem(Items item) {
        LOGGER.info("INGRESO A BORRAR EL ITEM");
        try {
            itemsRespository.delete(item);
            LOGGER.info("EL ITEM SE BORRARO CON EXITO" + item);
        } catch (Exception e) {
            LOGGER.error("ERROR AL BORRAR USER", e);
        }   
    }
    
    //Guardar item "Delete"
    public void eliminarItems(List<Items> items) {
        LOGGER.info("INGRESO A BORRAR LISTA DE ITEMS DE UN USER");
        try {
            itemsRespository.deleteAll(items);
            LOGGER.info("LOS ITEMS SE BORRARON CON EXITO" + items);
        } catch (Exception e) {
            LOGGER.error("ERROR AL BORRAR USER", e);
        }        
    }
}
