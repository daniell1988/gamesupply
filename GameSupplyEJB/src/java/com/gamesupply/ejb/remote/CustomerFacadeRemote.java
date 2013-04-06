/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.CustomerDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CUESTAS
 */
@Remote
public interface CustomerFacadeRemote {

    void create(CustomerDTO customerDTO);

    void edit(CustomerDTO customerDTO);

    void remove(CustomerDTO customerDTO);

    CustomerDTO find(Integer id);

    List<CustomerDTO> findAll();

    List<CustomerDTO> findRange(Integer[] range);

    int count();
    
}
