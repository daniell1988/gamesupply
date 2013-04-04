/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.ProductEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface ProductFacadeRemote {

    void create(ProductEntity productEntity);

    void edit(ProductEntity productEntity);

    void remove(ProductEntity productEntity);

    ProductEntity find(Object id);

    List<ProductEntity> findAll();

    List<ProductEntity> findRange(int[] range);

    int count();
    
}
