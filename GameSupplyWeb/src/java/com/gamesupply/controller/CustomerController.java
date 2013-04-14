/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author CUESTAS
 */
@ManagedBean
@SessionScoped
public class CustomerController {


    
    private CustomerDTO customer;
    private CustomerFacadeRemote customerFacade;
    private List<CustomerDTO> customerList;

    public CustomerFacadeRemote getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacadeRemote customerFacade) {
        this.customerFacade = customerFacade;
    }

    public List<CustomerDTO> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerDTO> customerList) {
        this.customerList = customerList;
    }

    /**
     * Creates a new instance of CustomerController
     */
    
    @PostConstruct
    public void init(){
        
        customer = new CustomerDTO();
        customerList = new ArrayList();
        customerList = findAll();
        
    }
    
    public List<CustomerDTO> findAll(){
        
        customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        return (List<CustomerDTO>) customerFacade.findAll();
        
    }
    
    public void create(){
        
        customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        
        customerFacade.create(customer);
        
    }
    
    public CustomerController() {
    }
    
    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
}
