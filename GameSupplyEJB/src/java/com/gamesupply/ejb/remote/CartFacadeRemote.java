/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.CartEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface CartFacadeRemote {

    void create(CartEntity cartEntity);

    void edit(CartEntity cartEntity);

    void remove(CartEntity cartEntity);

    CartEntity find(Object id);

    List<CartEntity> findAll();

    List<CartEntity> findRange(int[] range);

    int count();
    
}
