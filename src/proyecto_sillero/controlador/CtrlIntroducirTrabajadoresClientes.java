/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import proyecto_sillero.vista.VistaJDIntroducirTrabajadoresClientes;
import DAO.FicherosEscriturayLectura;
import java.io.IOException;
import proyecto_sillero.modelo.Clientes;

/**
 *
 * @author Rafa
 */
public class CtrlIntroducirTrabajadoresClientes {

    private String nombreHotel;
    private VistaJDIntroducirTrabajadoresClientes vista;
    private TableModelNoEditable IntroducirVerHoteles;
    //probar creando otro TableNoModel
    private TableModelNoEditable IntroducirVerHoteles2;

    public CtrlIntroducirTrabajadoresClientes(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.vista = new VistaJDIntroducirTrabajadoresClientes(null, true);
        vista.setAnnadirClienteTrabajadorControlador(this);
        //Creamos tableModel
        IntroducirVerHoteles = new TableModelNoEditable();
        IntroducirVerHoteles2 = new TableModelNoEditable();
        vista.getjTableVerCliente().setModel(IntroducirVerHoteles);
        crearTablaClienteEnTrabajadores(IntroducirVerHoteles);
        listarClientesEnTrabajadores(IntroducirVerHoteles);
        //PRUEBA DE SEGUNDA TABLA.

        vista.getjTableEscribirClientes().setModel(IntroducirVerHoteles2);
        crearTablaEscribirClienteEnTrabajadores(IntroducirVerHoteles2);
        vista.setLocationRelativeTo(null);
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

    //CARGAR TABLA Cliente en trabajador.
    /**
     * Añade la columna Clientes.
     *
     * @param modeloTabla
     */
    public void crearTablaClienteEnTrabajadores(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Clientes");
    }

    /**
     * Como principal función, rellena la tabla con los nombres de los clientes.
     * Primero limpiamos la tabla. Luego creamos un objeto columna con el que
     * solo recibirá un dato. Luego leerá los ficherosObjClientes e irá
     * rellenando la tabla. retorna falso si falla.
     *
     * @param modeloTabla --> le pasamos la tabla.
     * @return
     */
    public boolean listarClientesEnTrabajadores(TableModelNoEditable modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[1];

        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombreHotel);
            for (Clientes c : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()) {
                columna[0] = c.getNombre();
                modeloTabla.addRow(columna);
            }

        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }

        return true;
    }

    public void crearTablaEscribirClienteEnTrabajadores(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Clientes a Añadir");
    }

    //Obtenemos el Cliente de una columna y lo pasamos a la otra.
    /**
     *primero conseguimos el tablemodel en el que escribimos, lo casteamos y lo ponemos como tablemodel no editable. 
     * Conseguimos la fila seleccionada, si no hemos conseguido ninguna será -1.
     * Conseguimos el nombre de la columna y lo pasamos a String.
     * Creamos el objeto y añadimos la row. seteamos el modelo.
     * Ahora lo que hacemos es de Ver Cliente borrar el Cliente pasado.
     * @return
     */
    public boolean pasarDeVerClienteAEscribir() {
        TableModelNoEditable tmEscribirCliente = (TableModelNoEditable) vista.getjTableEscribirClientes().getModel();
        int fila = vista.getjTableVerCliente().getSelectedRow();
        if (fila == -1) {
            return false;
        }
        String clienteSeleccionado = vista.getjTableVerCliente().getValueAt(fila, 0).toString();
        Object[] row = new Object[1];
        row[0] = clienteSeleccionado;
        tmEscribirCliente.addRow(row);
        vista.getjTableEscribirClientes().setModel(tmEscribirCliente);
        
        TableModelNoEditable tmVerCliente;
        tmVerCliente = (TableModelNoEditable) vista.getjTableVerCliente().getModel();
        tmVerCliente.removeRow(fila);
        vista.getjTableVerCliente().setModel(tmVerCliente);
        vista.getjTableEscribirClientes().repaint();
        return true;
    }
    
    public boolean pasarDeEscribirClienteAVer() {
        TableModelNoEditable tmEscribirCliente = (TableModelNoEditable) vista.getjTableVerCliente().getModel();
        int fila = vista.getjTableEscribirClientes().getSelectedRow();
        if (fila == -1) {
            return false;
        }
        String clienteSeleccionado = vista.getjTableEscribirClientes().getValueAt(fila, 0).toString();
        Object[] row = new Object[1];
        row[0] = clienteSeleccionado;
        tmEscribirCliente.addRow(row);
        vista.getjTableVerCliente().setModel(tmEscribirCliente);
        
        TableModelNoEditable tmVerCliente;
        tmVerCliente = (TableModelNoEditable) vista.getjTableEscribirClientes().getModel();
        tmVerCliente.removeRow(fila);
        vista.getjTableEscribirClientes().setModel(tmVerCliente);
        vista.getjTableVerCliente().repaint();
        return true;
    }

}
