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
public class WishlistPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_item")
    private int idProductItem;

    public WishlistPK() {
    }

    public WishlistPK(int idCustomer, int idProductItem) {
        this.idCustomer = idCustomer;
        this.idProductItem = idProductItem;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProductItem() {
        return idProductItem;
    }

    public void setIdProductItem(int idProductItem) {
        this.idProductItem = idProductItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomer;
        hash += (int) idProductItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishlistPK)) {
            return false;
        }
        WishlistPK other = (WishlistPK) object;
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        if (this.idProductItem != other.idProductItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.WishlistPK[ idCustomer=" + idCustomer + ", idProductItem=" + idProductItem + " ]";
    }
    
}
