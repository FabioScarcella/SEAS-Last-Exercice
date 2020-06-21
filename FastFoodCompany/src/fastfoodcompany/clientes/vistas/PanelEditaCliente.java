/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.vistas;

import fastfoodcompany.clientes.acciones.AccionesEditaCliente;
import fastfoodcompany.principal.FastFoodCompanyFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabio
 */
public class PanelEditaCliente extends javax.swing.JPanel {
    FastFoodCompanyFrame frame;
    DefaultTableModel tabla;
    AccionesEditaCliente accionesEditaCliente;
    /**
     * Creates new form PanelEditaCliente
     */
    public PanelEditaCliente(FastFoodCompanyFrame frame) {
        initComponents();
        this.frame = frame;
        estadoLblNoValido(false, "");
        
        cargaTabla();
        estadoTabla(false);
        
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
        estadoLblNoValido(false, "");
        estadoTabla(false);
        frame.pack();
    }
    
    public void estadoLblNoValido(boolean state, String mensaje){
        lblNoValido.setText(mensaje);
        lblNoValido.setVisible(state);
    }
    
    public void estadoTabla(boolean state){
        pnlTblNumCliente.setVisible(state);
    }
    
    public void cargaTabla(){
        tabla = new DefaultTableModel(new String[]{
            "Numero Cliente", "Nombre", "Primer apellido", "Segundo apellido"
        }, 0);
        
        tblNumCliente.setModel(tabla);    
        
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
    
    public javax.swing.JScrollPane getPnlTabla(){
        return pnlTblNumCliente;
    }
    
    public DefaultTableModel getTblModel(){
        return tabla;
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
        btnVerCliente = new javax.swing.JButton();
        pnlTblNumCliente = new javax.swing.JScrollPane();
        tblNumCliente = new javax.swing.JTable();

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(120, 24));
        btnGuardar.setPreferredSize(new java.awt.Dimension(90, 24));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });

        lblTexoInfo.setText("Parámetros que deseas cambiar");
        lblTexoInfo.setToolTipText("No necesitas introducir todos los campos, solo los que desees");

        txtNumeroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroClienteActionPerformed(evt);
            }
        });

        lblApellido1.setText("Apellido 1:");

        lblApellido2.setText("Apellido 2:");

        lblNumeroCliente.setText("Número del cliente a editar:");

        lblNombre.setText("Nombre:");

        lblNoValido.setForeground(new java.awt.Color(255, 0, 0));
        lblNoValido.setText("El número de cliente introducido no es válido");
        lblNoValido.setToolTipText("Comprueba el número de cliente en la lista");

        btnVerCliente.setText("Ver");
        btnVerCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerClienteMousePressed(evt);
            }
        });
        btnVerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClienteActionPerformed(evt);
            }
        });

        tblNumCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        pnlTblNumCliente.setViewportView(tblNumCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTblNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnVerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblTexoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(lblNoValido, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroCliente)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(pnlTblNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblTexoInfo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido1)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido2)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblNoValido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroClienteActionPerformed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        // TODO add your handling code here:
        if(accionesEditaCliente == null){
            accionesEditaCliente = new AccionesEditaCliente(this);
        }
        accionesEditaCliente.EditaCliente();
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnVerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerClienteActionPerformed

    private void btnVerClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerClienteMousePressed
        // TODO add your handling code here: 
        if(accionesEditaCliente == null){
            accionesEditaCliente = new AccionesEditaCliente(this);
        }
        accionesEditaCliente.verClienteAEditar(frame);
    }//GEN-LAST:event_btnVerClienteMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVerCliente;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblNoValido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroCliente;
    private javax.swing.JLabel lblTexoInfo;
    private javax.swing.JScrollPane pnlTblNumCliente;
    private javax.swing.JTable tblNumCliente;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCliente;
    // End of variables declaration//GEN-END:variables
}
