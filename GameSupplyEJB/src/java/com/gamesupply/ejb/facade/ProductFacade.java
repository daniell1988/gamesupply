/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.ejb.remote.ProductFacadeRemote;
import com.gamesupply.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 40836665
 */
@Stateless
public class ProductFacade extends AbstractFacade<ProductEntity> implements ProductFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(ProductEntity.class);
    }

    @Override
    public void create(ProductDTO productDTO) {
        
        ProductEntity productEntity = new ProductEntity();
        
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setGenre(productDTO.getGenre());
        productEntity.setName(productDTO.getName());
        productEntity.setPlatform(productDTO.getPlatform());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setType(productDTO.getType());
        
        em.persist(productEntity);
    }

    @Override
    public void edit(ProductDTO productDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(ProductDTO productDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() {
       List<ProductEntity> listaProduct = super.findAll();
       return listaProduct;
    }

    @Override
    public List<ProductDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProductDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
