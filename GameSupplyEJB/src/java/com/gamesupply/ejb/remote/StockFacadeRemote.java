/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.dto.StockDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 40836665
 */
@Local
public interface StockFacadeRemote {

    void create(ProductDTO stockEntity);

    void edit(ProductDTO stockEntity);

    void remove(ProductDTO stockEntity);

    StockDTO find(Integer id);

    List<StockDTO> findAll();

    List<StockDTO> findRange(int[] range);

    int count();
    
}
