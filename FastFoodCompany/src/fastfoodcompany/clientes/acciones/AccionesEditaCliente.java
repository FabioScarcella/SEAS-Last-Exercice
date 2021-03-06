/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import static fastfoodcompany.clientes.acciones.AccionesListaClientes.DRIVER_JDBC;
import fastfoodcompany.clientes.vistas.PanelEditaCliente;
import fastfoodcompany.principal.FastFoodCompanyFrame;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para editar a un cliente
 * @author fabio
 */
public class AccionesEditaCliente extends AccionesConexionBDD{
    
    PanelEditaCliente panel;
    AccionesListaClientes accionesDB;
    DefaultTableModel tabla;
    
    public AccionesEditaCliente(PanelEditaCliente panel){
        this.panel = panel;
        accionesDB = new AccionesListaClientes();
    }
    /**
     * Coge los valores introduciodos por el usuario y llama a la funcion 
     * editaCliente()
     */
    public void EditaCliente(){
        String numeroCliente = panel.getTxtNumeroCliente().getText();
        String nombre = panel.getTxtNombre().getText();
        String apellido1 = panel.getTxtApellido1().getText();
        String apellido2 = panel.getTxtApellido2().getText();
        
        /*
        Si alguno de los parametros esta vacio, su valor serà: ""
        */
        editaCliente(numeroCliente, nombre, apellido1, apellido2);
    }
    
    /**
     * Funcion que lleva la lógica principal para editar un cliente de la BDD
     * @param numeroCliente es el ID que la BDD asigna a un cliente al registrarlo
     * @param nombre 
     * @param apellido1
     * @param apellido2 
     */
    private void editaCliente(String numeroCliente, String nombre, String apellido1,
            String apellido2){
        
        conectaBDD();

        if(!compruebaNumeroCliente(numeroCliente)){
            panel.estadoLblNoValido(true, "Numero de cliente no válido");
            return;
        }else if(nombre.isEmpty() &&
                apellido1.isEmpty() && apellido2.isEmpty()){
             panel.estadoLblNoValido(true, "Pon algún parámetro a modificar");
            return;
        }else{ //En caso de que hubiese un mal parametro, y se haya corregido
             panel.estadoLblNoValido(false, "");
        }

        nombre = comprobarVariables(numeroCliente, nombre, "nombre");
        apellido1 = comprobarVariables(numeroCliente, apellido1, "apellido1");
        apellido2 = comprobarVariables(numeroCliente, apellido2, "apellido2");

        actualizaCliente(numeroCliente, nombre, apellido1, apellido2);
            
        desconectaBDD();
        
        panel.borraVariables();
    }
    
    /**
     * Creamos un preparedStatement para hacer un update del usuario deseado 
     * @param numeroCliente
     * @param nombre
     * @param apellido1
     * @param apellido2 
     */
    private void actualizaCliente(String numeroCliente, String nombre,
            String apellido1, String apellido2){
        try{
            PreparedStatement stat = conn.prepareStatement(
            "UPDATE clientesDB SET nombre = ?, apellido1 = ?, apellido2 = ? "
                    + "WHERE NumeroCliente = ?");
            stat.setString(1, nombre);
            stat.setString(2, apellido1);
            stat.setString(3, apellido2);
            stat.setString(4, numeroCliente);
            
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
    public void verClienteAEditar(FastFoodCompanyFrame frame){
        panel.cargaTabla();
        /**
         * Esperamos un tiempo ya que es mas lento cargar/refrescar la tabla
         * que acceder a los valores del cliente en la BDD
         */
        esperaTiempo(150);
        
        conectaBDD();

        String numCliente = panel.getTxtNumeroCliente().getText();
        
        if(!compruebaNumeroCliente(numCliente)){
            panel.estadoLblNoValido(true, "Numero de cliente no válido");
            panel.estadoTabla(false);
            return;
        }
        //En caso de que hubiese un mal parametro, y se haya corregido
        panel.estadoLblNoValido(false, "");
        
        DefaultTableModel tabla = panel.getTblModel();
        
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
     * 
     * @param numeroCliente
     * @return los valores del cliente en forma de ArrayList
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
