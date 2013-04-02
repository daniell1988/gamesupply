/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.bean;

import com.gamesupply.entity.Branch;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CUESTAS
 */
@Remote
public interface BranchFacadeLocal {

    void create(Branch branch);

    void edit(Branch branch);

    void remove(Branch branch);

    Branch find(Object id);

    List<Branch> findAll();

    List<Branch> findRange(int[] range);

    int count();
    
}
    