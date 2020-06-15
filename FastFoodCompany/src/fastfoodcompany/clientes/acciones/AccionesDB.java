/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Clase que se comunica con nuestra BDD
 * 
 * @author fabio
 */
public class AccionesDB {
    static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
    static final String DB_URL = 
            "jdbc:mysql://localhost:3306/es.seas.u3.ejercicio.feedback.db";
    static final String USER = "root";
    static final String PASSWORD = "";
    
    Connection conn = null;
    
    public AccionesDB(){
        
    }
    
    /**
     * Funcion que abre la conexion a la BDD
     * @param cliente con los atributos a ingresar en la BDD
     */
    public void GuardarCliente(ArrayList cliente){
        
        if(cliente == null){
            return;
        }
        
        try{
            Class.forName(DRIVER_JDBC);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            insertaCliente((String) cliente.get(0), (String) cliente.get(1),
                    (String) cliente.get(2));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn != null){
                    conn.close();
                    conn = null;
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    /**
     * Con la conexion previamente abierta, guarda los datos de nuestro cliente
     * 
     * @param nombre del cliente a guardar
     * @param apellido1 del cliente a guardar
     * @param apellido2 del cliente a guardar
     */
    private void insertaCliente(String nombre, String apellido1, String apellido2){
        try{
         PreparedStatement ps = conn.prepareStatement(
         "INSERT INTO clientesDB VALUES (?, ?, ?)");
         
         ps.setString(1, nombre);
         ps.setString(2, apellido1);
         ps.setString(3, apellido2);
         
         ps.executeUpdate();
         
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
