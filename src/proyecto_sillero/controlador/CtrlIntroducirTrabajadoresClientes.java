/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import proyecto_sillero.vista.VistaJDIntroducirTrabajadoresClientes;
import DAO.FicherosEscriturayLectura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_sillero.modelo.Clientes;

/**
 *
 * @author Rafa
 */
public class CtrlIntroducirTrabajadoresClientes {

    private String nombreHotel;
    private VistaJDIntroducirTrabajadoresClientes vista;
    private TableModelNoEditable IntroducirVerHoteles;

    public CtrlIntroducirTrabajadoresClientes(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.vista = new VistaJDIntroducirTrabajadoresClientes(null, true);
        vista.setAnnadirClienteTrabajadorControlador(this);
       //Creamos tableModel
        IntroducirVerHoteles = new TableModelNoEditable();
        vista.getjTableVerCliente().setModel(IntroducirVerHoteles);
        CrearTablaCliente(IntroducirVerHoteles);
        listarClientes(IntroducirVerHoteles);
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
    
    
    //CARGAR TABLA TRABAJADOR

     public void CrearTablaCliente(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Clientetwrrerewrw");
    }

    /**
     *Laa principal función de este metodo es rellenar la tabla con todos los hoteles existentes.
     * Por parametro recibimos la tabla donde se rellenará.
     * #tamañolistaHoteles devuelve el numero de directorios que hay para luego usarlo en el for.(es un limitador del for)
     * Borra los registros que hay en la tabla y los vuelve a rellenar
     * @param modeloTabla
     */
    public boolean listarClientes(TableModelNoEditable modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[1];
        
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombreHotel);
            for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()) {
            columna[0]=c.getNombre();
            modeloTabla.addRow(columna);
        }
        
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
        
        return true;
    }
}
