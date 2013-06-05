/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.entity.AddressEntity;
import com.gamesupply.entity.CustomerEntity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void create(AddressDTO addressDTO) {
       AddressEntity addressE = new AddressEntity();
       CustomerEntity customerE = new CustomerEntity();
//        try {
//                customerE.setIdCustomer(addressDTO.getIdCustomer().getIdCustomer());
                
                addressE.setAddress(addressDTO.getAddress());
                addressE.setAddressComplement(addressDTO.getAddressComplement());
                addressE.setAddressDescription(addressDTO.getAddressDescription());
                addressE.setCity(addressDTO.getCity());
                addressE.setCountry(addressDTO.getCountry());
                addressE.setIdCustomer(addressDTO.getIdCustomer());
                addressE.setPhoneNumber(addressDTO.getPhoneNumber());
                addressE.setState(addressDTO.getState());
                addressE.setZip(addressDTO.getZip());
            //System.out.println("BATEU NESSA PORRA");
            
//            BeanUtils.copyProperties(addressE, addressDTO);
//            BeanUtils.copyProperties(addressE.getIdCustomer(), addressDTO.getIdCustomer());
            
            
            em.persist(addressE);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(AddressFacade.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(AddressFacade.class.getName()).log(Level.SEVERE, null, ex);
//        }
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

    
    @Override
    public List findAll() {
       List<AddressEntity> lista = super.findAll();
       Iterator itr = lista.iterator();
       List<AddressDTO> listaDTO = new ArrayList<AddressDTO>();
//       while(itr.hasNext()){
//            try {
//                AddressDTO addressDTO = new AddressDTO();
//                AddressEntity addressEntity = (AddressEntity)itr.next();
//                BeanUtils.copyProperties(addressDTO, addressEntity);
//                listaDTO.add(addressDTO);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(AddressFacade.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InvocationTargetException ex) {
//                Logger.getLogger(AddressFacade.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
//       }
       //verrer lista de entity
       //criar lista addressdto
       //retornar dto
       return listaDTO;
    }

    @Override
    public List<AddressDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AddressDTO> findByCustomer(Integer customer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
