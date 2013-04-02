/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.PaymentTerm;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface PaymentTermFacadeLocal {

    void create(PaymentTerm paymentTerm);

    void edit(PaymentTerm paymentTerm);

    void remove(PaymentTerm paymentTerm);

    PaymentTerm find(Object id);

    List<PaymentTerm> findAll();

    List<PaymentTerm> findRange(int[] range);

    int count();
    
}
