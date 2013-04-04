/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.BranchEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface BranchFacadeRemote {

    void create(BranchEntity branchEntity);

    void edit(BranchEntity branchEntity);

    void remove(BranchEntity branchEntity);

    BranchEntity find(Object id);

    List<BranchEntity> findAll();

    List<BranchEntity> findRange(int[] range);

    int count();
    
}
