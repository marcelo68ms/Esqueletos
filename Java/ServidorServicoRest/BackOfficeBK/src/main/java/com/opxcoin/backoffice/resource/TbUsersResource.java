/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.resource;

import com.opxcoin.backoffice.entity.TbUsers;
import com.opxcoin.backoffice.service.TbUsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author marcelo
 */
@RestController
@RequestMapping("/opxBackoffice")
public class TbUsersResource {
 
    @Autowired
    private TbUsersService service;
    
    /**
     * Serviço que lista os usuários
     * 
     * @return Lista de Usuários
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody List<TbUsers> listUsers() {    
        return service.getUsers();
    }
}
