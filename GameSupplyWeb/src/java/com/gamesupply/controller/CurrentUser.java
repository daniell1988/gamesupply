/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.ArrayList;
import java.util.List;
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
    private List<StockDTO> cart;
    private List<StockDTO> wishlist;
    private int cartQty;
    private Integer idOrderAddress;

    @PostConstruct
    public void init(){
        this.idUser = 0;
        this.login = "";
        this.name = "";
        this.isLogged = false;
//        CustomerController cc = new CustomerController();
        cart = new ArrayList<StockDTO>();
//        getCurrentUser(cc.login());
    }
    
    public void getCurrentUser(CustomerDTO customer){
        
        this.idUser = customer.getIdCustomer();
        this.login = customer.getUserLogin();
        this.name = customer.getFirstName();
        this.isLogged = true;
        
    }
    
    public void addItemToCart(StockDTO stock){
        if(!cart.contains(stock)){
            stock.setBranchQuantity(1);
            this.cart.add(stock);
        }
        
        else{
            int tmpIndex = this.cart.indexOf(stock);
            this.cart.get(tmpIndex).setBranchQuantity(this.cart.get(tmpIndex).getBranchQuantity() + 1);
        }
    }
    
    public void removeItemFromCart(StockDTO stock){
        this.cart.remove(stock);
    }
    
    public void updateCart(StockDTO stock){
        int tmpIndex = this.cart.indexOf(stock);
        this.cart.get(tmpIndex).setBranchQuantity(stock.getBranchQuantity());
        int i = 0;
    }
    
    public void addItemToWishList(StockDTO stock){
        this.cart.add(stock);
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<StockDTO> getCart() {
        return cart;
    }

    public void setCart(List<StockDTO> cart) {
        this.cart = cart;
    }

    public List<StockDTO> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<StockDTO> wishlist) {
        this.wishlist = wishlist;
    }

    public int getCartQty() {
        return cartQty;
    }

    public void setCartQty(int cartQty) {
        this.cartQty = cartQty;
    }

    public Integer getIdOrderAddress() {
        return idOrderAddress;
    }

    public void setIdOrderAddress(Integer idOrderAddress) {
        this.idOrderAddress = idOrderAddress;
    }
    
    
    
}
