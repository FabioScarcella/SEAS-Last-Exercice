/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import fastfoodcompany.clientes.vistas.PanelEditaCliente;

/**
 *
 * @author fabio
 */
public class AccionesEditaCliente {
    
    PanelEditaCliente panel;
    AccionesDB accionesDB;
    
    public AccionesEditaCliente(PanelEditaCliente panel){
        this.panel = panel;
        accionesDB = new AccionesDB();
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
        accionesDB.editaCliente(numeroCliente, nombre, apellido1, apellido2);
    }
    
}
