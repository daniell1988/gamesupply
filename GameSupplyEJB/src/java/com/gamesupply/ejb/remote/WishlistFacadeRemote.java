/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.WishlistEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface WishlistFacadeRemote {

    void create(WishlistEntity wishlistEntity);

    void edit(WishlistEntity wishlistEntity);

    void remove(WishlistEntity wishlistEntity);

    WishlistEntity find(Object id);

    List<WishlistEntity> findAll();

    List<WishlistEntity> findRange(int[] range);

    int count();
    
}
