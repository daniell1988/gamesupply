/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.GenreEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface GenreFacadeRemote {

    void create(GenreEntity genreEntity);

    void edit(GenreEntity genreEntity);

    void remove(GenreEntity genreEntity);

    GenreEntity find(Object id);

    List<GenreEntity> findAll();

    List<GenreEntity> findRange(int[] range);

    int count();
    
}
