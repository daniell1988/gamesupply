/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.StockDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Daniel
 */
@Remote
public interface WishlistFacadeRemote {

    void create(StockDTO productDTO);

    void edit(StockDTO productDTO);

    void remove(StockDTO productDTO);

    StockDTO find(Integer id);

    List<StockDTO> findAll();

    List<StockDTO> findRange(Integer[] range);
    
    List<StockDTO> findByCustomer(Integer customer);

    int count();
    
}
