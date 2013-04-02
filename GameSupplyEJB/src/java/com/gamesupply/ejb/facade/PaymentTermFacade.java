/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.facade;

import com.gamesupply.ejb.remote.PaymentTermFacadeLocal;
import com.gamesupply.entity.PaymentTerm;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CUESTAS
 */
@Stateless
public class PaymentTermFacade extends AbstractFacade<PaymentTerm> implements PaymentTermFacadeLocal {
    @PersistenceContext(unitName = "GameSupplyEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentTermFacade() {
        super(PaymentTerm.class);
    }
    
}
