/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.util.GSUtils;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class CurrentUser {

    private Integer idUser;
    private String login;
    private String name;
    private boolean isLogged = false;
    private String tmpLogin;
    private String tmpPass;
    private CustomerFacadeRemote customerFacade;
    private CustomerDTO customer;

    @PostConstruct
    public void init(){
        this.idUser = 0;
        this.login = "";
        this.name = "";
        this.isLogged = false;
        CustomerController cc = new CustomerController();
//        getCurrentUser(cc.login());
    }
    
    public void getCurrentUser(CustomerDTO customer){
        
        this.idUser = customer.getIdCustomer();
        this.login = customer.getUserLogin();
        this.name = customer.getFirstName();
        this.isLogged = true;
        
    }
    
    public String login(){
//        String pass = this.customer.getUserPassword();
        this.customerFacade = (CustomerFacadeRemote) GSUtils.dynamicLookup("CustomerFacade");
        this.customer = customerFacade.login(this.tmpLogin, this.tmpPass);
        
        if(this.tmpPass.equals(this.customer.getUserPassword())){
            
            this.idUser = customer.getIdCustomer();
            this.name = customer.getFirstName();
            this.login = customer.getFirstName();
            this.isLogged = true;
            
            return "/pages/product/productList.xhtml";
        }
        
        return "/pages/login.xhtml";
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public String getTmpLogin() {
        return tmpLogin;
    }

    public void setTmpLogin(String tmpLogin) {
        this.tmpLogin = tmpLogin;
    }

    public String getTmpPass() {
        return tmpPass;
    }

    public void setTmpPass(String tmpPass) {
        this.tmpPass = tmpPass;
    }
    
    
    
}
