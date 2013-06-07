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
 * @author Daniel
 */
@Entity
@Table(name = "ordercustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderEntity.findAll", query = "SELECT o FROM OrderEntity o"),
    @NamedQuery(name = "OrderEntity.findByIdOrder", query = "SELECT o FROM OrderEntity o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "OrderEntity.findByAddress", query = "SELECT o FROM OrderEntity o WHERE o.address = :address"),
    @NamedQuery(name = "OrderEntity.findByDelivery", query = "SELECT o FROM OrderEntity o WHERE o.delivery = :delivery"),
    @NamedQuery(name = "OrderEntity.findByIdCustomer", query = "SELECT o FROM OrderEntity o WHERE o.idCustomer = :idCustomer"),
    @NamedQuery(name = "OrderEntity.findByPayment", query = "SELECT o FROM OrderEntity o WHERE o.payment = :payment"),
    @NamedQuery(name = "OrderEntity.findByPrice", query = "SELECT o FROM OrderEntity o WHERE o.price = :price"),
    @NamedQuery(name = "OrderEntity.findByProduct", query = "SELECT o FROM OrderEntity o WHERE o.product = :product"),
    @NamedQuery(name = "OrderEntity.findByProductDescription", query = "SELECT o FROM OrderEntity o WHERE o.productDescription = :productDescription"),
    @NamedQuery(name = "OrderEntity.findByQuantity", query = "SELECT o FROM OrderEntity o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderEntity.findByStatus", query = "SELECT o FROM OrderEntity o WHERE o.status = :status")})
public class OrderEntity implements Serializable {
    @Size(max = 255)
    @Column(name = "branch")
    private String branch;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "delivery")
    private String delivery;
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Size(max = 255)
    @Column(name = "payment")
    private String payment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 255)
    @Column(name = "status")
    private String status;

    public OrderEntity() {
    }

    public OrderEntity(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderEntity)) {
            return false;
        }
        OrderEntity other = (OrderEntity) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesupply.entity.OrderEntity[ idOrder=" + idOrder + " ]";
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
}
