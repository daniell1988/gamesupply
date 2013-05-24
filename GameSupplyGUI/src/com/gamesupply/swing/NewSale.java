/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.swing;

import com.gamesupply.controller.StockController;
import com.gamesupply.dto.StockDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 40836665
 */
public class NewSale extends javax.swing.JInternalFrame {
    
    private List<StockDTO> stockList = new ArrayList<StockDTO>();
    private StockDTO selectedStockDTO = new StockDTO();
    private String store;

    /**
     * Creates new form NewSale
     */
    public NewSale(String store) {
        
        this.store = store;
        getBranchStock(store);
        initComponents();
        
    }
    
        private void getBranchStock(String store) {
        
            List<StockDTO> tmpStock = StockController.findall();
        
            for(StockDTO stockTmp : tmpStock){
                StockDTO stockDTO = new StockDTO();


                stockDTO.setBranch1(stockTmp.getBranch1());
                stockDTO.setBranch2(stockTmp.getBranch2());
                stockDTO.setBranch3(stockTmp.getBranch3());
                stockDTO.setDescription(stockTmp.getDescription());
                stockDTO.setGenre(stockTmp.getGenre());
                stockDTO.setIdProduct(stockTmp.getIdProduct());
                stockDTO.setName(stockTmp.getName());
                stockDTO.setPlatform(stockTmp.getPlatform());
                stockDTO.setPrice(stockTmp.getPrice());
                stockDTO.setType(stockTmp.getType());

                if(store.endsWith("A")){
                    stockDTO.setBranchQuantity(stockTmp.getBranch1());
                }

                if(store.endsWith("B")){
                    stockDTO.setBranchQuantity(stockTmp.getBranch2());
                }

                if(store.endsWith("C")){
                    stockDTO.setBranchQuantity(stockTmp.getBranch3());
                }

                this.stockList.add(stockDTO);
            }
        
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
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${stockList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${platform}"));
        columnBinding.setColumnName("Platform");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${type}"));
        columnBinding.setColumnName("Type");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${branchQuantity}"));
        columnBinding.setColumnName("Branch Quantity");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedStock}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

//        this.selectedStockDTO.setIdProduct(Integer.parseInt(selecttedProductId.getText()));
        
        if(this.store.toUpperCase().endsWith("A")){
            this.selectedStockDTO.setBranch1(this.selectedStockDTO.getBranch1() - Integer.parseInt(jTextField1.getText()));
        }
        if(this.store.toUpperCase().endsWith("B")){
            this.selectedStockDTO.setBranch2(this.selectedStockDTO.getBranch2() - Integer.parseInt(jTextField1.getText()));
        }
        if(this.store.toUpperCase().endsWith("C")){
            this.selectedStockDTO.setBranch3(this.selectedStockDTO.getBranch3() - Integer.parseInt(jTextField1.getText()));
        }
        
        StockController.updateStock(this.selectedStockDTO);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public List<StockDTO> getStockList() {
        return stockList;
    }

    public void setStockList(List<StockDTO> stockList) {
        this.stockList = stockList;
    }

    public StockDTO getSelectedStock() {
        return selectedStockDTO;
    }

    public void setSelectedStock(StockDTO selectedStock) {
        this.selectedStockDTO = selectedStock;
    }

    

}
