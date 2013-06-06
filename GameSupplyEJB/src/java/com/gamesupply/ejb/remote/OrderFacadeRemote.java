/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.OrderDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CUESTAS
 */
@Remote
public interface OrderFacadeRemote {

    void create(OrderDTO orderDTO);

    void edit(OrderDTO orderDTO);

    void remove(OrderDTO orderDTO);

    OrderDTO find(Integer id);

    List<OrderDTO> findAll();

    List<OrderDTO> findRange(Integer[] range);

    int count();
    
}
