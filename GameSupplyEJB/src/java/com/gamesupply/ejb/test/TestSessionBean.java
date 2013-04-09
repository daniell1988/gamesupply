/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.test;

import javax.ejb.Stateless;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class TestSessionBean implements TestSessionBeanLocal,TestSessionBeanRemote  {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getHello() {
        return "Chuppa";
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String newHello() {
        return "Local and Remote: New Hello ";
    }

}
