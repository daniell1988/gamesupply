/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.ProductFacadeRemote;
import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.List;



/**
 *
 * @author CUESTAS
 */
public class ProductController {
    
    private static ProductFacadeRemote productFacade;
    private static StockFacadeRemote stockFacade;

    public static void remove(ProductDTO productDTO) {
        
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        productFacade.remove(productDTO);
        
    }

    
        public static List<ProductDTO> findall() {
        
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        return productFacade.findAll();
        
    }
    
    
    public static void create(ProductDTO productDTO){
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
            stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        productFacade.create(productDTO);
        
        StockDTO stockDTO = new StockDTO();
        
        stockDTO.setDescription(productDTO.getDescription());
        stockDTO.setGenre(productDTO.getGenre());
        stockDTO.setName(productDTO.getName());
        stockDTO.setPlatform(productDTO.getPlatform());
        stockDTO.setPrice(productDTO.getPrice());
        stockDTO.setType(productDTO.getType());
        stockDTO.setBranch1(0);
        stockDTO.setBranch2(0);
        stockDTO.setBranch3(0);
        
        stockFacade.create(stockDTO);
        
        
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
