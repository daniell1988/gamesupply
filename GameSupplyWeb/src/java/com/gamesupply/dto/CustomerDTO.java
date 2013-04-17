/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author CUESTAS
 */
public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idCustomer;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String phoneNumber;
    private String userLogin;
    private String userPassword;
    private String email;
    private Collection<AddressDTO> addressDTOCollection;

    public CustomerDTO() {
        this.addressDTOCollection = new ArrayList<AddressDTO>();
    }

    public CustomerDTO(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public CustomerDTO(Integer idCustomer, String firstName, String lastName, String mobileNumber, String phoneNumber, String userLogin, String userPassword, String email) {
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.phoneNumber = phoneNumber;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.email = email;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<AddressDTO> getAddressDTOCollection() {
        return addressDTOCollection;
    }

    public void setAddressDTOCollection(Collection<AddressDTO> addressDTOCollection) {
        this.addressDTOCollection = addressDTOCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDTO)) {
            return false;
        }
        CustomerDTO other = (CustomerDTO) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.CustomerDTO[ idCustomer=" + idCustomer + " ]";
    }
    
}
