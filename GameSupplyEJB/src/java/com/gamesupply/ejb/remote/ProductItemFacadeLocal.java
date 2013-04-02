/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.ProductItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface ProductItemFacadeLocal {

    void create(ProductItem productItem);

    void edit(ProductItem productItem);

    void remove(ProductItem productItem);

    ProductItem find(Object id);

    List<ProductItem> findAll();

    List<ProductItem> findRange(int[] range);

    int count();
    
}
