/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.BranchDTO;
import com.gamesupply.ejb.remote.BranchFacadeLocal;
import com.gamesupply.entity.Branch;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class BranchFacade extends AbstractFacade<Branch> implements BranchFacadeLocal {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BranchFacade() {
        super(Branch.class);
    }

    @Override
    public void create(BranchDTO branch) {
       Branch b = new Branch(); 
       b.setIdBranch(branch.getIdBranch()); 
       super.create(b);

    }
    
}
