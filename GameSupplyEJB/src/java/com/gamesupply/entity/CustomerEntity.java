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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CUESTAS
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerEntity.findAll", query = "SELECT c FROM CustomerEntity c"),
    @NamedQuery(name = "CustomerEntity.findByIdCustomer", query = "SELECT c FROM CustomerEntity c WHERE c.idCustomer = :idCustomer"),
    @NamedQuery(name = "CustomerEntity.findByAccessLevel", query = "SELECT c FROM CustomerEntity c WHERE c.accessLevel = :accessLevel"),
    @NamedQuery(name = "CustomerEntity.findByEmail", query = "SELECT c FROM CustomerEntity c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerEntity.findByFirstName", query = "SELECT c FROM CustomerEntity c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CustomerEntity.findByLastName", query = "SELECT c FROM CustomerEntity c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CustomerEntity.findByMobileNumber", query = "SELECT c FROM CustomerEntity c WHERE c.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "CustomerEntity.findByPhoneNumber", query = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "CustomerEntity.findByUserLogin", query = "SELECT c FROM CustomerEntity c WHERE c.userLogin = :userLogin"),
    @NamedQuery(name = "CustomerEntity.findByUserPassword", query = "SELECT c FROM CustomerEntity c WHERE c.userPassword = :userPassword")})
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Size(max = 255)
    @Column(name = "access_level")
    private String accessLevel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 255)
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Size(max = 255)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 255)
    @Column(name = "user_login")
    private String userLogin;
    @Size(max = 255)
    @Column(name = "user_password")
    private String userPassword;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerEntity)) {
            return false;
        }
        CustomerEntity other = (CustomerEntity) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.CustomerEntity[ idCustomer=" + idCustomer + " ]";
    }
    
}
