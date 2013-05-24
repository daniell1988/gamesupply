/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.dto.SaleDTO;
import com.gamesupply.entity.SaleEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface SaleFacadeRemote {

    void create(SaleDTO saleEntity);

    void edit(SaleDTO saleEntity);

    void remove(SaleDTO saleEntity);

    SaleDTO find(Integer id);

    List<SaleDTO> findAll();

    List<SaleDTO> findRange(Integer[] range);

    int count();
    
}
