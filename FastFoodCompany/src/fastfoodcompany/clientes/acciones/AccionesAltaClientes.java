/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import fastfoodcompany.clientes.vistas.PanelAltaClientes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Fabio
 */
public class AccionesAltaClientes extends AccionesConexionBDD{
    private PanelAltaClientes panel;
    private AccionesListaClientes accionesDB;
    
    public AccionesAltaClientes(PanelAltaClientes panel){
        this.panel = panel;
        accionesDB = new AccionesListaClientes();
    }
    
    public void guardarCliente(){
        ArrayList filaCliente = new ArrayList();
        
        filaCliente.add(panel.getTxtNombre().getText());
        filaCliente.add(panel.getTxtApellido1().getText());
        filaCliente.add(panel.getTxtApellido2().getText());
        
        guardarCliente(filaCliente);
        
        panel.getFrame().getClientesGuardados().add(filaCliente);
    }
    
    /**
     * Funcion que nos permite conectar con la BDD y hacer la llamada para
     * intertar el arrayList en la BDD
     * @param cliente 
     */
    private void guardarCliente(ArrayList cliente){
        if(cliente == null){
            return;
        }
        
        conectaBDD();
        
        insertaCliente((String) cliente.get(0), (String) cliente.get(1),
                    (String) cliente.get(2));
        
        desconectaBDD();
        
        
    }
    
    /**
     * Inserta los valores introducidos del cliente en la BDD
     * @param nombre
     * @param apellido1
     * @param apellido2 
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
    
}