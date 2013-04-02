/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.bean;

import com.gamesupply.entity.Genre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface GenreFacadeLocal {

    void create(Genre genre);

    void edit(Genre genre);

    void remove(Genre genre);

    Genre find(Object id);

    List<Genre> findAll();

    List<Genre> findRange(int[] range);

    int count();
    
}
