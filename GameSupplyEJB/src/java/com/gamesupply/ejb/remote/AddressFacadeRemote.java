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

    void create(AddressDTO addressEntity);

    void edit(AddressDTO addressEntity);

    void remove(AddressDTO addressEntity);

    AddressDTO find(Integer id);

    List<AddressDTO> findAll();

    List<AddressDTO> findRange(Integer[] range);

    int count();
    
}
