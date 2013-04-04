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
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByIdCostumer", query = "SELECT c FROM Cart c WHERE c.cartPK.idCostumer = :idCostumer"),
    @NamedQuery(name = "Cart.findByIdProductItem", query = "SELECT c FROM Cart c WHERE c.cartPK.idProductItem = :idProductItem")})
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartPK cartPK;

    public Cart() {
    }

    public Cart(CartPK cartPK) {
        this.cartPK = cartPK;
    }

    public Cart(int idCostumer, int idProductItem) {
        this.cartPK = new CartPK(idCostumer, idProductItem);
    }

    public CartPK getCartPK() {
        return cartPK;
    }

    public void setCartPK(CartPK cartPK) {
        this.cartPK = cartPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartPK != null ? cartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartPK == null && other.cartPK != null) || (this.cartPK != null && !this.cartPK.equals(other.cartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.Cart[ cartPK=" + cartPK + " ]";
    }
    
}
