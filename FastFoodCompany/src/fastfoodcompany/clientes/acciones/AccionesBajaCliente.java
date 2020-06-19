/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodcompany.clientes.acciones;

import fastfoodcompany.clientes.vistas.PanelBajaCliente;

/**
 *
 * @author fabio
 */
public class AccionesBajaCliente {
    PanelBajaCliente panel;
    AccionesDB accionesDB;
    
    public AccionesBajaCliente(PanelBajaCliente panel){
        this.panel = panel;
        accionesDB = new AccionesDB();
    }
    
    public void bajaCliente(){
        String numeroCliente = panel.getTxtNumeroCliente().getText();
        
        accionesDB.bajaCliente(numeroCliente);
    }
}
