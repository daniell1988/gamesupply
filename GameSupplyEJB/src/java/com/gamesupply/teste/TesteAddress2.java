/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.teste;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.CustomerDTO;
import com.gamesupply.ejb.remote.AddressFacadeRemote;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Daniel
 */
public class TesteAddress2 {
    
  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("java.security.auth.login.config", "C:\\Program Files (x86)\\glassfish-3.1.2.2\\glassfish\\lib\\appclient\\appclientlogin.conf");
 
        AddressFacadeRemote addressFacadeRemote = null;
 
 
 
        Properties props = new Properties();
 
        props.setProperty("org.omg.CORBA.ORBInitialHost", "10.49.31.1"); // default!
 
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); // default!
 
        InitialContext context = null;
        try {
            context = new InitialContext(props);
        } catch (NamingException ex) {
            Logger.getLogger(TesteAddress2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //   ProgrammaticLogin login = new ProgrammaticLogin();
 
           //   ProgrammaticLogin login = new ProgrammaticLogin();
 
               addressFacadeRemote = (AddressFacadeRemote) context.lookup("teste.ejb.HelloBeanRemote");
        } catch (NamingException ex) {
            Logger.getLogger(TesteAddress2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
 
        addressFacadeRemote.create(address);
 
        System.out.printf("Got Answer:%ngreeting=%s%n");
    }
}
