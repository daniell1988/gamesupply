/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.ejb.remote.ProductFacadeRemote;
import com.gamesupply.util.GSUtils;

/**
 *
 * @author CUESTAS
 */
public class ProductController {
    
    private ProductDTO productDTO;
    private static ProductFacadeRemote productFacade;
    
    public static void create(ProductDTO productDTO){
        
        try {
            productFacade = (ProductFacadeRemote) GSUtils.dynamicLookup("ProductFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        productFacade.create(productDTO);
        
    }
    
}
