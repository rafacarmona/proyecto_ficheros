/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import proyecto_sillero.vista.VistaJDIntroducirTrabajadoresClientes;
import DAO.FicherosEscriturayLectura;
import java.io.IOException;

/**
 *
 * @author Rafa
 */
public class CtrlIntroducirTrabajadoresClientes {

    private String nombreHotel;
    private VistaJDIntroducirTrabajadoresClientes vista;

    public CtrlIntroducirTrabajadoresClientes(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.vista = new VistaJDIntroducirTrabajadoresClientes(null, true);
        vista.setAnnadirClienteTrabajadorControlador(this);
        vista.setVisible(true);
    }

    public void escribirCliente() throws IOException, ClassNotFoundException {
        String nombreCliente = vista.getjTextFieldNombreCliente().getText();
        String DNI = vista.getjTextFieldDNICliente().getText();
        int nHabitacion = Integer.parseInt(vista.getjTextFieldnHotelCliente().getText());
        int nNoches = Integer.parseInt(vista.getjTextFieldnNochesCliente().getText());
        FicherosEscriturayLectura.devolverFicherosEscritura().escribirFicheroTxtClientes(nombreHotel, nombreCliente, DNI, nHabitacion, nNoches);
        FicherosEscriturayLectura.devolverFicherosEscritura().escribirFicherosDatClientes(nombreHotel, nombreCliente, DNI, nHabitacion, nNoches);
        FicherosEscriturayLectura.devolverFicherosEscritura().escribirFicherosObjClientes(nombreHotel, nombreCliente, DNI, nHabitacion, nNoches);
        FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtClientes(nombreHotel);
       // FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatClientes(nombreHotel);
    }

    public void leerFichero() throws IOException, ClassNotFoundException {
        FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombreHotel);

    }

    public void escribirTrabajador() throws IOException, ClassNotFoundException {
        String nombreTrabajador = vista.getjTextFieldNombreTrabajador().getText();
        String DNI = vista.getjTextFieldDNITrabajador().getText();
        String ocupacion = vista.getjTextFieldOcupacion().getText();
        FicherosEscriturayLectura.devolverFicherosEscritura().escribirFicheroTxtTrabajadores(nombreHotel, nombreTrabajador, DNI, ocupacion);
        FicherosEscriturayLectura.devolverFicherosEscritura().escribirFicherosDatTrabajadores(nombreHotel, nombreTrabajador, DNI, ocupacion);
        FicherosEscriturayLectura.devolverFicherosEscritura().escribirFicherosObjTrabajadores(nombreHotel, nombreTrabajador, DNI, ocupacion);
    }

}
