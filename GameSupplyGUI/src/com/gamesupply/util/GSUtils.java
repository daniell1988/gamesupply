/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.util;

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
public class GSUtils {
    
//    private static final String host = "10.49.31.1";
    private static final String host = "localhost";
    private static final String port = "3700";

    public static Object dynamicLookup(String classe) {
        try {
            Properties props = new Properties();
            
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", host);
            props.setProperty("org.omg.CORBA.ORBInitialPort", port);
            
            InitialContext ctx = new InitialContext(props);     
            
            return ctx.lookup(getDynamicLookupContext(classe));
            
        } catch (NamingException ne) {
            
            Logger.getLogger(classe.getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            
            throw new RuntimeException(ne);
        }
    }
    
    private static String getDynamicLookupContext(String nomeClasse){
        
        StringBuffer sb = new StringBuffer();
       
        sb.append("java:global/GameSupplyCore/");
        sb.append(nomeClasse);
        sb.append("!com.gamesupply.ejb.remote.");
        sb.append(nomeClasse);
        sb.append("Remote");
        
        return sb.toString();
    
    }
    
    
}
