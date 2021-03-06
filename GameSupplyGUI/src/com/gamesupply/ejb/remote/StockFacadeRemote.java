/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.ProductDTO;
import com.gamesupply.dto.StockDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author cuestas
 */
@Remote
public interface StockFacadeRemote {

    void create(StockDTO productDTO);

    void edit(StockDTO stockDTO);

    void remove(StockDTO stockDTO);

    StockDTO find(Integer id);

    List<StockDTO> findAll();

    List<StockDTO> findRange(Integer[] range);

    int count();
    
}
