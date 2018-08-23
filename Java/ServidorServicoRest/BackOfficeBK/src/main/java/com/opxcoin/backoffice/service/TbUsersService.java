/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.service;

import com.opxcoin.backoffice.entity.TbUsers;
import com.opxcoin.backoffice.repository.TbUsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcelo
 */
@Service
public class TbUsersService {
    
    @Autowired
    private TbUsersRepository tbUsersRepository;
    
    /**
     * Método responsável por trazer todos os usuários 
     * 
     * @return Uma lista de Usuários
     */
    @Transactional(readOnly = true)
    public List<TbUsers> getUsers() {
        return tbUsersRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
    }
}
