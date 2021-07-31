/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Hospital.DoctorRole;

import Busines.EcoSystem;
import Business.Hospital.Doctor;
import Business.Hospital.Patient;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.RegisterWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PeiLingChiang
 */
public class AcceptPatientJPanel extends javax.swing.JPanel {
    
    private JPanel upc;
    private UserAccount account;
    private Organization organization;
    private EcoSystem system;
    private Doctor doctor;
    
    /**
     * Creates new form AcceptPatientJPanel
     */
    public AcceptPatientJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem system, Doctor doctor) {
        initComponents();
        this.upc=userProcessContainer;
        this.account=account;
        this.organization=organization;
        this.system=system;
        this.doctor = doctor;
        populateRequestTable();
    }
    
    private void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel)tblRequest.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()){
            if (wr instanceof RegisterWorkRequest && ((RegisterWorkRequest)wr).getDoctor()==doctor){
                Object[] row = new Object[4];
                row[0] = wr;
                row[1] = wr.getSender().getPerson();
                row[2] = wr.getMessage();
                row[3] = wr.getStatus();
                model.addRow(row);
            }
        }
        tblRequest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblRequest.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setText("Register Request");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 280, -1));

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request Date", "Patient's Name", "Symptom(s)", "Status"
            }
        ));
        jScrollPane2.setViewportView(tblRequest);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 592, 200));

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 344, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        int row = tblRequest.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        RegisterWorkRequest wr = (RegisterWorkRequest) tblRequest.getValueAt(row, 0);
        wr.setReceiver(account);
        wr.setStatus("registered");
        wr.setResolveDate(new Date());

        Patient p = wr.getPatient();
        p.getStudent().setRegisteringStatus("registered");
        p.getStudent().setContactStatus("hospital");
        populateRequestTable();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
