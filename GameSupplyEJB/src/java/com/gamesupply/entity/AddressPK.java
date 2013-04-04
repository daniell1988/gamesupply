/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CUESTAS
 */
@Embeddable
public class AddressPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_address")
    private int idAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_customer")
    private int idCustomer;

    public AddressPK() {
    }

    public AddressPK(int idAddress, int idCustomer) {
        this.idAddress = idAddress;
        this.idCustomer = idCustomer;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAddress;
        hash += (int) idCustomer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressPK)) {
            return false;
        }
        AddressPK other = (AddressPK) object;
        if (this.idAddress != other.idAddress) {
            return false;
        }
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.AddressPK[ idAddress=" + idAddress + ", idCustomer=" + idCustomer + " ]";
    }
    
}
