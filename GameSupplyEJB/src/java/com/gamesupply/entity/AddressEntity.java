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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressEntity.findAll", query = "SELECT a FROM AddressEntity a"),
    @NamedQuery(name = "AddressEntity.findByIdAddress", query = "SELECT a FROM AddressEntity a WHERE a.idAddress = :idAddress"),
    @NamedQuery(name = "AddressEntity.findByAddress", query = "SELECT a FROM AddressEntity a WHERE a.address = :address"),
    @NamedQuery(name = "AddressEntity.findByAddressComplement", query = "SELECT a FROM AddressEntity a WHERE a.addressComplement = :addressComplement"),
    @NamedQuery(name = "AddressEntity.findByCountry", query = "SELECT a FROM AddressEntity a WHERE a.country = :country"),
    @NamedQuery(name = "AddressEntity.findByState", query = "SELECT a FROM AddressEntity a WHERE a.state = :state"),
    @NamedQuery(name = "AddressEntity.findByCity", query = "SELECT a FROM AddressEntity a WHERE a.city = :city"),
    @NamedQuery(name = "AddressEntity.findByZip", query = "SELECT a FROM AddressEntity a WHERE a.zip = :zip"),
    @NamedQuery(name = "AddressEntity.findByPhoneNumber", query = "SELECT a FROM AddressEntity a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "AddressEntity.findByAddressDescription", query = "SELECT a FROM AddressEntity a WHERE a.addressDescription = :addressDescription")})
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_address")
    private Integer idAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "address_complement")
    private String addressComplement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "zip")
    private String zip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address_description")
    private String addressDescription;
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer")
    @ManyToOne(optional = false)
    private CustomerEntity idCustomer;

    public AddressEntity() {
    }

    public AddressEntity(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public AddressEntity(Integer idAddress, String address, String addressComplement, String country, String state, String city, String zip, String phoneNumber, String addressDescription) {
        this.idAddress = idAddress;
        this.address = address;
        this.addressComplement = addressComplement;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.addressDescription = addressDescription;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public CustomerEntity getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(CustomerEntity idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressEntity)) {
            return false;
        }
        AddressEntity other = (AddressEntity) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.AddressEntity[ idAddress=" + idAddress + " ]";
    }
    
}
