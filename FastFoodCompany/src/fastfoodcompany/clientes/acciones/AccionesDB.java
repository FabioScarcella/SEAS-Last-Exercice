/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import fastfoodcompany.clientes.vistas.PanelListaClientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
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
    DefaultTableModel tabla;
    
    public AccionesDB(){
        
    }
    
    public AccionesDB(DefaultTableModel tabla){
        this.tabla = tabla;
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
         "INSERT INTO clientesDB VALUES (?, ?, ?, ?)");
         
         ps.setInt(1, 0); //TENEMOS QUE AÑADIR UN INT PARA QUE NO DE UN ERROR
                            //LA BDD, DE ESTA MANERA LA MISMA BDD SE ENCARGARA 
                            //DE INCREMENTAR Y Y NO REPETIR EL MISMO NUMERO PARA
                            //LOS CLIENTES, ES 0 PERO PODRIA SER CUALQUIER NUMERO
         ps.setString(2, nombre);
         ps.setString(3, apellido1);
         ps.setString(4, apellido2);
         
         ps.executeUpdate();
         
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    /**
     * Funcion que nos abre una conexion con la BDD, recoge todos los clientes
     * previamente creados y guardados
     */
    public void listaClientesGuardados(){
        
        try{
            Class.forName(DRIVER_JDBC);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            añadirClientesTabla(accederAClientes());
            
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
     * Accede a los clientes y los guarda en un array
     * @return la informacion de los clientes separado por ","
     */
    private ArrayList accederAClientes(){
        String SQL_SELECT_TODO = "SELECT * FROM clientesDB";
        ArrayList clientes = new ArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_TODO);
            
            while(rs.next()){
                clientes.add(rs.getString(1) + "," + rs.getString(2) 
                        + "," + rs.getString(3) + "," + rs.getString(4));
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            return clientes;
        }
    }
    
    /**
     * Añade la información de los clientes en una tabla
     * @param clientes lista de los clientes y su información separado por ","
     */
    private void añadirClientesTabla(ArrayList clientes){
        ListIterator listIterator = clientes.listIterator();
            
        while(listIterator.hasNext()){
            String dataCliente = (String) listIterator.next();
            String[] splitString =  dataCliente.split(",");

            Vector filaTabla = new Vector();
            
            filaTabla.add(splitString[0]);
            filaTabla.add(splitString[1]);
            filaTabla.add(splitString[2]);
            filaTabla.add(splitString[3]);

            tabla.addRow(filaTabla);
        }
    }
}
