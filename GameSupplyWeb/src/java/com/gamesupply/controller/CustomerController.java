/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.util.GSUtils;
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

    /**
     * Creates a new instance of CustomerController
     */
    
    @PostConstruct
    public void init(){
        
        customer = new CustomerDTO();
//        customerList = new ArrayList<CustomerDTO>();
        findAll();
        
    }
    
    public String edit(CustomerDTO customer){
        
        this.customer = customer;
       
        return "/pages/customer/customerEdit.xhtml";
    }
    
    public String destroy(CustomerDTO customer){
        
        customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        customerFacade.remove(customer);
        
        return ("/pages/customer/customerList.xhtml");
    }
    
    public void findAll(){

        customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        this.customerList = customerFacade.findAll();

    }
    
    public String create(){
        
        customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        customerFacade.create(customer);
        return retornaCustomerList();
        
        
    }
    
    public String editPersist(){
        
        customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        customerFacade.edit(customer);
        
        return ("/pages/customer/customerList.xhtml");
        
        
    }
    
    public String retornaCustomerList(){
        
        return ("/pages/customer/customerList.xhtml");
        
    }
    
    public CustomerController() {
    }
    
    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
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
    
}
