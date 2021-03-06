/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.EscrituraYLecturaFicheroXML;
import DAO.FicherosEscriturayLectura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import proyecto_sillero.modelo.Clientes;
import proyecto_sillero.modelo.Trabajador;
import proyecto_sillero.vista.VistaJDVerTrabajadoresCargados;

/**
 *
 * @author Rafa
 */
public class CtrlVerTrabajadoresCargados {

    //Atributos
    String nombreFichero;
    //Table Model
    //private TableModelNoEditable TMClientesEnTrabajadoresCargados; //<-- pasarsele este table model a la segunda tabla
    private TableModelNoEditable TMTrabajadoresCargados;
    private TableModelNoEditable TMClientesEnTrabajadores;
    //Vista
    private VistaJDVerTrabajadoresCargados vista;
    private int extension;

    //Ctrl
    public CtrlVerTrabajadoresCargados(String nombreFichero, int extension) {
        this.extension = extension;
        //Asignamos el nombre pasado por parámetro al de la clase.
        this.nombreFichero = nombreFichero;
        //Creamos la vista lo primero
        vista = new VistaJDVerTrabajadoresCargados(null, true);
        //Le decimos quien es su Controlador.
        vista.setCtrlTrabajadoresCargados(this);
        //Le ponemos la Localización en el centro
        vista.setLocationRelativeTo(null);
        //Creamos el TableModel
        TMTrabajadoresCargados = new TableModelNoEditable();
        TMClientesEnTrabajadores = new TableModelNoEditable();
        //Le decimos quien va a ser su modelo de tabla. en este caso será noEditable.
        vista.getjTableVerTrabajadores().setModel(TMTrabajadoresCargados);
        vista.getjTableCargarClientesTrabajador().setModel(TMClientesEnTrabajadores);
        // asignarColumnaVerClientes
        asignarColumnaVerTrabajadores(TMTrabajadoresCargados);
        asignarColumnaVerClientesEnTrabajadores(TMClientesEnTrabajadores);
        //Según lo que pase (de 0 a 3) cargará un listar u otro.
        switch (extension) {
            case 0:
                listarTrabajadoresObj(TMTrabajadoresCargados);
                break;
            case 1:
                listarTrabajadoresTxt(TMTrabajadoresCargados);
                break;
            case 2:
                listarTrabajadoresDat(TMTrabajadoresCargados);
                break;
            case 3:
                listarTrabajadoresXML(TMTrabajadoresCargados);
                break;
            default:
                break;
        }

        //Ponemos la vista visible.
        vista.setVisible(true);
    }

    /**
     *
     * @param modeloTabla
     */
    public void asignarColumnaVerTrabajadores(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Ocupación");
    }

    public void asignarColumnaVerClientesEnTrabajadores(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Nombre");
    }

    public void listarTrabajadoresObj(TableModelNoEditable modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[3];
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjTrabajadores(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente obj");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error, Clase no encontrada.");//cambiar luego
        }
        for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
            columna[0] = t.getNombre();
            columna[1] = t.getDNI();
            columna[2] = t.getOcupacion();
            modeloTabla.addRow(columna);
        }
    }

    /**
     *
     * @param modeloTabla
     */
    public void listarTrabajadoresTxt(TableModelNoEditable modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[3];
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtTrabajadores(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente txt");
        }
        for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
            columna[0] = t.getNombre();
            columna[1] = t.getDNI();
            columna[2] = t.getOcupacion();
            modeloTabla.addRow(columna);
        }
    }

    public void listarTrabajadoresDat(TableModelNoEditable modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[3];
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatTrabajadores(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir Trabajadores Dat");
        }
        for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
            columna[0] = t.getNombre();
            columna[1] = t.getDNI();
            columna[2] = t.getOcupacion();
            modeloTabla.addRow(columna);
        }
    }

    public void listarTrabajadoresXML(TableModelNoEditable modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[3];
        try {
            EscrituraYLecturaFicheroXML.devolverFicherosEscrituraXML().leerFicheroTrabajadoresXML(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente XML");
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR XML : " + ex);
        } catch (SAXException ex) {
            System.out.println("ERROR XML : " + ex);
        }
        for (Trabajador t : EscrituraYLecturaFicheroXML.devolverFicherosEscrituraXML().getListaDeTrabajadoresXML()) {
            columna[0] = t.getNombre();
            columna[1] = t.getDNI();
            columna[2] = t.getOcupacion();
            modeloTabla.addRow(columna);
        }
    }

    public boolean listarClientesDeTrabajadores() {
        //Creamos el modelo tabla.
        TableModelNoEditable modeloTabla = (TableModelNoEditable) vista.getjTableCargarClientesTrabajador().getModel();
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        int fila = vista.getjTableVerTrabajadores().getSelectedRow();
        if (fila == -1) {
            return false;
        }
        Object[] columna = new Object[1];

        String trabajadorSeleccionado = vista.getjTableVerTrabajadores().getValueAt(fila, 0).toString();
        if (extension != 3) {
            /**
             * Este for lee los ficheros normales.
             */
            for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
                if (t.getNombre().equals(trabajadorSeleccionado)) {
                    for (Clientes c : t.getListaDeClientes()) {
                        columna[0] = c.getNombre();
                        modeloTabla.addRow(columna);
                    }
                }
            }
        }

        if (extension == 3) {
            /**
             * Este for es para el xml.
             */
            for (Trabajador t : EscrituraYLecturaFicheroXML.devolverFicherosEscrituraXML().getListaDeTrabajadoresXML()) {
                if (t.getNombre().equals(trabajadorSeleccionado)) {
                    for (Clientes c : t.getListaDeClientes()) {
                        columna[0] = c.getNombre();
                        modeloTabla.addRow(columna);
                    }
                }
            }
        }
        vista.getjTableCargarClientesTrabajador().setModel(modeloTabla);
        vista.getjTableCargarClientesTrabajador().repaint();

        return true;
    }

}
