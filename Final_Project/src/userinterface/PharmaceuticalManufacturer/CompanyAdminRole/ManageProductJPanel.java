/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmaceuticalManufacturer.CompanyAdminRole;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.HospitalAdminOrganization;
import Business.Organization.Organization;
import Business.Pharmaceutical_Manufacturer.Product;
import Business.Pharmaceutical_Manufacturer.Supplier;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BP_PaymentSetltlementRequest;
import Business.WorkQueue.BP_SendOrderWorkRequest;
import Business.WorkQueue.CheckWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jiaqi Wang
 */
public class ManageProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProductJPanel
     */
private JPanel upc;
private Supplier supplier;
private Product p;
     
    public ManageProductJPanel(JPanel userProcessContainer,Supplier supplier) {
      initComponents();
        this.upc=userProcessContainer;
        this.supplier=supplier;
       populateTable();
    
       txtAvial.setEnabled(false);
       txtId.setEnabled(false);
       txtName.setEnabled(false);
       txtPrice.setEnabled(false);
       txtUsage.setEnabled(false);
       
       btnSubmit.setEnabled(false);
       btnUpdate.setEnabled(false); 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtProdID = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblUsage = new javax.swing.JLabel();
        txtUsage = new javax.swing.JTextField();
        lblAvail = new javax.swing.JLabel();
        txtAvial = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Welcome, Pharmaceutical Manager !");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 6, -1, -1));

        tblProd.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Product ID", "Price", "Usage"
            }
        ));
        jScrollPane1.setViewportView(tblProd);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 179, 390, 93));

        btnView.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnView.setText("View Product Detail >>");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 319, -1, -1));

        btnCreate.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnCreate.setText("Create New Product >>");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 278, -1, -1));

        btnSearch.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnSearch.setText("Search By ID>>");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 138, 171, -1));

        btnDelete.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnDelete.setText("Delete Product(s)");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 278, -1, -1));

        jLabel1.setFont(new java.awt.Font("微软雅黑 Light", 1, 14)); // NOI18N
        jLabel1.setText("Manage Your Product Catalog Here!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 41, 264, 45));

        txtProdID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdIDActionPerformed(evt);
            }
        });
        add(txtProdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 139, 122, -1));

        backJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 424, -1, -1));

        lblName.setText("Product Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 138, -1, 30));

        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 138, 159, -1));

        lblPrice.setText("Product Price:");
        add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 218, -1, 30));

        txtPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 218, 159, -1));

        btnUpdate.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 51, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 351, -1, -1));

        txtId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 180, 159, -1));

        lblID.setText("Product ID:");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 178, -1, 30));

        btnSubmit.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 350, -1, 30));

        lblUsage.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblUsage.setText("Specialized Usage:");
        add(lblUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 298, -1, 30));

        txtUsage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 306, 159, -1));

        lblAvail.setText("Availability:");
        add(lblAvail, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 258, -1, 30));

        txtAvial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtAvial, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 159, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

      int row = tblProd.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
         p=(Product)tblProd.getValueAt(row, 0);
        
        txtName.setText(p.getProdName());
        txtAvial.setText(String.valueOf(p.getAvail()));
        txtId.setText(String.valueOf(p.getModelNumber()));
        txtPrice.setText(String.valueOf(p.getPrice()));
        txtUsage.setText(p.getProdUsage());
        
         txtAvial.setEnabled(true);
       txtId.setEnabled(true);
       txtName.setEnabled(true);
       txtPrice.setEnabled(true);
       txtUsage.setEnabled(true);  
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
    
         txtAvial.setEnabled(true);
       txtId.setEnabled(true);
       txtName.setEnabled(true);
       txtPrice.setEnabled(true);
       txtUsage.setEnabled(true);  
        btnSubmit.setEnabled(true);
        
       txtAvial.setText("");
       txtId.setText("");
       txtName.setText("");
       txtPrice.setText("");
       txtUsage.setText("");
      
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
int prodID = Integer.parseInt(txtProdID.getText());
        refreshTable(prodID);
      
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int row = tblProd.getSelectedRow();

        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Product s = (Product)tblProd.getValueAt(row, 0);
       supplier.getProductCatalog().removeProduct(s);
        populateTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtProdIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdIDActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       String name = txtName.getText();
        int ID=Integer.parseInt(txtId.getText());
        int price=Integer.parseInt(txtPrice.getText());
        int avil=Integer.parseInt(txtAvial.getText());
        String usage=txtUsage.getText();
        
        if (txtName.getText().length()==0 || txtId.getText().length()==0 || 
            txtPrice.getText().length()==0 || txtAvial.getText().length()==0|| txtUsage.getText().length()==0  )
        {
            JOptionPane.showMessageDialog(null, "Please ensure all fields are entered!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
      p.setAvail(avil);
      p.setModelNumber(ID);
      p.setPrice(price);
      p.setProdName(name);
      p.setProdUsage(usage);
        
        JOptionPane.showMessageDialog(null, "Successfully updated!");
       populateTable();
        txtName.setEnabled(false);
        txtAvial.setEnabled(false);
        txtId.setEnabled(false);
        txtPrice.setEnabled(false);
        txtUsage.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String name = txtName.getText();
        int ID=Integer.parseInt(txtId.getText());
        int price=Integer.parseInt(txtPrice.getText());
        int avil=Integer.parseInt(txtAvial.getText());
        String usage=txtUsage.getText();
        
        if (txtName.getText().length()==0 || txtId.getText().length()==0 || txtPrice.getText().length()==0 ||
            txtAvial.getText().length()==0 )
        {
            JOptionPane.showMessageDialog(null, "Please ensure all fields are entered!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        Product p=new Product();
        p.setAvail(avil);
        p.setModelNumber(ID);
        p.setPrice(price);
        p.setProdUsage(usage);
        p.setProdName(name);
        supplier.getProductCatalog().getProductcatalog().add(p);
    
        JOptionPane.showMessageDialog(null, " product Successfully created!");
       populateTable();
        txtName.setEnabled(false);
        txtAvial.setEnabled(false);
        txtId.setEnabled(false);
        txtPrice.setEnabled(false);
        txtUsage.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAvail;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblUsage;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField txtAvial;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProdID;
    private javax.swing.JTextField txtUsage;
    // End of variables declaration//GEN-END:variables

      public void populateTable() {
        int rowCount = tblProd.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblProd.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        
        for(Product p :supplier.getProductCatalog().getProductcatalog()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getPrice();
            row[3]=p.getProdUsage();
            model.addRow(row);
        }
      }

    private void refreshTable(int prodID) {
     DefaultTableModel model = (DefaultTableModel)tblProd.getModel();
        model.setRowCount(0);
        for (Product p:supplier.getProductCatalog().getProductcatalog()){
            if (p.getModelNumber()==prodID){
                Object[] row = new Object[4];
                row[0] = p;
                row[1] =p.getModelNumber();
                row[2] = p.getPrice();
                row[3]=p.getProdUsage();
                model.addRow(row);
            }
        }
    }

 
}
