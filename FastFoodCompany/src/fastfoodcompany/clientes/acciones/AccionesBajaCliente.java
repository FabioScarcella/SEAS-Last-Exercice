/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import static fastfoodcompany.clientes.acciones.AccionesListaClientes.DRIVER_JDBC;
import fastfoodcompany.clientes.vistas.PanelBajaCliente;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
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
            System.out.println("No usuario");
            return;
        }

        eliminaCliente(numeroCliente);
            
        desconectaBDD();
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
}
