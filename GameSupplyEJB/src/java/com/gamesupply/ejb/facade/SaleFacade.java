/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.SaleDTO;
import com.gamesupply.ejb.remote.SaleFacadeRemote;
import com.gamesupply.entity.SaleEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public List<SaleDTO> findByTodayAndBranch(String branch) {
        
        StringBuffer sb = new StringBuffer();
        
        SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");

        sb.append("select id_sale, name, platform, type, price, DATE_FORMAT(sale_date, '%d/%m/%Y') AS sale_date,  branch, quantity from sale ");
        sb.append("where DATE_FORMAT(sale_date, '%d/%m/%Y')  = '"+ today.format(new Date()) +"' ");
        sb.append("and branch = '"+branch+"'");

        Query q = em.createNativeQuery(sb.toString());
        List<Object[]> listE = q.getResultList();
        List<SaleDTO> todaySales = new ArrayList<SaleDTO>();
       
        for(int x=0;x<listE.size();x++){
            try {
            
                SaleDTO saleDTO = new SaleDTO();
                saleDTO.setBranch(listE.get(x)[6].toString()); 
                saleDTO.setSaleDate(today.parse(listE.get(x)[5].toString()));
                saleDTO.setIdSale(Integer.valueOf(listE.get(x)[0].toString()));
                saleDTO.setName(listE.get(x)[1].toString());
                saleDTO.setPlatform(listE.get(x)[2].toString());
                saleDTO.setPrice(listE.get(x)[4].toString());
                saleDTO.setQuantity(Integer.valueOf(listE.get(x)[7].toString()));
                saleDTO.setType(listE.get(x)[3].toString());
                
                todaySales.add(saleDTO);
                saleDTO=null;
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
 
            
        }
                
        return todaySales;
        
    }
    
}
