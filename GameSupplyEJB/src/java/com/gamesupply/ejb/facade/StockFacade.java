/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.entity.StockEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 40836665
 */
@Stateless
public class StockFacade extends AbstractFacade<StockEntity> implements StockFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(StockEntity.class);
    }

    @Override
    public void create(ProductDTO productDTO) {
        
        StockEntity stockEntity = new StockEntity();
        
        stockEntity.setDescription(productDTO.getDescription());
        stockEntity.setGenre(productDTO.getGenre());
        stockEntity.setName(productDTO.getName());
        stockEntity.setPlatform(productDTO.getPlatform());
        stockEntity.setPrice(productDTO.getPrice());
        
        em.persist(stockEntity);
        
        
    }

    @Override
    public void edit(ProductDTO stockEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(ProductDTO stockEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public StockDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
