/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.InventortyEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface InventortyFacadeRemote {

    void create(InventortyEntity inventortyEntity);

    void edit(InventortyEntity inventortyEntity);

    void remove(InventortyEntity inventortyEntity);

    InventortyEntity find(Object id);

    List<InventortyEntity> findAll();

    List<InventortyEntity> findRange(int[] range);

    int count();
    
}
