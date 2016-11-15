/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import proyecto_sillero.vista.VistaJFMenuPrincipal;
/**
 *
 * @author Rafa
 */
public class CtrlMenuPrincipal {
    private VistaJFMenuPrincipal menu;
    
    public CtrlMenuPrincipal(VistaJFMenuPrincipal menu) {
        this.menu = menu;
    }
    
    public void AbrirVisualizarHoteles() {
        new CtrlVisualizarHoteles();
    }

    public void AbrirIntroducir(){
        new CtrlIntroducirHoteles();
    }
    
}
