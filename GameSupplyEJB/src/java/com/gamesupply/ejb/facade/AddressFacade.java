/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.entity.AddressEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class AddressFacade extends AbstractFacade<AddressEntity> implements AddressFacadeRemote {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(AddressEntity.class);
    }

    @Override
    public void create(AddressDTO addressEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(AddressDTO addressEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(AddressDTO addressEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AddressDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public List<AddressDTO> findAll() {
       List<AddressEntity> lista = super.findAll();
       //verrer lista de entity
       //criar lista addressdto
       //retornar dto
    }

    @Override
    public List<AddressDTO> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
