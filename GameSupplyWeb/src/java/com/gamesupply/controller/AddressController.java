/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.util.GSUtils;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CUESTAS
 */
@ManagedBean
@RequestScoped
public class AddressController {
    

    private AddressDTO address;
    private CustomerDTO customer;
    private AddressFacadeRemote addressFacade;

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
    @PostConstruct
    public void init(){
        
        address = new AddressDTO();
        customer = new CustomerDTO();
        
    }
    
    public void create(){
        
        try {
             addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup("AddressFacade");
        } catch (Exception e) {
            System.out.println("erro lookup web");
        }
//        customer = new CustomerDTO();
//        address = new AddressDTO();
//        customer.setIdCustomer(Integer.valueOf(1));
//        address.setAddress("Rua x");
//        address.setAddressComplement("numro 90");
//        address.setAddressDescription("ao lado da padaria");
//        address.setCity("sao paulo");
//        address.setCountry("brasil");
//        address.setIdCustomer(customer);
//        address.setPhoneNumber("999+6999");
//        address.setState("SP");
//        address.setZip("22501-581");
        
        addressFacade.create(address);
        
    }    
    
    public AddressController() {
        
        
        
    }
    
        public static void main(String[] args){
        
        //new TesteAddressPersist().teste();
        new AddressController().create();
        
    }
}
