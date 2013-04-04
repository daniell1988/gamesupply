/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "wishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishlistEntity.findAll", query = "SELECT w FROM WishlistEntity w"),
    @NamedQuery(name = "WishlistEntity.findByIdCustomer", query = "SELECT w FROM WishlistEntity w WHERE w.wishlistEntityPK.idCustomer = :idCustomer"),
    @NamedQuery(name = "WishlistEntity.findByIdProductItem", query = "SELECT w FROM WishlistEntity w WHERE w.wishlistEntityPK.idProductItem = :idProductItem")})
public class WishlistEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WishlistEntityPK wishlistEntityPK;

    public WishlistEntity() {
    }

    public WishlistEntity(WishlistEntityPK wishlistEntityPK) {
        this.wishlistEntityPK = wishlistEntityPK;
    }

    public WishlistEntity(int idCustomer, int idProductItem) {
        this.wishlistEntityPK = new WishlistEntityPK(idCustomer, idProductItem);
    }

    public WishlistEntityPK getWishlistEntityPK() {
        return wishlistEntityPK;
    }

    public void setWishlistEntityPK(WishlistEntityPK wishlistEntityPK) {
        this.wishlistEntityPK = wishlistEntityPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishlistEntityPK != null ? wishlistEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishlistEntity)) {
            return false;
        }
        WishlistEntity other = (WishlistEntity) object;
        if ((this.wishlistEntityPK == null && other.wishlistEntityPK != null) || (this.wishlistEntityPK != null && !this.wishlistEntityPK.equals(other.wishlistEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.WishlistEntity[ wishlistEntityPK=" + wishlistEntityPK + " ]";
    }
    
}
