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

    void create(ProductDTO productDTO);

    void edit(ProductDTO productDTO);

    void remove(ProductDTO productDTO);

    ProductDTO find(Integer id);

    List<ProductDTO> findRange(Integer[] range);

    int count();

    List<ProductDTO> findAll();
    
}
