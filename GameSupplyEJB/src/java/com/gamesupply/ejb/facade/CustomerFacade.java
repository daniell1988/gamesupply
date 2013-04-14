/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class CustomerFacade extends AbstractFacade<CustomerEntity> implements CustomerFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(CustomerEntity.class);
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        
        CustomerEntity customerE = new CustomerEntity();
        Collection addressList = customerDTO.getAddressDTOCollection();
        
        customerE.setAddressEntityCollection(addressList);
        customerE.setEmail(customerDTO.getEmail());
        customerE.setFirstName(customerDTO.getFirstName());
        customerE.setLastName(customerDTO.getLastName());
        customerE.setMobileNumber(customerDTO.getMobileNumber());
        customerE.setPhoneNumber(customerDTO.getPhoneNumber());
        customerE.setUserLogin(customerDTO.getUserLogin());
        customerE.setUserPassword(customerDTO.getUserPassword());
        
        em.persist(customerE);

    }

    @Override
    public void edit(CustomerDTO customerDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(CustomerDTO customerDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CustomerDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List findAll() {
        
        return em.createQuery("select object(o) from Customer as o").getResultList();
        
    }

    @Override
    public List<CustomerDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
