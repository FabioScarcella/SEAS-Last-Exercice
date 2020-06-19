/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.principal;

import fastfoodcompany.clientes.vistas.PanelAltaClientes;
import fastfoodcompany.clientes.vistas.PanelEditaCliente;
import fastfoodcompany.clientes.vistas.PanelListaClientes;
import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class FastFoodCompanyFrame extends javax.swing.JFrame {

    public ArrayList clientesGuardados = new ArrayList();
    
    /**
     * Creates new form FastFoodCompanyFrame
     */
    public FastFoodCompanyFrame() {
        initComponents();
    }
    /**
     * Funcion que limpa el JPanel en caso de que haya algo previamente abierto
     */
    private void limpiarPanel(){
        panelContenedor.removeAll();
    }
    
    public ArrayList getClientesGuardados(){
        return clientesGuardados;
    }
    public void setClientesGuardados(ArrayList clientesGuardados){
        this.clientesGuardados = clientesGuardados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCliente = new javax.swing.JMenu();
        mnuAltaCliente = new javax.swing.JMenuItem();
        mnuEditaCliente = new javax.swing.JMenuItem();
        mnuBajaCliente = new javax.swing.JMenuItem();
        mnuEmpleados = new javax.swing.JMenu();
        mnuListaClientes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContenedor.setPreferredSize(new java.awt.Dimension(600, 600));
        panelContenedor.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        mnuCliente.setText("Clientes");

        mnuAltaCliente.setText("Alta Cliente");
        mnuAltaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltaClienteActionPerformed(evt);
            }
        });
        mnuCliente.add(mnuAltaCliente);

        mnuEditaCliente.setText("Edita Cliente");
        mnuEditaCliente.setActionCommand("Edita Cliente");
        mnuEditaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuEditaClienteMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuEditaClienteMouseClicked(evt);
            }
        });
        mnuEditaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditaClienteActionPerformed(evt);
            }
        });
        mnuCliente.add(mnuEditaCliente);

        mnuBajaCliente.setText("Baja Cliente");
        mnuCliente.add(mnuBajaCliente);

        jMenuBar1.add(mnuCliente);

        mnuEmpleados.setText("Empleados");
        mnuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuEmpleadosMouseClicked(evt);
            }
        });

        mnuListaClientes.setText("Lista Clientes");
        mnuListaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuListaClientesMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuListaClientesMouseClicked(evt);
            }
        });
        mnuListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaClientesActionPerformed(evt);
            }
        });
        mnuEmpleados.add(mnuListaClientes);

        jMenuBar1.add(mnuEmpleados);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAltaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltaClienteActionPerformed
        // TODO add your handling code here:
        limpiarPanel();
        PanelAltaClientes altaClientes = new PanelAltaClientes(this);
        panelContenedor.add(altaClientes, java.awt.BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_mnuAltaClienteActionPerformed

    private void mnuEditaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuEditaClienteActionPerformed

    private void mnuEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEmpleadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuEmpleadosMouseClicked

    private void mnuListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuListaClientesActionPerformed

    private void mnuListaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuListaClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuListaClientesMouseClicked

    private void mnuListaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuListaClientesMousePressed
        // TODO add your handling code here:
        limpiarPanel();
        PanelListaClientes panelListaClientes = new PanelListaClientes(this);
        panelContenedor.add(panelListaClientes, java.awt.BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_mnuListaClientesMousePressed

    private void mnuEditaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEditaClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuEditaClienteMouseClicked

    private void mnuEditaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEditaClienteMousePressed
        // TODO add your handling code here:
        limpiarPanel();
        PanelEditaCliente panelEditaCliente = new PanelEditaCliente(this);
        panelContenedor.add(panelEditaCliente, java.awt.BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_mnuEditaClienteMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FastFoodCompanyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FastFoodCompanyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FastFoodCompanyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FastFoodCompanyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FastFoodCompanyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAltaCliente;
    private javax.swing.JMenuItem mnuBajaCliente;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenuItem mnuEditaCliente;
    private javax.swing.JMenu mnuEmpleados;
    private javax.swing.JMenuItem mnuListaClientes;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
