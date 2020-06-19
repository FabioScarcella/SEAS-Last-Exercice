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
    
    /**
     * Funcion que lleva la lógica principal para editar un cliente de la BDD
     * @param numeroCliente es el ID que la BDD asigna a un cliente al registrarlo
     * @param nombre 
     * @param apellido1
     * @param apellido2 
     */
    public void editaCliente(String numeroCliente, String nombre, String apellido1,
            String apellido2){
        try{
            Class.forName(DRIVER_JDBC);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            if(!compruebaNumeroCliente(numeroCliente)){
                System.out.println("No usuario");
                return;
            }
            
            nombre = comprobarVariables(numeroCliente, nombre, "nombre");
            apellido1 = comprobarVariables(numeroCliente, apellido1, "apellido1");
            apellido2 = comprobarVariables(numeroCliente, apellido2, "apellido2");
            
            actualizaCliente(numeroCliente, nombre, apellido1, apellido2);
            
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
     * Comprueba que el numeroCliente introducido sea valido y haya un cliente
     * con ese numeroCliente
     * @param numeroCliente
     * @return si hay un usuario con ese numeroCliente, devuelve true, sino false
     */
    private boolean compruebaNumeroCliente(String numeroCliente){
        boolean returnState = false;
        try{
            PreparedStatement stat = conn.prepareStatement(
            "SELECT * FROM clientesDB where NumeroCliente = ?");
            stat.setString(1, numeroCliente);
            ResultSet rs = stat.executeQuery();
            
            if(rs.next()){
                System.out.println("Hay valor");
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
    private String comprobarVariables(String numeroCliente, String nombre,
            String columnaBDD){
        if("".equals(nombre)){
            try{
                
                PreparedStatement statement = conn.prepareStatement(
                    "SELECT ? FROM clientesDB WHERE NumeroCliente = ?");
                statement.setString(1, columnaBDD);
                statement.setString(2, numeroCliente);
                
                ResultSet rs = statement.executeQuery();
                
                /*
                Comprobamos que haya devuelto algun parametro 
                para evitar errores.
                Y solo nos devolvera 1 parametro ya que el 
                numeroCliente no puede estar repetida en la BDD
                */
                
                while(rs.next()){
                    nombre = rs.getString(1);
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return nombre;
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
     * Comprueba que existe el numeroCliente introducido y lo elimina si existe
     * @param numeroCliente 
     */
    public void bajaCliente(String numeroCliente){
        try{
            Class.forName(DRIVER_JDBC);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            if(!compruebaNumeroCliente(numeroCliente)){
                System.out.println("No usuario");
                return;
            }
            
            eliminaCliente(numeroCliente);
            
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
