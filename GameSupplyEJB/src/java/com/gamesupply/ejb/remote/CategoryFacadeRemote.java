/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.CategoryEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface CategoryFacadeRemote {

    void create(CategoryEntity categoryEntity);

    void edit(CategoryEntity categoryEntity);

    void remove(CategoryEntity categoryEntity);

    CategoryEntity find(Object id);

    List<CategoryEntity> findAll();

    List<CategoryEntity> findRange(int[] range);

    int count();
    
}
