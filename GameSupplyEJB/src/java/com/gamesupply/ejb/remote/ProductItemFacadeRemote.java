/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.ProductItemEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface ProductItemFacadeRemote {

    void create(ProductItemEntity productItemEntity);

    void edit(ProductItemEntity productItemEntity);

    void remove(ProductItemEntity productItemEntity);

    ProductItemEntity find(Object id);

    List<ProductItemEntity> findAll();

    List<ProductItemEntity> findRange(int[] range);

    int count();
    
}
