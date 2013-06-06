/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.OrderDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author CUESTAS
 */
@ManagedBean
@SessionScoped
public class OrderController {
    
    private OrderDTO orderDTO;
    private CurrentUser currentUser;
    private List<AddressDTO> addressDTOList;
    private AddressDTO addressDTO;
    private List<OrderDTO> orderList;
    
    @PostConstruct
    public void init(){
        orderDTO = new OrderDTO();
    }
    
    
    public String createOrder(CurrentUser user){
        
        this.currentUser = user;
        addressDTO = getOrderAddress();
        
        String orderAddress = addressDTO.getAddress() + " " + addressDTO.getAddressComplement()
                + " - " + addressDTO.getZip() + " - " + addressDTO.getCity() + ", " + addressDTO.getState()
                + " " + addressDTO.getCountry(); //prazo curto
        
        orderDTO.setAddress(orderAddress);
        orderDTO.setDelivery("Estimado em 4 dias úteis");
        orderDTO.setIdCustomer(currentUser.getIdUser());
//        orderDTO.setPayment(currentUser.);
//        orderDTO.setPrice(Double.NaN);
//        orderDTO.setProduct(null);
//        orderDTO.setProductDescription(null);
//        orderDTO.setQuantity(Integer.SIZE);
//        orderDTO.setStatus(null);
        
        return "/pages/order/orderList.xhtml";
    }
    
    public AddressDTO getOrderAddress(){
        
        AddressController addressController = new AddressController();
        addressDTOList = addressController.findByCustomer(currentUser.getCustomer());
        AddressDTO tmpAddress = new AddressDTO();
        
        for(AddressDTO address : addressDTOList){
            if(currentUser.getIdOrderAddress().intValue() == address.getIdAddress().intValue()){
                tmpAddress = address;
                continue;
            }
        }
        
        return tmpAddress;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public List<AddressDTO> getAddressDTOList() {
        return addressDTOList;
    }

    public void setAddressDTOList(List<AddressDTO> addressDTOList) {
        this.addressDTOList = addressDTOList;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }
    
    
}
