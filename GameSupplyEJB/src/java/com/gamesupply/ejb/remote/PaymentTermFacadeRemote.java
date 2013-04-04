/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.ejb.remote;

import com.gamesupply.entity.PaymentTermEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CUESTAS
 */
@Local
public interface PaymentTermFacadeRemote {

    void create(PaymentTermEntity paymentTermEntity);

    void edit(PaymentTermEntity paymentTermEntity);

    void remove(PaymentTermEntity paymentTermEntity);

    PaymentTermEntity find(Object id);

    List<PaymentTermEntity> findAll();

    List<PaymentTermEntity> findRange(int[] range);

    int count();
    
}
