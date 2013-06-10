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
    
    public String listOrder(Integer userId){
        
        try {
                orderFacade = (OrderFacadeRemote) GSUtils.dynamicLookup("OrderFacade");
            } catch (Exception e) {
                System.out.println("erro lookup web");
        }
        
        orderList = orderFacade.findByCustomer(userId);
        
        return "/pages/order/orderList.xhtml";
    }    
    
    public String createOrder(CurrentUser user){
        
        this.currentUser = user;
        addressDTO = getOrderAddress();
        
        String orderAddress = addressDTO.getAddress() + " " + addressDTO.getAddressComplement()
                + " - " + addressDTO.getZip() + " - " + addressDTO.getCity() + ", " + addressDTO.getState()
                + " " + addressDTO.getCountry();

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
            orderDTO.setPrice(cartItem.getPrice() * cartItem.getBranchQuantity());
            orderDTO.setProduct(cartItem.getName());
            orderDTO.setProductDescription(cartItem.getType() + " " + cartItem.getPlatform());
            orderDTO.setStatus("Separacao de Estoque");

            createOrderByBranch(orderDTO, cartItem);

        }
        
        return listOrder(user.getIdUser());
    }
    
    private void createOrderByBranch(OrderDTO orderDTO, StockDTO cartItem) {
        
        Integer totalCompra = cartItem.getBranchQuantity();
        Integer saldoCompra = totalCompra;

        if(cartItem.getBranch1() > 0){
            //saldo > venda
            if (cartItem.getBranch1() > saldoCompra ) {
                cartItem.setBranch1(cartItem.getBranch1() - saldoCompra);
                orderDTO.setBranch("Filial A");
                orderDTO.setQuantity(saldoCompra);
                saldoCompra = 0;
            } else { // venda maior que saldo
                orderDTO.setQuantity(cartItem.getBranch1());
                saldoCompra -= cartItem.getBranch1();
                cartItem.setBranch1(0);
                orderDTO.setBranch("Filial A");
            }    
            stockFacade.edit(cartItem);
            orderFacade.create(orderDTO);
        }

         if(cartItem.getBranch2() > 0 && saldoCompra > 0){
            if (cartItem.getBranch2() > saldoCompra ) {
                cartItem.setBranch2(cartItem.getBranch2() - saldoCompra);
                orderDTO.setBranch("Filial B");
                orderDTO.setQuantity(saldoCompra);
                saldoCompra = 0;
            } else {
                orderDTO.setQuantity(cartItem.getBranch2());
                saldoCompra -= cartItem.getBranch2();
                cartItem.setBranch2(0);
                orderDTO.setBranch("Filial B");
            }    
            stockFacade.edit(cartItem);
            orderFacade.create(orderDTO);
         }

         if(cartItem.getBranch3() > 0 && saldoCompra > 0){
            if (cartItem.getBranch3() > saldoCompra ) {
                cartItem.setBranch3(cartItem.getBranch3() - saldoCompra);
                orderDTO.setBranch("Filial C");
                orderDTO.setQuantity(saldoCompra);
                saldoCompra = 0;
            } else {
                orderDTO.setQuantity(cartItem.getBranch3());
                saldoCompra -= cartItem.getBranch3();
                cartItem.setBranch3(0);
                orderDTO.setBranch("Filial C");
            }    
            stockFacade.edit(cartItem);
            orderFacade.create(orderDTO);

         }
         
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
