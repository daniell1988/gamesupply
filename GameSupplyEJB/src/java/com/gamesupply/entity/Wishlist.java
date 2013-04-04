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
    @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w"),
    @NamedQuery(name = "Wishlist.findByIdCustomer", query = "SELECT w FROM Wishlist w WHERE w.wishlistPK.idCustomer = :idCustomer"),
    @NamedQuery(name = "Wishlist.findByIdProductItem", query = "SELECT w FROM Wishlist w WHERE w.wishlistPK.idProductItem = :idProductItem")})
public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WishlistPK wishlistPK;

    public Wishlist() {
    }

    public Wishlist(WishlistPK wishlistPK) {
        this.wishlistPK = wishlistPK;
    }

    public Wishlist(int idCustomer, int idProductItem) {
        this.wishlistPK = new WishlistPK(idCustomer, idProductItem);
    }

    public WishlistPK getWishlistPK() {
        return wishlistPK;
    }

    public void setWishlistPK(WishlistPK wishlistPK) {
        this.wishlistPK = wishlistPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishlistPK != null ? wishlistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.wishlistPK == null && other.wishlistPK != null) || (this.wishlistPK != null && !this.wishlistPK.equals(other.wishlistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.Wishlist[ wishlistPK=" + wishlistPK + " ]";
    }
    
}
