/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.test;

import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface TestSessionBeanLocal {
    
    String getHello();

    String newHello();
}
