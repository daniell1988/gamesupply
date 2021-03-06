/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesupply.swing;

import com.gamesupply.swing.report.BranchDailyReport;
import com.gamesupply.swing.report.BranchesStockReport;

/**
 *
 * @author 40836665
 */
public class MainMenu extends javax.swing.JFrame {
    private ListaProduto listaProduto;
    private NewStock stockEntry;
    private MaintainStock stockManagement;
    private BranchesStockReport branchStockReport;
    private String store;
    private NewSale newSale;
    private BranchDailyReport branchDailyReport;
    private OrderList orderList;

    /**
     * Creates new form MainMenu
     */
    public MainMenu(String store) {
        initComponents();
        this.store = store;
        getMenus(store);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        mainMenuBar = new javax.swing.JMenuBar();
        menuSale = new javax.swing.JMenu();
        itemNewSale = new javax.swing.JMenuItem();
        menuStock = new javax.swing.JMenu();
        itemStockManagement = new javax.swing.JMenuItem();
        menuOrder = new javax.swing.JMenu();
        itemOrderSearch = new javax.swing.JMenuItem();
        menuProduct = new javax.swing.JMenu();
        itemNewProduct = new javax.swing.JMenuItem();
        menuItemProductManagement = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        itemMenuReportBranchStock = new javax.swing.JMenuItem();
        itemMenuDailyReport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameSupply");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menuSale.setText("Vendas");

        itemNewSale.setText("Nova");
        itemNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNewSaleActionPerformed(evt);
            }
        });
        menuSale.add(itemNewSale);

        mainMenuBar.add(menuSale);

        menuStock.setText("Estoque");

        itemStockManagement.setText("Controle");
        itemStockManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStockManagementActionPerformed(evt);
            }
        });
        menuStock.add(itemStockManagement);

        mainMenuBar.add(menuStock);

        menuOrder.setText("Pedidos");

        itemOrderSearch.setText("Consulta");
        itemOrderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrderSearchActionPerformed(evt);
            }
        });
        menuOrder.add(itemOrderSearch);

        mainMenuBar.add(menuOrder);

        menuProduct.setText("Produtos");

        itemNewProduct.setText("Cadastro");
        itemNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNewProductActionPerformed(evt);
            }
        });
        menuProduct.add(itemNewProduct);

        menuItemProductManagement.setText("Manutenção");
        menuItemProductManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProductManagementActionPerformed(evt);
            }
        });
        menuProduct.add(menuItemProductManagement);

        mainMenuBar.add(menuProduct);

        menuReport.setText("Relatório");

        itemMenuReportBranchStock.setText("Estoque Filiais");
        itemMenuReportBranchStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuReportBranchStockActionPerformed(evt);
            }
        });
        menuReport.add(itemMenuReportBranchStock);

        itemMenuDailyReport.setText("Fechamento");
        itemMenuDailyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuDailyReportActionPerformed(evt);
            }
        });
        menuReport.add(itemMenuDailyReport);

        mainMenuBar.add(menuReport);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNewSaleActionPerformed
        newSale = new NewSale(store);
        jDesktopPane1.add(newSale);
        newSale.setVisible(true);                
    }//GEN-LAST:event_itemNewSaleActionPerformed

    private void menuItemProductManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProductManagementActionPerformed
        listaProduto = new ListaProduto();
        jDesktopPane1.add(listaProduto);
        listaProduto.setVisible(true);
    }//GEN-LAST:event_menuItemProductManagementActionPerformed

    private void itemNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNewProductActionPerformed
        cadastroProduto = new CadastroProduto();
        jDesktopPane1.add(cadastroProduto);
        cadastroProduto.setVisible(true);
    }//GEN-LAST:event_itemNewProductActionPerformed

    private void itemStockManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemStockManagementActionPerformed
        stockManagement = new MaintainStock(store);
        jDesktopPane1.add(stockManagement);
        stockManagement.setVisible(true);
    }//GEN-LAST:event_itemStockManagementActionPerformed

    private void itemMenuReportBranchStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuReportBranchStockActionPerformed
        branchStockReport = new BranchesStockReport();
        jDesktopPane1.add(branchStockReport);
        branchStockReport.setVisible(true);
    }//GEN-LAST:event_itemMenuReportBranchStockActionPerformed

    private void itemMenuDailyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuDailyReportActionPerformed
        branchDailyReport = new BranchDailyReport(store);
        jDesktopPane1.add(branchDailyReport);
        branchDailyReport.setVisible(true);
    }//GEN-LAST:event_itemMenuDailyReportActionPerformed

    private void itemOrderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrderSearchActionPerformed
        orderList = new OrderList(store);
        jDesktopPane1.add(orderList);
        orderList.setVisible(true);
    }//GEN-LAST:event_itemOrderSearchActionPerformed

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainMenu("").setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuDailyReport;
    private javax.swing.JMenuItem itemMenuReportBranchStock;
    private javax.swing.JMenuItem itemNewProduct;
    private javax.swing.JMenuItem itemNewSale;
    private javax.swing.JMenuItem itemOrderSearch;
    private javax.swing.JMenuItem itemStockManagement;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem menuItemProductManagement;
    private javax.swing.JMenu menuOrder;
    private javax.swing.JMenu menuProduct;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuSale;
    private javax.swing.JMenu menuStock;
    // End of variables declaration//GEN-END:variables
    CadastroProduto cadastroProduto;

    private void getMenus(String store) {
        
        if(store.equals("MATRIZ")){
            menuSale.setVisible(false);
            itemMenuDailyReport.setVisible(false);
            menuStock.setVisible(false);
            menuOrder.setVisible(false);
        }
        else{
            menuProduct.setVisible(false);
            itemMenuReportBranchStock.setVisible(false);
        }
        
    }
}
