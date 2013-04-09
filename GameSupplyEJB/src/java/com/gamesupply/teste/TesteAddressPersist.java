/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.teste;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import com.gamesupply.ejb.test.TestSessionBeanLocal;
import com.gamesupply.ejb.test.TestSessionBeanRemote;
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

    //TestSessionBeanRemote addressFacade = lookupAddressFacadeBean();
    AddressFacadeRemote addressFacade = null;
    //TestSessionBeanLocal addressFacadeLocal = lookupAddressFacadeBeanLocal();
    //TestSessionBeanRemote addressFacade = null;
    
    public void teste2() {
        //System.out.println(addressFacadeLocal.getHelloLocal());
        //addressFacade = lookupAddressFacadeBean();
        //System.out.println(addressFacade.getHello());
       // System.out.println(addressFacade.newHello());
    }
    
    public void teste(){
        addressFacade = lookupAddressFacadeBean();
        AddressDTO address = new AddressDTO();
        CustomerDTO customer = new CustomerDTO();
        
        customer.setIdCustomer(1);
        address.setAddress("aaa");
        address.setAddressComplement("bbb");
        address.setAddressDescription("ccc");
        address.setCity("aaa");
        address.setCountry("aaa");
   //   address.setIdAddress(Integer.MIN_VALUE);
        address.setIdCustomer(customer);
        address.setPhoneNumber("aaa");
        address.setState("aaa");
        address.setZip("aaa");
        
       
        addressFacade.create(address);
        
        
    }
    
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException{
        
        new TesteAddressPersist().teste();
        
    }

    private AddressFacadeRemote lookupAddressFacadeBean() {
        try {
            //System.setProperty("java.security.auth.login.config", "C:\\Program Files\\glassfish-3.1.2.2\\glassfish\\lib\\appclient\\appclientlogin.conf");
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "10.49.31.1");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(props);            
            //Context c = new InitialContext();
            return (AddressFacadeRemote) ctx.lookup("java:global/GameSupplyCore/AddressFacade!com.gamesupply.ejb.remote.AddressFacadeRemote");
            // retorna ERRO
            //return (TestSessionBeanRemote) ctx.lookup("java:global/GameSupplyCore/TestSessionBean");
            //return (TestSessionBeanRemote) ctx.lookup("java:global/GameSupplyCore/TestSessionBean");
            // retorna ERRO
            //return (TestSessionBeanRemote) ctx.lookup("com.gamesupply.ejb.test.TestSessionBean");
            //return (TestSessionBeanRemote) ctx.lookup("java:global/GameSupplyCore/TestSessionBean!com.gamesupply.ejb.test.TestSessionBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TestSessionBeanLocal lookupAddressFacadeBeanLocal() {
        try {
            //System.setProperty("java.security.auth.login.config", "C:\\Program Files\\glassfish-3.1.2.2\\glassfish\\lib\\appclient\\appclientlogin.conf");
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "10.49.31.1");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(props);            
            //Context c = new InitialContext();
            return (TestSessionBeanLocal) ctx.lookup("java:global/GameSupplyCore/TestSessionBean!com.gamesupply.ejb.test.TestSessionBeanRemote");
            //return (TestSessionBeanLocal) ctx.lookup("java:global/GameSupplyCore/TestSessionBean");
            //return (TestSessionBeanLocal) ctx.lookup("TestSessionBean");
            //return (TestSessionBeanLocal) ctx.lookup("com.gamesupply.ejb.test.TestSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
