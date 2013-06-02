/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.StockFacadeRemote;
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
public class ProductController implements Serializable{
    
    private StockDTO stockDTO;
    private List<StockDTO> stockList;
    private StockFacadeRemote stockFacade;
    
    @PostConstruct
    public void init(){
        
        this.stockDTO = new StockDTO();
//        stockList = new ArrayList<StockDTO>();
        this.stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
        this.stockList = this.stockFacade.findAll();
        branchQuantity();
        
    }
    
    public void branchQuantity(){
        
        List<StockDTO> tmpStockList = new ArrayList<StockDTO>();
        tmpStockList = this.stockList;
        this.stockList = new ArrayList<StockDTO>();
        
        for(StockDTO stock : tmpStockList){
            
            StockDTO stockTmp = new StockDTO();
            
            stockTmp.setBranch1(stock.getBranch1());
            stockTmp.setBranch2(stock.getBranch2());
            stockTmp.setBranch3(stock.getBranch3());
            stockTmp.setDescription(stock.getDescription());
            stockTmp.setGenre(stock.getGenre());
            stockTmp.setIdProduct(stock.getIdProduct());
            stockTmp.setName(stock.getName());
            stockTmp.setPlatform(stock.getPlatform());
            stockTmp.setPrice(stock.getPrice());
            stockTmp.setType(stock.getType());
            stockTmp.setBranchQuantity(stock.getBranchQuantity());
            
            if(stockTmp.getBranch1() > 0 || stockTmp.getBranch2() > 0 || stockTmp.getBranch3() > 0){
                this.stockList.add(stock);
            }
            
        }        
    }

    public StockDTO getStockDTO() {
        return stockDTO;
    }

    public void setStockDTO(StockDTO stockDTO) {
        this.stockDTO = stockDTO;
    }

    public List<StockDTO> getStockList() {
        return stockList;
    }

    public void setStockList(List<StockDTO> stockList) {
        this.stockList = stockList;
    }
    
    
    
}
