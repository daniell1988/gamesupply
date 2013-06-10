/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.ejb.remote.WishlistFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.io.Serializable;
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
public class WishlistController implements Serializable{
    
    private StockDTO wishList;
    private List<StockDTO> wishlistList;
    private WishlistFacadeRemote wishlistFacade;
    
    @PostConstruct
    public void init(){
        
//        this.wishList = new StockDTO();

        
    }
    
    public void addWishlistItem(StockDTO wishlist, Integer customer){
        
        this.wishList = wishlist;
        this.wishList.setBranch3(customer);
        this.wishlistFacade = (WishlistFacadeRemote) GSUtils.dynamicLookup("WishlistFacade");
        wishlistFacade.create(this.wishList);
        this.wishList = new StockDTO();
        
        
    }
    
    public String findByCustomer(Integer customer){
        
        this.wishlistFacade = (WishlistFacadeRemote) GSUtils.dynamicLookup("WishlistFacade");
        wishlistList = wishlistFacade.findByCustomer(customer);
        return "/pages/product/productWishlist.xhtml";
    }
    
    public void remove(StockDTO wishlist){
        this.wishlistFacade = (WishlistFacadeRemote) GSUtils.dynamicLookup("WishlistFacade");
        wishlistFacade.remove(wishlist);
        findByCustomer(wishlist.getBranch3());
    }

    public StockDTO getWishList() {
        return wishList;
    }

    public void setWishList(StockDTO wishList) {
        this.wishList = wishList;
    }

    public List<StockDTO> getWishlistList() {
        return wishlistList;
    }

    public void setWishlistList(List<StockDTO> wishlistList) {
        this.wishlistList = wishlistList;
    }
    
    
    
}
