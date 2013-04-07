/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.teste;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.facade.AddressFacade;
import com.gamesupply.entity.AddressEntity;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Daniel
 */
public class TesteAddressPersist {
    
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException{
        
        AddressDTO address = new AddressDTO();
        CustomerDTO customer = new CustomerDTO();
        
        customer.setIdCustomer(1);
        address.setAddress("aaa");
        address.setAddressComplement("bbb");
        address.setAddressDescription("ccc");
        address.setCity("aaa");
        address.setCountry("aaa");
//      address.setIdAddress(Integer.MIN_VALUE);
        address.setIdCustomer(customer);
        address.setPhoneNumber("aaa");
        address.setState("aaa");
        address.setZip("aaa");
        
        AddressEntity addressE = new AddressEntity();
        AddressFacade addressF = new AddressFacade();
        
        BeanUtils.copyProperties(addressE, address);
        
       
        addressF.create(address);
        
    }
    
}
