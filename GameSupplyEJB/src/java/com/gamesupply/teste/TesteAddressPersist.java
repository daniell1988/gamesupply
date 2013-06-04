/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.teste;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.facade.AddressFacade;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.ejb.test.TestSessionBeanLocal;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Daniel
 */
public class TesteAddressPersist {
    
    AddressFacadeRemote addressFacade = new AddressFacade();

    public void teste(){
        addressFacade = lookupAddressFacadeBean();
        AddressDTO address = new AddressDTO();
        CustomerDTO customer = new CustomerDTO();
        
        customer.setIdCustomer(Integer.valueOf(1));
        address.setAddress("Rua x");
        address.setAddressComplement("numro 90");
        address.setAddressDescription("ao lado da padaria");
        address.setCity("sao paulo");
        address.setCountry("brasil");
//        address.setIdCustomer(customer);
        address.setPhoneNumber("999+6999");
        address.setState("SP");
        address.setZip("22501-581");

        addressFacade.create(address);
        
    }
    
        public void teste2(){
        
        System.out.println(addressFacade.getClass().getSimpleName());
    }
    
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException{
        
        //new TesteAddressPersist().teste();
        new TesteAddressPersist().teste2();
        
    }

    private AddressFacadeRemote lookupAddressFacadeBean() {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
//          props.setProperty("org.omg.CORBA.ORBInitialHost", "10.49.31.1");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(props);            
            return (AddressFacadeRemote) ctx.lookup("java:global/GameSupplyCore/AddressFacade!com.gamesupply.ejb.remote.AddressFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
