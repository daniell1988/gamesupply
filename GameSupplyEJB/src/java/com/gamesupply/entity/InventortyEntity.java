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
    @NamedQuery(name = "InventortyEntity.findAll", query = "SELECT i FROM InventortyEntity i"),
    @NamedQuery(name = "InventortyEntity.findByIdBranch", query = "SELECT i FROM InventortyEntity i WHERE i.inventortyEntityPK.idBranch = :idBranch"),
    @NamedQuery(name = "InventortyEntity.findByIdProductItem", query = "SELECT i FROM InventortyEntity i WHERE i.inventortyEntityPK.idProductItem = :idProductItem")})
public class InventortyEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventortyEntityPK inventortyEntityPK;

    public InventortyEntity() {
    }

    public InventortyEntity(InventortyEntityPK inventortyEntityPK) {
        this.inventortyEntityPK = inventortyEntityPK;
    }

    public InventortyEntity(int idBranch, int idProductItem) {
        this.inventortyEntityPK = new InventortyEntityPK(idBranch, idProductItem);
    }

    public InventortyEntityPK getInventortyEntityPK() {
        return inventortyEntityPK;
    }

    public void setInventortyEntityPK(InventortyEntityPK inventortyEntityPK) {
        this.inventortyEntityPK = inventortyEntityPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventortyEntityPK != null ? inventortyEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventortyEntity)) {
            return false;
        }
        InventortyEntity other = (InventortyEntity) object;
        if ((this.inventortyEntityPK == null && other.inventortyEntityPK != null) || (this.inventortyEntityPK != null && !this.inventortyEntityPK.equals(other.inventortyEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.InventortyEntity[ inventortyEntityPK=" + inventortyEntityPK + " ]";
    }
    
}
