/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import fastfoodcompany.clientes.vistas.PanelAltaClientes;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Fabio
 */
public class AccionesAltaClientes {
    private PanelAltaClientes panel;
    private AccionesDB accionesDB;
    
    public AccionesAltaClientes(PanelAltaClientes panel){
        this.panel = panel;
        accionesDB = new AccionesDB();
    }
    
    public void guardarCliente(){
        ArrayList filaCliente = new ArrayList();
        
        filaCliente.add(panel.getTxtNombre().getText());
        filaCliente.add(panel.getTxtApellido1().getText());
        filaCliente.add(panel.getTxtApellido2().getText());
        
        accionesDB.GuardarCliente(filaCliente);
        
        panel.getFrame().getClientesGuardados().add(filaCliente);
    }
    
}