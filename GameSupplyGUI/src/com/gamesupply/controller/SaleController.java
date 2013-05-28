/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.SaleDTO;
import com.gamesupply.ejb.remote.SaleFacadeRemote;
import com.gamesupply.util.GSUtils;

/**
 *
 * @author CUESTAS
 */
public class SaleController {
    private static SaleFacadeRemote saleFacade;
    
        public static void create(SaleDTO saleDTO) {
        try {
            saleFacade = (SaleFacadeRemote) GSUtils.dynamicLookup("SaleFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        saleFacade.create(saleDTO);
    }
    
}
