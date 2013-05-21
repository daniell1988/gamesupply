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
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartEntity.findAll", query = "SELECT c FROM CartEntity c"),
    @NamedQuery(name = "CartEntity.findByIdProductItem", query = "SELECT c FROM CartEntity c WHERE c.cartEntityPK.idProductItem = :idProductItem"),
    @NamedQuery(name = "CartEntity.findByIdCostumer", query = "SELECT c FROM CartEntity c WHERE c.cartEntityPK.idCostumer = :idCostumer")})
public class CartEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartEntityPK cartEntityPK;

    public CartEntity() {
    }

    public CartEntity(CartEntityPK cartEntityPK) {
        this.cartEntityPK = cartEntityPK;
    }

    public CartEntity(int idProductItem, int idCostumer) {
        this.cartEntityPK = new CartEntityPK(idProductItem, idCostumer);
    }

    public CartEntityPK getCartEntityPK() {
        return cartEntityPK;
    }

    public void setCartEntityPK(CartEntityPK cartEntityPK) {
        this.cartEntityPK = cartEntityPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartEntityPK != null ? cartEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartEntity)) {
            return false;
        }
        CartEntity other = (CartEntity) object;
        if ((this.cartEntityPK == null && other.cartEntityPK != null) || (this.cartEntityPK != null && !this.cartEntityPK.equals(other.cartEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.CartEntity[ cartEntityPK=" + cartEntityPK + " ]";
    }
    
}
