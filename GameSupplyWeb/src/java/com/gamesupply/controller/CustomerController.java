/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private AddressDTO shippingAddress;

    /**
     * Creates a new instance of CustomerController
     */
    
    @PostConstruct
    public void init(){
        
        this.customer = new CustomerDTO();
        this.shippingAddress = new AddressDTO();
//        customerList = new ArrayList<CustomerDTO>();
        this.customerList = null;
        findAll();
        
    }
    
    public String edit(CustomerDTO customer){
        
        this.customer = customer;
       
        return "/pages/customer/customerEdit.xhtml";
    }
    
    public String destroy(CustomerDTO customer){
        
        this.customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        this.customerFacade.remove(customer);
        this.customerList = customerFacade.findAll();
        
//        FacesContext.getCurrentInstance().getRenderKit();
        return "/pages/customer/customerList.xhtml";
    }
    
    public void findAll(){

        this.customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        this.customerList = customerFacade.findAll();

    }
    
    public String create(){
        
        this.customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        this.customer.getAddressDTOCollection().add(shippingAddress);
        this.customerFacade.create(customer);
//        this.customer = new CustomerDTO();
        this.customerList = customerFacade.findAll();
        this.customer = new CustomerDTO();
        this.shippingAddress = new AddressDTO();
        return retornaCustomerList();
        
        
    }
    
    public String editPersist(){
        
        this.customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        this.customerFacade.edit(customer);
        this.customerList = customerFacade.findAll();
        this.customer = new CustomerDTO();
        
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

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    
    
}
