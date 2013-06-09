/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.OrderDTO;
import com.gamesupply.ejb.remote.OrderFacadeRemote;
import com.gamesupply.entity.OrderEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        
        OrderEntity orderEntity = new OrderEntity();
        
        orderEntity.setAddress(orderDTO.getAddress());
        orderEntity.setBranch(orderDTO.getBranch());
        orderEntity.setDelivery(orderDTO.getDelivery());
        orderEntity.setIdCustomer(orderDTO.getIdCustomer());
        orderEntity.setPayment(orderDTO.getPayment());
        orderEntity.setPrice(orderDTO.getPrice());
        orderEntity.setProduct(orderDTO.getProduct());
        orderEntity.setProductDescription(orderDTO.getProductDescription());
        orderEntity.setQuantity(orderDTO.getQuantity());
        orderEntity.setStatus(orderDTO.getStatus());
        
        em.persist(orderEntity);   
        
        
        
//        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public List<OrderDTO> findByCustomer(Integer customer) {
        
        Query q = em.createNamedQuery("OrderEntity.findByIdCustomer");
        q.setParameter("idCustomer", customer);
        
        List<OrderEntity> listEntity = q.getResultList();
        List<OrderDTO> listDTO = new ArrayList<OrderDTO>();
        
        for(OrderEntity entity : listEntity){
            
            OrderDTO order = new OrderDTO();
            
            order.setAddress(entity.getAddress());
            order.setBranch(entity.getBranch());
            order.setDelivery(entity.getDelivery());
            order.setIdCustomer(entity.getIdCustomer());
            order.setIdOrder(entity.getIdOrder());
            order.setPayment(entity.getPayment());
            order.setPrice(entity.getPrice());
            order.setProduct(entity.getProduct());
            order.setProductDescription(entity.getProductDescription());
            order.setQuantity(entity.getQuantity());
            order.setStatus(entity.getStatus());
            
            listDTO.add(order);
            
        }
        
        return listDTO;
        
    }


    
}
