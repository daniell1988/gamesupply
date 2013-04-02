/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.dto;

import java.io.Serializable;


/**
 *
 * @author CUESTAS
 */
public class BranchDTO implements Serializable {
    private static final long serialVersionUID = 1L;
   private Integer idBranch;

    public BranchDTO() {
    }

    public BranchDTO(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBranch != null ? idBranch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchDTO)) {
            return false;
        }
        BranchDTO other = (BranchDTO) object;
        if ((this.idBranch == null && other.idBranch != null) || (this.idBranch != null && !this.idBranch.equals(other.idBranch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.Branch[ idBranch=" + idBranch + " ]";
    }
    
}
