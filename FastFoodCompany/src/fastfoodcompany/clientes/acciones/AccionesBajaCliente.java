/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import static fastfoodcompany.clientes.acciones.AccionesListaClientes.DRIVER_JDBC;
import fastfoodcompany.clientes.vistas.PanelBajaCliente;
import fastfoodcompany.principal.FastFoodCompanyFrame;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que contiene los metodos para elminar a un cliente
 * @author fabio
 */
public class AccionesBajaCliente extends AccionesConexionBDD{
    PanelBajaCliente panel;
    AccionesListaClientes accionesDB;
    
    public AccionesBajaCliente(PanelBajaCliente panel){
        this.panel = panel;
        accionesDB = new AccionesListaClientes();
    }
    
    /**
     * Accede al parametro introducido por el usuario y hace la llamada a la 
     * funcion para eliminar el cliente
     */
    public void bajaCliente(){
        String numeroCliente = panel.getTxtNumeroCliente().getText();
        
        bajaCliente(numeroCliente);
    }
    
    /**
     * Comprueba que existe el numeroCliente introducido y lo elimina si existe
     * @param numeroCliente 
     */
    private void bajaCliente(String numeroCliente){
        conectaBDD();

        if(!compruebaNumeroCliente(numeroCliente)){
            panel.estadoLblNoValor(true);
            return;
        }

        eliminaCliente(numeroCliente);
            
        desconectaBDD();
        
        panel.borraVariables();
    }
    
    /**
     * Query para eliminar al cliente deseado
     * @param numeroCliente 
     */
    private void eliminaCliente(String numeroCliente){
        try{
            PreparedStatement stat = conn.prepareStatement(
            "DELETE FROM clientesDB where NumeroCliente = ?");
            
            stat.setString(1, numeroCliente);
            
            stat.executeUpdate();
            
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    /**
     * Funcion que nos permite ver los campos de un cliente añadiendo su 
     * numeroCliente
     * @param frame 
     */
    public void verCliente(FastFoodCompanyFrame frame){
        panel.cargaTabla();
        /**
         * Esperamos un tiempo ya que es mas lento cargar/refrescar la tabla
         * que acceder a los valores del cliente en la BDD
         */
        esperaTiempo(150);
        
                conectaBDD();

        String numCliente = panel.getTxtNumeroCliente().getText();
        
        if(!compruebaNumeroCliente(numCliente)){
            panel.estadoLblNoValor(true);
            panel.estadoTabla(false);
            return;
        }
        //En caso de que hubiese un mal parametro, y se haya corregido
        panel.estadoLblNoValor(false);
        
        DefaultTableModel tabla = panel.getTabla();
        
        ArrayList cliente = devolverCliente(numCliente);
        
        Vector dataCliente = new Vector();
        dataCliente.add(cliente.get(1));
        dataCliente.add(cliente.get(2));
        dataCliente.add(cliente.get(3));
        
        tabla.addRow(dataCliente);
        
        panel.estadoTabla(true);
        frame.pack();
        
        desconectaBDD();
        
    }
    
    /**
     * @param numeroCliente
     * @return los valores del cliente, como su nombre y apellidos
     */
     private ArrayList devolverCliente(String numeroCliente){
        ArrayList cliente = new ArrayList();
                
        try{
            PreparedStatement stat = conn.prepareStatement(
            "SELECT * from clientesDB WHERE NumeroCliente = ?");
            stat.setString(1, numeroCliente);
            
            ResultSet rs = stat.executeQuery();
            
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
            }
            
        }catch(SQLException se){
            se.printStackTrace();
        }
        
        return cliente;
    }
    
     /**
      * funcion para esperar un determinado tiempo
      * @param tiempo en milisegundos
      */
    private void esperaTiempo(int tiempo){
        try{
            Thread.sleep(tiempo);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }    
}
