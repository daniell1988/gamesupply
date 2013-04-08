/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.teste;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.facade.AddressFacade;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.entity.AddressEntity;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Daniel
 */
public class TesteAddressPersist {
    @EJB
    AddressFacadeRemote addressFacade = lookupAddressFacadeBean();
    
    public void teste(){
        
        AddressDTO address = new AddressDTO();
        CustomerDTO customer = new CustomerDTO();
        
        customer.setIdCustomer(1);
        address.setAddress("aaa");
        address.setAddressComplement("bbb");
        address.setAddressDescription("ccc");
        address.setCity("aaa");
        address.setCountry("aaa");
   //   address.setIdAddress(Integer.MIN_VALUE);
        address.setIdCustomer(customer);
        address.setPhoneNumber("aaa");
        address.setState("aaa");
        address.setZip("aaa");
        
       
        addressFacade.create(address);
        
        
    }
    
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException{
        
        new TesteAddressPersist().teste();
        
    }

    private AddressFacadeRemote lookupAddressFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AddressFacadeRemote) c.lookup("java:global/GameSupplyCore/AddressFacadeRemote!com.gamesupply.ejb.remote.AddressFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
