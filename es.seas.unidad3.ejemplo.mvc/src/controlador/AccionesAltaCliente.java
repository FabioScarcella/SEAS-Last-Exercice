/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import vista.FrameAplicacion;

/**
 *
 * @author Fabio
 */
public class AccionesAltaCliente {
    private FrameAplicacion frame;
    private DefaultTableModel tabla;

    public AccionesAltaCliente(FrameAplicacion frame){
        this.frame = frame;
    }
    
    public void cargaCombo(){
        ArrayList datosCombo = new ArrayList();
        
        datosCombo.add("Calle");
        datosCombo.add("Avenida");
        datosCombo.add("Plaza");
        datosCombo.add("Rotonda");
        datosCombo.add("Paseo");
        
        Iterator datosComboIterador = datosCombo.iterator();
        
        while(datosComboIterador.hasNext()){
            frame.getCmbTipoDeVia(datosComboIterador.next());
        }
    }
    
    public void cargaTabla(){
        tabla = new DefaultTableModel(new String[]{
            "DNI", "Apellido1", "Apellido2", "Nombre"
        }, 0);
        
        frame.getTblClientes().setModel(tabla);
        frame.getPnlTablaClientes().setViewportView(frame.getTblClientes());
        //PASO 6
        
    }
    
    public void guardarCliente(){
        Vector filaTabla = new Vector();
        filaTabla.add(frame.getTxtDni().getText());
        filaTabla.add(frame.getTxtPrimerApellido().getText());
        filaTabla.add(frame.getTxtSegundoApellido().getText());
        filaTabla.add(frame.getTxtNombre().getText());
        tabla.addRow(filaTabla);
        frame.getTblClientes().setModel(tabla);
        frame.getPnlTablaClientes().setViewportView(frame.getTblClientes());
    }
}
