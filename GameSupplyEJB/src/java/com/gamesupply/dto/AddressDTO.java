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
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idAddress;
    private String address;
    private String addressComplement;
    private String country;
    private String state;
    private String city;
    private String zip;
    private String phoneNumber;
    private String addressDescription;
    private CustomerDTO idCustomer;

    public AddressDTO() {
    }

    public AddressDTO(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public AddressDTO(Integer idAddress, String address, String addressComplement, String country, String state, String city, String zip, String phoneNumber, String addressDescription) {
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

    public CustomerDTO getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(CustomerDTO idCustomer) {
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
        if (!(object instanceof AddressDTO)) {
            return false;
        }
        AddressDTO other = (AddressDTO) object;
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
