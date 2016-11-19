/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import java.io.IOException;
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
    private TableModelNoEditable TMClientesEnTrabajadoresCargados;
    private TableModelNoEditable TMTrabajadoresCargados;
    //Vista
    private VistaJDVerTrabajadoresCargados vista;

    //Ctrl
    public CtrlVerTrabajadoresCargados(String nombreFichero, int extension) {
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
        //Le decimos quien va a ser su modelo de tabla. en este caso será noEditable.
        vista.getjTableVerTrabajadores().setModel(TMTrabajadoresCargados);
        //Listar CLientes y asignarColumnaVerClientes
        asignarColumnaVerTrabajadores(TMTrabajadoresCargados);

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
            case 3: //xml
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
            System.out.println("Error al añadir cliente dat");
        }
        for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
            columna[0] = t.getNombre();
            columna[1] = t.getDNI();
            columna[2] = t.getOcupacion();
            modeloTabla.addRow(columna);
        }
    }
}
