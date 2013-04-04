/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "payment_term")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTermEntity.findAll", query = "SELECT p FROM PaymentTermEntity p"),
    @NamedQuery(name = "PaymentTermEntity.findByIdPaymentTerm", query = "SELECT p FROM PaymentTermEntity p WHERE p.idPaymentTerm = :idPaymentTerm")})
public class PaymentTermEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment_term")
    private Integer idPaymentTerm;

    public PaymentTermEntity() {
    }

    public PaymentTermEntity(Integer idPaymentTerm) {
        this.idPaymentTerm = idPaymentTerm;
    }

    public Integer getIdPaymentTerm() {
        return idPaymentTerm;
    }

    public void setIdPaymentTerm(Integer idPaymentTerm) {
        this.idPaymentTerm = idPaymentTerm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaymentTerm != null ? idPaymentTerm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTermEntity)) {
            return false;
        }
        PaymentTermEntity other = (PaymentTermEntity) object;
        if ((this.idPaymentTerm == null && other.idPaymentTerm != null) || (this.idPaymentTerm != null && !this.idPaymentTerm.equals(other.idPaymentTerm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.PaymentTermEntity[ idPaymentTerm=" + idPaymentTerm + " ]";
    }
    
}
