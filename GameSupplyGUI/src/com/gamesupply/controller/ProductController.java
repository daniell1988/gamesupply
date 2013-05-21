/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.ejb.remote.ProductFacadeRemote;
import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.util.GSUtils;

/**
 *
 * @author CUESTAS
 */
public class ProductController {
    private static StockFacadeRemote stockFacade;

    public static void remove(ProductDTO productDTO) {
        
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        productFacade.remove(productDTO);
        
    }

    
    
    private ProductDTO productDTO;
    private static ProductFacadeRemote productFacade;
    
    public static void create(ProductDTO productDTO){
        
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
            stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        productFacade.create(productDTO);
        stockFacade.create(productDTO);
        
        
    }
    
    public static void edit(ProductDTO productDTO) {
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        productFacade.edit(productDTO);
    }
    
}
