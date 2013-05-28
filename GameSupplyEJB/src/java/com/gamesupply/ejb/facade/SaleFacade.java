/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.SaleDTO;
import com.gamesupply.ejb.remote.SaleFacadeRemote;
import com.gamesupply.entity.SaleEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class SaleFacade extends AbstractFacade<SaleEntity> implements SaleFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaleFacade() {
        super(SaleEntity.class);
    }

    @Override
    public void create(SaleDTO saleDTO) {
        
        SaleEntity saleEntity = new SaleEntity();
        
        saleEntity.setBranch(saleDTO.getBranch());
        saleEntity.setName(saleDTO.getName());
        saleEntity.setPlatform(saleDTO.getPlatform());
        saleEntity.setPrice(saleDTO.getPrice());
        saleEntity.setQuantity(saleDTO.getQuantity());
        saleEntity.setType(saleDTO.getType());
        
        em.persist(saleEntity);
        
    }

    @Override
    public void edit(SaleDTO saleEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(SaleDTO saleEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SaleDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<SaleDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
