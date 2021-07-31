/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Busines.EcoSystem;
import Business.Hospital.Doctor;
import Business.Person.Person;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.Organization.OrganizationDirectory;
import Business.University.Student;
import java.awt.CardLayout;
import java.time.LocalDate;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PeiLingChiang
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    EcoSystem business;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer,OrganizationDirectory organizationDir, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        this.business = business;
        
        populateOrganizationComboBox();
    }
    
    public void populateOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            organizationJComboBox.addItem(organization);
        }
    }

    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Person person : organization.getPersonDirectory().getPersonList()){
            Object[] row = new Object[2];
            row[0] = person.getId();
            row[1] = person.getName();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 78, 480, 92));

        addJButton.setText("Create Person");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 45, 170, -1));

        jLabel1.setText("Organization");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 49, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 328, -1, -1));

        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 126, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        String name = nameJTextField.getText();
        if (organization.getName().equals("Student Organization")){
            Student s = organization.getPersonDirectory().createStudent_simple(name);
            
            /**Testing
            s.setTestingStatus("positive");
            s.setContactStatus("quarantine");
            s.setQuarantineStartDate(LocalDate.now().minusDays(1));
            **/
            
            //used to quickly get student list from system
            business.getStudentDir().getStudentList().add(s);
        }
        else if (organization.getName().equals("Doctor Organization")){
            Doctor d = organization.getPersonDirectory().createDoctor(name);
            
            //used to quickly get doctor list from system
            business.getDoctorDir().getDoctorList().add(d);
        }
        else {
            organization.getPersonDirectory().createPerson(name);
        }
        populateTable(organization);
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
