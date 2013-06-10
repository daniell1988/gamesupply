/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author CUESTAS
 */
@ManagedBean
@SessionScoped
public class AddressController {
    

    private AddressDTO address;
    private CustomerDTO customer;
    private AddressFacadeRemote addressFacade;
    private List<AddressDTO> currentCustomerAddressList;
    private Integer ola;
    private String selectedAddress;
    
    @PostConstruct
    public void init(){
        
        address = new AddressDTO();
//        customer = new CustomerDTO();
        currentCustomerAddressList = new ArrayList<AddressDTO>();
        
    }
    
    public String edit(AddressDTO address){
        this.address = address;
        
        return "/pages/address/addressEdit.xhtml";
    }
    
    public String edit(){
        try {
             addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup("AddressFacade");
        } catch (Exception e) {
            System.out.println("erro lookup web");
        }
        addressFacade.edit(address);
//        findByCustomer(customer);
        
        
        return "/pages/customer/customerEdit.xhtml";
    }
    
     public String destroy(AddressDTO address){
        try {
             addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup("AddressFacade");
        } catch (Exception e) {
            System.out.println("erro lookup web");
        }
        addressFacade.remove(address);
//        findByCustomer(customer);
        
        
        return "/pages/customer/customerEdit.xhtml";
    }
    
    public String create(CustomerDTO customer){
        try {
             addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup("AddressFacade");
        } catch (Exception e) {
            System.out.println("erro lookup web");
        }
        address.setIdCustomer(customer.getIdCustomer());
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
//        address.setIdCustomer(customer);
        addressFacade.create(address);
        
        return "/pages/customer/customerEdit.xhtml";
        
    }    
    
    public AddressController() {    
    }
    
    
    public void selectAddressJSF(ValueChangeEvent event){ 
        
      this.ola = (Integer) event.getNewValue();  
      //restante da sua logica  
   }  
    
    public List<SelectItem> getAddressesSelect(CustomerDTO customer){ 
        
       currentCustomerAddressList = findByCustomer(customer);  
       List<SelectItem> items = new ArrayList<SelectItem>();  
       for(AddressDTO address : currentCustomerAddressList){  
           items.add(new SelectItem(address.getIdAddress(), address.getAddressDescription()));  
       }  
       return items;  
    }  
    
    public List<AddressDTO> findByCustomer(CustomerDTO customer){
        try {
             addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup("AddressFacade");
        } catch (Exception e) {
            System.out.println("erro lookup web");
        }
        return currentCustomerAddressList = addressFacade.findByCustomer(customer.getIdCustomer());
    }
    
//        public static void main(String[] args){
//        
//        //new TesteAddressPersist().teste();
//        new AddressController().create();
//        
//    }

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

    public List<AddressDTO> getCurrentCustomerAddressList() {
        return currentCustomerAddressList;
    }

    public void setCurrentCustomerAddressList(List<AddressDTO> currentCustomerAddressList) {
        this.currentCustomerAddressList = currentCustomerAddressList;
    }

    public Integer getOla() {
        return ola;
    }

    public void setOla(Integer ola) {
        this.ola = ola;
    }

    public String getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(String selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    String createFirstAddress(CustomerDTO customer) {
        this.customer = customer;
        return "/pages/address/addressCreate.xhtml";
    }
    
    

}