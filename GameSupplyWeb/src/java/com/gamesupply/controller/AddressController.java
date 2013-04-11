/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.facade.AddressFacade;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.util.GSUtils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CUESTAS
 */
@ManagedBean
@RequestScoped
public class AddressController {

    private AddressDTO address = new AddressDTO();
    private CustomerDTO customer = new CustomerDTO();
    AddressFacadeRemote addressFacade = null;
    
    public void create(){
        
        addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup(AddressFacade.class);
        
    }    
    
    public AddressController() {
        
    }
}
