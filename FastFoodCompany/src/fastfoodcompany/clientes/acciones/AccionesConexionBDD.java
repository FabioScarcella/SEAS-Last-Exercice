/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import static fastfoodcompany.clientes.acciones.AccionesListaClientes.DRIVER_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabio
 */
public class AccionesConexionBDD {
    static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
    static final String DB_URL = 
            "jdbc:mysql://localhost:3306/es.seas.u3.ejercicio.feedback.db";
    static final String USER = "root";
    static final String PASSWORD = "";
    
    Connection conn = null;
    
    public AccionesConexionBDD(){
        
    }
    
    protected void conectaBDD(){
        try{
            Class.forName(DRIVER_JDBC);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void desconectaBDD(){
        try{
            if(conn != null){
                conn.close();
                conn = null;
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    protected boolean compruebaNumeroCliente(String numeroCliente){
        boolean returnState = false;
        try{
            PreparedStatement stat = conn.prepareStatement(
            "SELECT * FROM clientesDB where NumeroCliente = ?");
            stat.setString(1, numeroCliente);
            ResultSet rs = stat.executeQuery();
            
            if(rs.next()){
                returnState = true;
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            return returnState;
        }
    }
    
    /**
     * Funcion que comprueba si hemos añadido un valor para modificarlo, o si
     * lo hemos dejado vacio, si lo hemos dejado vacio coge el valor que tenía
     * antes 
     * @param numeroCliente
     * @param nombre
     * @param columnaBDD que columna queremos editar, nombre, apellido1, etc
     * @return 
     */
    protected String comprobarVariables(String numeroCliente, String nombre,
            String columnaBDD){
        
        
        
        if("".equals(nombre)){
            try{
                System.out.println(columnaBDD);
                String consulta = 
                        "SELECT "+ columnaBDD + " FROM clientesDB WHERE NumeroCliente = ?";
                PreparedStatement statement = conn.prepareStatement(consulta);
               // statement.setString(1, columnaBDD);
                statement.setString(1, numeroCliente);
                
                ResultSet rs = statement.executeQuery();
                
                /*
                Comprobamos que haya devuelto algun parametro 
                para evitar errores.
                Y solo nos devolvera 1 parametro ya que el 
                numeroCliente no puede estar repetida en la BDD
                */
                
                while(rs.next()){
                    System.out.println(rs.getString(1));
                    nombre = rs.getString(1);
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return nombre;
    }
    
}
