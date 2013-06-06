/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.OrderDTO;
import com.gamesupply.ejb.remote.OrderFacadeRemote;
import com.gamesupply.entity.OrderEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class OrderFacade extends AbstractFacade<OrderEntity> implements OrderFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFacade() {
        super(OrderEntity.class);
    }

    @Override
    public void create(OrderDTO orderDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(OrderDTO orderDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(OrderDTO orderDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrderDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<OrderDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
