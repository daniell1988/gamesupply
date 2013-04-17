/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.CustomerFacadeRemote;
import com.gamesupply.entity.AddressEntity;
import com.gamesupply.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        
        Collection<AddressEntity> addressList = new ArrayList<AddressEntity>();
        Iterator itr = customerDTO.getAddressDTOCollection().iterator();
        while(itr.hasNext()){
            
            AddressDTO addressDTO = (AddressDTO) itr.next();
            AddressEntity addressE = new AddressEntity();
            
            addressE.setAddress(addressDTO.getAddress());
            addressE.setAddressComplement(addressDTO.getAddressComplement());
            addressE.setAddressDescription(addressDTO.getAddressDescription());
            addressE.setCity(addressDTO.getCity());
            addressE.setCountry(addressDTO.getCountry());
            addressE.setIdCustomer(customerE);
            addressE.setPhoneNumber(addressDTO.getPhoneNumber());
            addressE.setState(addressDTO.getState());
            addressE.setZip(addressDTO.getZip());
            
            addressList.add(addressE);
        }
        
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
        
        CustomerEntity customerE = new CustomerEntity();
        Collection addressList = customerDTO.getAddressDTOCollection();
        
        customerE.setIdCustomer(customerDTO.getIdCustomer());
        customerE.setAddressEntityCollection(addressList);
        customerE.setEmail(customerDTO.getEmail());
        customerE.setFirstName(customerDTO.getFirstName());
        customerE.setLastName(customerDTO.getLastName());
        customerE.setMobileNumber(customerDTO.getMobileNumber());
        customerE.setPhoneNumber(customerDTO.getPhoneNumber());
        customerE.setUserLogin(customerDTO.getUserLogin());
        customerE.setUserPassword(customerDTO.getUserPassword());
        
        em.merge(customerE);
    }
    
    @Override
    public CustomerDTO login(String user, String pass) {
        

        CustomerEntity customerE = new CustomerEntity();
        customerE.setUserLogin(user);
        Query q = em.createNamedQuery("CustomerEntity.findByUserLogin");
        q.setParameter("userLogin", user);

        List listE = q.getResultList();

        Iterator itr = listE.iterator();
        CustomerDTO customerDTO = new CustomerDTO();
        
         while (itr.hasNext()){
            

            CustomerEntity customerEntity = (CustomerEntity) itr.next();

            customerDTO.setIdCustomer(customerEntity.getIdCustomer());
            customerDTO.setEmail(customerEntity.getEmail());
            customerDTO.setFirstName(customerEntity.getFirstName());
            customerDTO.setLastName(customerEntity.getLastName());
            customerDTO.setMobileNumber(customerEntity.getMobileNumber());
            customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
            customerDTO.setUserLogin(customerEntity.getUserLogin());
            customerDTO.setUserPassword(customerEntity.getUserPassword());

        }
        
        return customerDTO;
    }

    @Override
    public void remove(CustomerDTO customerDTO) {
        
        CustomerEntity customerE = new CustomerEntity();
        Collection addressList = customerDTO.getAddressDTOCollection();
        
          //Busco o registro conforme o id informado:

        customerE = em.find(CustomerEntity.class, customerDTO.getIdCustomer());



        //Se achou o registro, deleta a febre do rato

        if(customerE != null) {
            em.remove(customerE);
        }
    }

    @Override
    public CustomerDTO find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List findAll() {
        
        Query q = em.createQuery("select object(o) from CustomerEntity as o");
        List listE = q.getResultList();
        List customer = new ArrayList();
        
        Iterator itr = listE.iterator();
        
        while (itr.hasNext()){
            
            CustomerDTO customerDTO = new CustomerDTO();
            CustomerEntity customerEntity = (CustomerEntity) itr.next();
            
//                    customerDTO.setAddressEntityCollection(addressList);
            
            customerDTO.setIdCustomer(customerEntity.getIdCustomer());
            customerDTO.setEmail(customerEntity.getEmail());
            customerDTO.setFirstName(customerEntity.getFirstName());
            customerDTO.setLastName(customerEntity.getLastName());
            customerDTO.setMobileNumber(customerEntity.getMobileNumber());
            customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
            customerDTO.setUserLogin(customerEntity.getUserLogin());
            customerDTO.setUserPassword(customerEntity.getUserPassword());
            
            customer.add(customerDTO);
            
        }
        
        
        return customer;
        
    }

    @Override
    public List<CustomerDTO> findRange(Integer[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
