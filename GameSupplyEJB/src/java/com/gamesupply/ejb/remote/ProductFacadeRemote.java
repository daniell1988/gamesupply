/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.entity.ProductEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 40836665
 */
@Remote
public interface ProductFacadeRemote {

    void create(ProductDTO productDTO);

    void edit(ProductDTO productDTO);

    void remove(ProductDTO productDTO);

    ProductEntity find(Object id);

    List<ProductDTO> findAll();

    List<ProductDTO> findRange(int[] range);

    int count();
    
}
