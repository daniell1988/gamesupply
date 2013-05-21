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
 * @author CUESTAS
 */
@Remote
public interface ProductFacadeRemote {

    void create(ProductDTO productEntity);

    void edit(ProductDTO productEntity);

    void remove(ProductDTO productEntity);

    ProductDTO find(Integer id);

    List<ProductDTO> findAll();

    List<ProductDTO> findRange(Integer[] range);

    int count();
    
}
