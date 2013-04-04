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
@Table(name = "inventorty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventorty.findAll", query = "SELECT i FROM Inventorty i"),
    @NamedQuery(name = "Inventorty.findByIdBranch", query = "SELECT i FROM Inventorty i WHERE i.inventortyPK.idBranch = :idBranch"),
    @NamedQuery(name = "Inventorty.findByIdProductItem", query = "SELECT i FROM Inventorty i WHERE i.inventortyPK.idProductItem = :idProductItem")})
public class Inventorty implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventortyPK inventortyPK;

    public Inventorty() {
    }

    public Inventorty(InventortyPK inventortyPK) {
        this.inventortyPK = inventortyPK;
    }

    public Inventorty(int idBranch, int idProductItem) {
        this.inventortyPK = new InventortyPK(idBranch, idProductItem);
    }

    public InventortyPK getInventortyPK() {
        return inventortyPK;
    }

    public void setInventortyPK(InventortyPK inventortyPK) {
        this.inventortyPK = inventortyPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventortyPK != null ? inventortyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventorty)) {
            return false;
        }
        Inventorty other = (Inventorty) object;
        if ((this.inventortyPK == null && other.inventortyPK != null) || (this.inventortyPK != null && !this.inventortyPK.equals(other.inventortyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.Inventorty[ inventortyPK=" + inventortyPK + " ]";
    }
    
}
