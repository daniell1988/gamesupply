/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.OrderEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface OrderFacadeRemote {

    void create(OrderEntity orderEntity);

    void edit(OrderEntity orderEntity);

    void remove(OrderEntity orderEntity);

    OrderEntity find(Object id);

    List<OrderEntity> findAll();

    List<OrderEntity> findRange(int[] range);

    int count();
    
}
