/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.List;

/**
 *
 * @author CUESTAS
 */
public class StockController {
    private static StockFacadeRemote stockFacade;
    
    public static void create(StockDTO stockDTO) {
        try {
            stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        stockFacade.create(stockDTO);
    }
    
    public static List<StockDTO> findall() {
        
        try {
            stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        return stockFacade.findAll();
        
    }
    
    public static void updateStock(StockDTO stock){
        
        try {
            stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        stockFacade.edit(stock);
        
    }
    
//    public static List<StockDTO> findBranchStock(String branch){
//        
//        try {
//            stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
//        } catch (Exception e) {
//            System.out.println("erro lookup");
//        }
//        List<StockDTO> listBranchStock = stockFacade.findAll();
//        
//        
//        
//        
//        
//        return listBranchStock;
//        
//    }

    
    
}
