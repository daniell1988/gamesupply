/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "platform")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlatformEntity.findAll", query = "SELECT p FROM PlatformEntity p"),
    @NamedQuery(name = "PlatformEntity.findByIdPlatform", query = "SELECT p FROM PlatformEntity p WHERE p.idPlatform = :idPlatform"),
    @NamedQuery(name = "PlatformEntity.findByPlatform", query = "SELECT p FROM PlatformEntity p WHERE p.platform = :platform")})
public class PlatformEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_platform")
    private Integer idPlatform;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "platform")
    private String platform;

    public PlatformEntity() {
    }

    public PlatformEntity(Integer idPlatform) {
        this.idPlatform = idPlatform;
    }

    public PlatformEntity(Integer idPlatform, String platform) {
        this.idPlatform = idPlatform;
        this.platform = platform;
    }

    public Integer getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(Integer idPlatform) {
        this.idPlatform = idPlatform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlatform != null ? idPlatform.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatformEntity)) {
            return false;
        }
        PlatformEntity other = (PlatformEntity) object;
        if ((this.idPlatform == null && other.idPlatform != null) || (this.idPlatform != null && !this.idPlatform.equals(other.idPlatform))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.PlatformEntity[ idPlatform=" + idPlatform + " ]";
    }
    
}
