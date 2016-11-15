/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import proyecto_sillero.vista.VistaJFMenuPrincipal;
/**
 *
 * @author Rafa
 */
public class CtrlMenuPrincipal {
    private VistaJFMenuPrincipal menu;
    
    public CtrlMenuPrincipal(VistaJFMenuPrincipal menu) {
        this.menu = menu;
        //Hacemos que cree la carpeta principal Hoteles al iniciarse el programa por si no existe.
        FicherosEscriturayLectura.devolverFicherosEscritura().crearDirectorioPrincipal();
    }
    
    public void AbrirVisualizarHoteles() {
        new CtrlVisualizarHoteles();
    }

    public void AbrirIntroducir(){
        new CtrlIntroducirHoteles();
    }
    
}
