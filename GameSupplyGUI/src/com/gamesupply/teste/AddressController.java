///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.gamesupply.teste;
//
//import com.gamesupply.util.GSUtils;
//
///**
// *
// * @author CUESTAS
// */
//public class AddressController {
//    
//
//    private AddressDTO address = null;
//    private CustomerDTO customer = null;
//    private AddressFacadeRemote addressFacade = null;
//    
//    public void create(){
//        
//        try {
//             addressFacade = (AddressFacadeRemote) GSUtils.dynamicLookup("AddressFacade");
//        } catch (Exception e) {
//            System.out.println("erro lookup web");
//        }
//        customer = new CustomerDTO();
//        address = new AddressDTO();
//        customer.setIdCustomer(Integer.valueOf(1));
//        address.setAddress("RODANDO DO SWING");
//        address.setAddressComplement("numro 90");
//        address.setAddressDescription("ao lado da padaria");
//        address.setCity("sao paulo");
//        address.setCountry("brasil");
//        address.setIdCustomer(customer);
//        address.setPhoneNumber("999+6999");
//        address.setState("SP");
//        address.setZip("22501-581");
//        
//        addressFacade.create(address);
//        
//    }    
//    
//    public AddressController() {
//        
////        FacesContext facesContext = FacesContext.getCurrentInstance();
//        
//    }
//    
//        public static void main(String[] args){
//        
//        //new TesteAddressPersist().teste();
//        new AddressController().create();
//        
//    }
//}
