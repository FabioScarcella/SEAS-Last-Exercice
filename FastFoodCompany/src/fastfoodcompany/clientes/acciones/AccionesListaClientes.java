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
public class AccionesListaClientes extends AccionesConexionBDD{
    DefaultTableModel tabla;
    
    public AccionesListaClientes(){
        
    }
    
    public AccionesListaClientes(DefaultTableModel tabla){
        this.tabla = tabla;
    }
    
    /**
     * Funcion que nos abre una conexion con la BDD, recoge todos los clientes
     * previamente creados y guardados
     */
    public void listaClientesGuardados(){        
        conectaBDD();

        añadirClientesTabla(accederAClientes());
        
        desconectaBDD();
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
