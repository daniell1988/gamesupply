/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.dto.ProductDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.entity.StockEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuestas
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
        stockEntity.setType(productDTO.getType());
        stockEntity.setBranch1("0");
        stockEntity.setBranch2("0");
        stockEntity.setBranch3("0");
        
        em.persist(stockEntity);
    }

    @Override
    public void edit(StockDTO stockDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(StockDTO stockDTO) {
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
    public List<StockDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
