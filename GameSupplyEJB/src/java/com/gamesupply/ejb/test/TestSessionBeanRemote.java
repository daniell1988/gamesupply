/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.test;

import javax.ejb.Remote;

/**
 *
 * @author CUESTAS
 */
@Remote
public interface TestSessionBeanRemote {

    String getHello();

    String newHello();
    
}
