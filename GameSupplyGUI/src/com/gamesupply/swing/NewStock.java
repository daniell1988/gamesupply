/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.swing;

import com.gamesupply.controller.ProductController;
import com.gamesupply.controller.StockController;
import com.gamesupply.dto.ProductDTO;
import com.gamesupply.dto.StockDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CUESTAS
 */
public class NewStock extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewStock
     */
    private List<ProductDTO> productList = new ArrayList<ProductDTO>();
    private ProductDTO productDTO = new ProductDTO();
    private StockDTO stockDTO = new StockDTO();
    private String store;
    
    public NewStock(String store) {
        
        productList = ProductController.findall();
        this.store = store;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fieldNewQty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${productList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduct}"));
        columnBinding.setColumnName("Id Product");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${platform}"));
        columnBinding.setColumnName("Platform");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${type}"));
        columnBinding.setColumnName("Type");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${productDTO}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Quantidade");

        fieldNewQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNewQtyActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldNewQty, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNewQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNewQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNewQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNewQtyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.stockDTO.setIdProduct(this.productDTO.getIdProduct());
        this.stockDTO.setDescription(this.productDTO.getDescription());
        this.stockDTO.setGenre(this.productDTO.getGenre());
        this.stockDTO.setName(this.productDTO.getName());
        this.stockDTO.setPlatform(this.productDTO.getPlatform());
        this.stockDTO.setPrice(this.productDTO.getPrice());
        this.stockDTO.setType(this.productDTO.getType());
        this.stockDTO.setBranch1(0);
        this.stockDTO.setBranch2(0);
        this.stockDTO.setBranch3(0);
        
        if(this.store.toUpperCase().endsWith("A")){
            this.stockDTO.setBranch1(Integer.parseInt(fieldNewQty.getText()));
        }
        if(this.store.toUpperCase().endsWith("B")){
             this.stockDTO.setBranch2(Integer.parseInt(fieldNewQty.getText()));
        }
        if(this.store.toUpperCase().endsWith("C")){
             this.stockDTO.setBranch3(Integer.parseInt(fieldNewQty.getText()));
        }
        
        StockController.updateStock(this.stockDTO);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldNewQty;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public StockDTO getStockDTO() {
        return stockDTO;
    }

    public void setStockDTO(StockDTO stockDTO) {
        this.stockDTO = stockDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    

}
