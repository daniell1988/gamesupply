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
public class InventortyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_branch")
    private int idBranch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_item")
    private int idProductItem;

    public InventortyPK() {
    }

    public InventortyPK(int idBranch, int idProductItem) {
        this.idBranch = idBranch;
        this.idProductItem = idProductItem;
    }

    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
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
        hash += (int) idBranch;
        hash += (int) idProductItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventortyPK)) {
            return false;
        }
        InventortyPK other = (InventortyPK) object;
        if (this.idBranch != other.idBranch) {
            return false;
        }
        if (this.idProductItem != other.idProductItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.InventortyPK[ idBranch=" + idBranch + ", idProductItem=" + idProductItem + " ]";
    }
    
}
