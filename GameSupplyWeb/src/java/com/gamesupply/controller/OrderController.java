/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.controller;

import com.gamesupply.dto.AddressDTO;
import com.gamesupply.dto.OrderDTO;
import com.gamesupply.dto.StockDTO;
import com.gamesupply.ejb.remote.OrderFacadeRemote;
import com.gamesupply.ejb.remote.StockFacadeRemote;
import com.gamesupply.util.GSUtils;
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
    private OrderFacadeRemote orderFacade;
    private StockFacadeRemote stockFacade;
    
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
        
//        orderDTO.setAddress(orderAddress);
//        orderDTO.setDelivery("Estimado em 4 dias úteis");
//        orderDTO.setIdCustomer(currentUser.getIdUser());
//        orderDTO.setPayment("Cartão de Crédito");
//        orderDTO.setPrice(Double.NaN);
//        orderDTO.setProduct(null);
//        orderDTO.setProductDescription(null);
//        orderDTO.setQuantity(Integer.SIZE);
//        orderDTO.setStatus(null);
        try {
                 orderFacade = (OrderFacadeRemote) GSUtils.dynamicLookup("OrderFacade");
                 stockFacade = (StockFacadeRemote) GSUtils.dynamicLookup("StockFacade");
            } catch (Exception e) {
                System.out.println("erro lookup web");
        }
        
        
        
        for(StockDTO cartItem : currentUser.getCart()){
            
            orderDTO.setAddress(orderAddress);
            orderDTO.setDelivery("Estimado em 4 dias úteis");
            orderDTO.setIdCustomer(currentUser.getIdUser());
            orderDTO.setPayment("Cartão de Crédito");
            orderDTO.setPrice(cartItem.getPrice());
            orderDTO.setProduct(cartItem.getName());
            orderDTO.setProductDescription(cartItem.getType() + " " + cartItem.getPlatform());
            orderDTO.setQuantity(cartItem.getBranchQuantity());
            orderDTO.setStatus("Separacao de Estoque");
            
            if(cartItem.getBranchQuantity() <= cartItem.getBranch1()){
                 orderDTO.setBranch("Filial A");
                 cartItem.setBranch1(cartItem.getBranch1() - cartItem.getBranchQuantity());
                 cartItem.setBranchQuantity(0);
                 
                 stockFacade.edit(cartItem);          
            }
            
            else if(cartItem.getBranchQuantity() <= cartItem.getBranch2()){
                 orderDTO.setBranch("Filial B");
                 
                 cartItem.setBranch2(cartItem.getBranch2() - cartItem.getBranchQuantity());
                 cartItem.setBranchQuantity(0);
                 
                 stockFacade.edit(cartItem); 
            }
            
            else if(cartItem.getBranchQuantity() <= cartItem.getBranch3()){
                 orderDTO.setBranch("Filial C");
                 
                 cartItem.setBranch3(cartItem.getBranch3() - cartItem.getBranchQuantity());
                 cartItem.setBranchQuantity(0);
                 
                 stockFacade.edit(cartItem); 
            }
            
            

            orderFacade.create(orderDTO);
            
            //atualizar estoque
            
        }
        
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

    public OrderFacadeRemote getOrderFacade() {
        return orderFacade;
    }

    public void setOrderFacade(OrderFacadeRemote orderFacade) {
        this.orderFacade = orderFacade;
    }

    public StockFacadeRemote getStockFacade() {
        return stockFacade;
    }

    public void setStockFacade(StockFacadeRemote stockFacade) {
        this.stockFacade = stockFacade;
    }
    
    
    
}
