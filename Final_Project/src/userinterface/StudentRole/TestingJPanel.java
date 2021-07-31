/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StudentRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.TestingOrganization;
import Business.University.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestingWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PeiLingChiang
 */
public class TestingJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Student student;
    
    /**
     * Creates new form TestingJPanel
     */
    public TestingJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Student student) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.student = student;
        
        if (student.getTestingStatus()!=""){
            btnRequest.setEnabled(false);
        }
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblRequest.getModel();
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if (request instanceof TestingWorkRequest){
                Object[] row = new Object[4];
                row[0] = request.getRequestDate();
                row[1] = request.getSender();
                row[2] = request.getStatus();
                String result = ((TestingWorkRequest) request).getTestResult();
                row[3] = result == null ? "waiting" : result;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnRequest = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Sender", "Status", "Result"
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 527, 77));

        btnRequest.setText("Request Test");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });
        add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 299, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        TestingWorkRequest request = new TestingWorkRequest();
        request.setSender(account);
        request.setStatus("sent");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof TestingOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
        
        populateTable();
    }//GEN-LAST:event_btnRequestActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnRequest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
