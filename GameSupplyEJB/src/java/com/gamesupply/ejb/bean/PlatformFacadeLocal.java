/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.bean;

import com.gamesupply.entity.Platform;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface PlatformFacadeLocal {

    void create(Platform platform);

    void edit(Platform platform);

    void remove(Platform platform);

    Platform find(Object id);

    List<Platform> findAll();

    List<Platform> findRange(int[] range);

    int count();
    
}
