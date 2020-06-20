/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.vistas;

import fastfoodcompany.clientes.acciones.AccionesEditaCliente;
import fastfoodcompany.principal.FastFoodCompanyFrame;

/**
 *
 * @author fabio
 */
public class PanelEditaCliente extends javax.swing.JPanel {
    FastFoodCompanyFrame frame;
    /**
     * Creates new form PanelEditaCliente
     */
    public PanelEditaCliente(FastFoodCompanyFrame frame) {
        initComponents();
        this.frame = frame;
        estadoLblNoValido(false);
    }
    
    /**
     * Al editar un cliente, las variables se resetean por si se desea
     * editar a mas de uno
     */
    public void borraVariables(){
        txtNumeroCliente.setText("");
        txtNombre.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        estadoLblNoValido(false);
    }
    
    public void estadoLblNoValido(boolean state){
        lblNoValido.setVisible(state);
    }
    
    //Getters
    public javax.swing.JTextField getTxtNumeroCliente(){
        return txtNumeroCliente;
    }
    public javax.swing.JTextField getTxtNombre(){
        return txtNombre;
    }
    public javax.swing.JTextField getTxtApellido1(){
        return txtApellido1;
    }
    public javax.swing.JTextField getTxtApellido2(){
        return txtApellido2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblTexoInfo = new javax.swing.JLabel();
        txtNumeroCliente = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblNumeroCliente = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNoValido = new javax.swing.JLabel();

        setLayout(null);
        add(txtApellido1);
        txtApellido1.setBounds(120, 140, 60, 18);
        add(txtApellido2);
        txtApellido2.setBounds(120, 170, 60, 18);
        add(txtNombre);
        txtNombre.setBounds(120, 110, 60, 18);

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });
        add(btnGuardar);
        btnGuardar.setBounds(230, 230, 81, 24);

        lblTexoInfo.setText("Parámetros que deseas cambiar");
        lblTexoInfo.setToolTipText("No necesitas introducir todos los campos, solo los que desees");
        add(lblTexoInfo);
        lblTexoInfo.setBounds(30, 70, 290, 14);

        txtNumeroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroClienteActionPerformed(evt);
            }
        });
        add(txtNumeroCliente);
        txtNumeroCliente.setBounds(240, 30, 60, 18);

        lblApellido1.setText("Apellido 1:");
        add(lblApellido1);
        lblApellido1.setBounds(30, 140, 80, 14);

        lblApellido2.setText("Apellido 2:");
        add(lblApellido2);
        lblApellido2.setBounds(30, 170, 80, 14);

        lblNumeroCliente.setText("Número del cliente a editar:");
        add(lblNumeroCliente);
        lblNumeroCliente.setBounds(30, 30, 210, 14);

        lblNombre.setText("Nombre:");
        add(lblNombre);
        lblNombre.setBounds(30, 110, 90, 14);

        lblNoValido.setForeground(new java.awt.Color(255, 0, 0));
        lblNoValido.setText("El número de cliente introducido no es válido");
        lblNoValido.setToolTipText("Comprueba el número de cliente en la lista");
        add(lblNoValido);
        lblNoValido.setBounds(30, 270, 290, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroClienteActionPerformed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        // TODO add your handling code here:
        AccionesEditaCliente accionesEditaCliente = new AccionesEditaCliente(this);
        accionesEditaCliente.EditaCliente();
    }//GEN-LAST:event_btnGuardarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblNoValido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroCliente;
    private javax.swing.JLabel lblTexoInfo;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCliente;
    // End of variables declaration//GEN-END:variables
}
