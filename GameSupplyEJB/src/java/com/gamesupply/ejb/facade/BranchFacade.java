/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.dto.BranchDTO;
import com.gamesupply.ejb.remote.BranchFacadeLocal;
import com.gamesupply.entity.Branch;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.beanutils.BeanUtils;

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
        try {
            BeanUtils.copyProperties(b, branch);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BranchFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BranchFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
       //b.setIdBranch(branch.getIdBranch()); 
       super.create(b);

    }
    
}
