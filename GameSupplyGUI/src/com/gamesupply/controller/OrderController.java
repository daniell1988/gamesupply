/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.OrderDTO;
import com.gamesupply.ejb.remote.OrderFacadeRemote;
import com.gamesupply.util.GSUtils;
import java.util.List;

/**
 *
 * @author CUESTAS
 */
public class OrderController {
    
    private static OrderFacadeRemote orderFacade;
    
    public static List<OrderDTO> findByBranch(String branch){
        
        try {
            orderFacade = (OrderFacadeRemote) GSUtils.dynamicLookup("OrderFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        List<OrderDTO> orderDTO;
        orderDTO = orderFacade.findByBranch(branch);
        
        return orderDTO;
    }
    
    public static void edit(OrderDTO order){

        try {
            orderFacade = (OrderFacadeRemote) GSUtils.dynamicLookup("OrderFacade");
        } catch (Exception e) {
            System.out.println("erro lookup");
        }
        
        orderFacade.edit(order);

    }
    
}
