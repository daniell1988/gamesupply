/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.ejb.remote.ProductFacadeRemote;
import com.gamesupply.dto.ProductDTO;
import com.gamesupply.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        
        ProductEntity productEntity = new ProductEntity();
        productEntity.setIdProduct(productDTO.getIdProduct());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setGenre(productDTO.getGenre());
        productEntity.setName(productDTO.getName());
        productEntity.setPlatform(productDTO.getPlatform());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setType(productDTO.getType());
        
        em.merge(productEntity);
        
    }

    @Override
    public void remove(ProductDTO productDTO) {
        
         
        
        ProductEntity productEntity = new ProductEntity();
        productEntity = em.find(ProductEntity.class, productDTO.getIdProduct());        
        em.remove(productEntity);
        
    }

    @Override
    public ProductEntity find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() {
        Query q = em.createQuery("select object(o) from ProductEntity as o");
        List<ProductEntity> productListEntity = q.getResultList();
        List<ProductDTO> productList = new ArrayList<ProductDTO>();
        
        for(ProductEntity productEntity : productListEntity){
            
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription(productEntity.getDescription());
            productDTO.setGenre(productEntity.getGenre());
            productDTO.setIdProduct(productEntity.getIdProduct());
            productDTO.setName(productEntity.getName());
            productDTO.setPlatform(productEntity.getPlatform());
            productDTO.setPrice(productEntity.getPrice());
            productDTO.setType(productEntity.getType());
            
            productList.add(productDTO);
        }
        
        
        return productList;
    }

    @Override
    public List<ProductDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
