/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.WishlistFacadeRemote;
import com.gamesupply.entity.WishlistEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
public class WishlistFacade extends AbstractFacade<WishlistEntity> implements WishlistFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WishlistFacade() {
        super(WishlistEntity.class);
    }

    @Override
    public void create(StockDTO stockDTO) {
        
        WishlistEntity stockEntity = new WishlistEntity();
        
        stockEntity.setDescription(stockDTO.getDescription());
        stockEntity.setGenre(stockDTO.getGenre());
        stockEntity.setName(stockDTO.getName());
        stockEntity.setPlatform(stockDTO.getPlatform());
        stockEntity.setPrice(stockDTO.getPrice());
        stockEntity.setType(stockDTO.getType());
        stockEntity.setBranch1(stockDTO.getBranch1());
        stockEntity.setBranch2(stockDTO.getBranch2());
        stockEntity.setBranch3(stockDTO.getBranch3());
        
        em.persist(stockEntity);
    }

    @Override
    public void edit(StockDTO stockDTO) {
        
        WishlistEntity stockEntity = new WishlistEntity();
        stockEntity.setIdProduct(stockDTO.getIdProduct());
        stockEntity.setBranch1(stockDTO.getBranch1());
        stockEntity.setBranch2(stockDTO.getBranch2());
        stockEntity.setBranch3(stockDTO.getBranch3());
        stockEntity.setDescription(stockDTO.getDescription());
        stockEntity.setGenre(stockDTO.getGenre());
        stockEntity.setName(stockDTO.getName());
        stockEntity.setPlatform(stockDTO.getPlatform());
        stockEntity.setPrice(stockDTO.getPrice());
        stockEntity.setType(stockDTO.getType());
        
        em.merge(stockEntity);
        
    }

    @Override
    public void remove(StockDTO stockDTO) {
        
        WishlistEntity stockEntity = new WishlistEntity();
        
//        stockEntity.setDescription(stockDTO.getDescription());
//        stockEntity.setGenre(stockDTO.getGenre());
//        stockEntity.setName(stockDTO.getName());
//        stockEntity.setPlatform(stockDTO.getPlatform());
//        stockEntity.setPrice(stockDTO.getPrice());
//        stockEntity.setType(stockDTO.getType());
//        stockEntity.setBranch1(stockDTO.getBranch1());
//        stockEntity.setBranch2(stockDTO.getBranch2());
//        stockEntity.setBranch3(stockDTO.getBranch3());
        stockEntity.setIdProduct(stockDTO.getIdProduct());
        
//        Query q = em.createQuery("select object(o) from WishlistEntity as o");
//        List<WishlistEntity> stockListEntity = q.getResultList();
//        
        
        em.remove(em.merge(stockEntity));
        
    }

    @Override
    public StockDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() {
        
        Query q = em.createQuery("select object(o) from WishlistEntity as o");
        List<WishlistEntity> stockListEntity = q.getResultList();
        List<StockDTO> stockList = new ArrayList<StockDTO>();
        for(WishlistEntity stockEntity : stockListEntity){
            
            StockDTO stockDTO = new StockDTO();
            stockDTO.setBranch1(stockEntity.getBranch1());
            stockDTO.setBranch2(stockEntity.getBranch2());
            stockDTO.setBranch3(stockEntity.getBranch3());
            stockDTO.setDescription(stockEntity.getDescription());
            stockDTO.setGenre(stockEntity.getGenre());
            stockDTO.setIdProduct(stockEntity.getIdProduct());
            stockDTO.setName(stockEntity.getName());
            stockDTO.setPlatform(stockEntity.getPlatform());
            stockDTO.setPrice(stockEntity.getPrice());
            stockDTO.setType(stockEntity.getType());
            
            stockList.add(stockDTO);
        }
        
        
        return stockList;
        
        
        
    }

    @Override
    public List<StockDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<StockDTO> findByCustomer(Integer customer) {
        Query q = em.createNamedQuery("WishlistEntity.findByBranch3");
        q.setParameter("branch3", customer);
        
        List<WishlistEntity> stockListEntity = q.getResultList();
        List<StockDTO> stockList = new ArrayList<StockDTO>();
        for(WishlistEntity stockEntity : stockListEntity){
            
            StockDTO stockDTO = new StockDTO();
            stockDTO.setBranch1(stockEntity.getBranch1());
            stockDTO.setBranch2(stockEntity.getBranch2());
            stockDTO.setBranch3(stockEntity.getBranch3());
            stockDTO.setDescription(stockEntity.getDescription());
            stockDTO.setGenre(stockEntity.getGenre());
            stockDTO.setIdProduct(stockEntity.getIdProduct());
            stockDTO.setName(stockEntity.getName());
            stockDTO.setPlatform(stockEntity.getPlatform());
            stockDTO.setPrice(stockEntity.getPrice());
            stockDTO.setType(stockEntity.getType());
            
            stockList.add(stockDTO);
        }
        
        
        return stockList;
    }
    
}
