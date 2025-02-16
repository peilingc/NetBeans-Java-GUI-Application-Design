/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmaceuticalManufacturer.CompanyAdminRole;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.HospitalAdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BP_PaymentSetltlementRequest;
import Business.WorkQueue.BP_SendOrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JiaqiWang
 */
public class ManageRequestJPanel extends javax.swing.JPanel {

    private JPanel upc;
    private UserAccount account;
    private Organization organization;
//    private Enterprise enterprise;
    private EcoSystem system;

    /**
     * Creates new form ManageRequestJPanel
     */
    ManageRequestJPanel(JPanel upc, UserAccount account, Organization organization, EcoSystem system) {
        initComponents();
        this.upc = upc;
        this.account = account;
        this.organization = organization;
//        this.enterprise = enterprise;
        this.system = system;

        refreshRequestTable();
        populatePaymentJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        transactionJTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel4.setText("Recent Received Orders");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 244, 26));

        jButton2.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jButton2.setText("Accept the order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 230, 155, -1));

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Sender", "Receiver", "Status"
            }
        ));
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 134, 640, 90));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel6.setText("Tractions History");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 134, -1));

        transactionJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Status"
            }
        ));
        jScrollPane5.setViewportView(transactionJTable);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 640, 82));

        jButton3.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jButton3.setText("Request payment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 155, -1));

        backJButton.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 485, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //settle the order request between hosadmin and supplier
        int selectedRow = requestTable.getSelectedRow();
        WorkRequest wr = (WorkRequest) requestTable.getValueAt(selectedRow, 1);
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "your Selection is null,Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (wr.getStatus().equals("Order accepted")) {
            JOptionPane.showMessageDialog(null, "The Order has already been accepted!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            wr.setReceiver(account);
            wr.setStatus("Order accepted");
        }
        refreshRequestTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        WorkRequest wr = (WorkRequest) requestTable.getValueAt(selectedRow, 1);
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "your Selection is null,Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (wr.getStatus().equals("Order accepted")) {
            wr.setStatus("accepted,waiting for payment");
        } else {
            JOptionPane.showMessageDialog(null, "you haven't accept the order yet", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //send payment request between hospital admin and supplier
        BP_PaymentSetltlementRequest request = new BP_PaymentSetltlementRequest();
        request.setSender(account);
        request.setStatus("payment pending");
        Organization org = null;
        for (Network network : system.getNetworkList()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof HospitalEnterprise) {
                    for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        if (o instanceof HospitalAdminOrganization) {
                            org = o;
                            break;
                        }
                    }
                    if (org != null) {
                        org.getWorkQueue().getWorkRequestList().add(request);
                        account.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
            }
        }

        populatePaymentJTable();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable requestTable;
    private javax.swing.JTable transactionJTable;
    // End of variables declaration//GEN-END:variables

    private void refreshRequestTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof BP_SendOrderWorkRequest) {
                Object[] row = new Object[4];
                row[0] = request.getRequestDate();
                row[2] = request.getReceiver() == null ? null : request.getReceiver();
                row[1] = request;
                row[3] = request.getStatus();
                model.addRow(row);
            }
        }
        requestTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        requestTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void populatePaymentJTable() {
        DefaultTableModel model = (DefaultTableModel) transactionJTable.getModel();
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
            if (request instanceof BP_PaymentSetltlementRequest) {
                Object[] row = new Object[2];
                row[0] = request.getRequestDate();
                row[1] = request.getStatus();
                model.addRow(row);
            }
        }
    }
}
