/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import proyecto_sillero.vista.VistaJDInsertarHoteles;


/**
 *
 * @author Rafa
 */
public class CtrlInsertarHotel {
    private VistaJDInsertarHoteles vista;
    //controlador para poder actualizar la tabla
    private CtrlIntroducirHoteles ctrlintroducirHoteles;
    public CtrlInsertarHotel() {

        this.vista = new VistaJDInsertarHoteles(null, true);
        vista.setInsertarHotelCtrl(this);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void introducirHotel() {
        String nombreHotel = vista.getjTextFieldCrearHotel().getText();
        FicherosEscriturayLectura.devolverFicherosEscritura().crearDirectorio(nombreHotel);
    }
    
    public void qeqweqwe(){
        
    }
}
