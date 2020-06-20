/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import static fastfoodcompany.clientes.acciones.AccionesListaClientes.DRIVER_JDBC;
import fastfoodcompany.clientes.vistas.PanelEditaCliente;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author fabio
 */
public class AccionesEditaCliente extends AccionesConexionBDD{
    
    PanelEditaCliente panel;
    AccionesListaClientes accionesDB;
    
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
            System.out.println("No usuario");
            return;
        }

        nombre = comprobarVariables(numeroCliente, nombre, "nombre");
        apellido1 = comprobarVariables(numeroCliente, apellido1, "apellido1");
        apellido2 = comprobarVariables(numeroCliente, apellido2, "apellido2");

        actualizaCliente(numeroCliente, nombre, apellido1, apellido2);
            
        desconectaBDD();
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
    
    
}
