/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.PlatformEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CUESTAS
 */

public interface PlatformFacadeRemote {

    void create(PlatformEntity platformEntity);

    void edit(PlatformEntity platformEntity);

    void remove(PlatformEntity platformEntity);

    PlatformEntity find(Object id);

    List<PlatformEntity> findAll();

    List<PlatformEntity> findRange(int[] range);

    int count();
    
}
