/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "shipping_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingAddress.findAll", query = "SELECT s FROM ShippingAddress s"),
    @NamedQuery(name = "ShippingAddress.findByIdShippingAddress", query = "SELECT s FROM ShippingAddress s WHERE s.idShippingAddress = :idShippingAddress")})
public class ShippingAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shipping_address")
    private Integer idShippingAddress;

    public ShippingAddress() {
    }

    public ShippingAddress(Integer idShippingAddress) {
        this.idShippingAddress = idShippingAddress;
    }

    public Integer getIdShippingAddress() {
        return idShippingAddress;
    }

    public void setIdShippingAddress(Integer idShippingAddress) {
        this.idShippingAddress = idShippingAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShippingAddress != null ? idShippingAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingAddress)) {
            return false;
        }
        ShippingAddress other = (ShippingAddress) object;
        if ((this.idShippingAddress == null && other.idShippingAddress != null) || (this.idShippingAddress != null && !this.idShippingAddress.equals(other.idShippingAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.ShippingAddress[ idShippingAddress=" + idShippingAddress + " ]";
    }
    
}
