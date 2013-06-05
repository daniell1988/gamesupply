/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.AddressDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CUESTAS
 */
@Remote
public interface AddressFacadeRemote {

    void create(AddressDTO addressDTO);

    void edit(AddressDTO addressDTO);

    void remove(AddressDTO addressDTO);

    AddressDTO find(Integer id);

    List<AddressDTO> findAll();

    List<AddressDTO> findRange(Integer[] range);

    int count();
    
    List<AddressDTO> findByCustomer(Integer customer);
    
}
