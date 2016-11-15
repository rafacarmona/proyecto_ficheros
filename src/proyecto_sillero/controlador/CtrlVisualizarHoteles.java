/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import proyecto_sillero.vista.VistaJDVisualizarHoteles;

/**
 *
 * @author Rafa
 */
public class CtrlVisualizarHoteles {

    private String nombreHotel;
    private VistaJDVisualizarHoteles vista;
    private TableModelNoEditable IntroducirVerHoteles;

    public CtrlVisualizarHoteles() {
        //Creamos vista.
        this.vista = new VistaJDVisualizarHoteles(null, true);
        vista.setVisualizarHotelesControlador(this);
        vista.setLocationRelativeTo(null);
        //Creamos tableModel
        IntroducirVerHoteles = new TableModelNoEditable();
        vista.getjTableHoteles().setModel(IntroducirVerHoteles);
        CrearTablaHotel(IntroducirVerHoteles);
        listarHoteles(IntroducirVerHoteles);
        vista.setVisible(true);
    }

    /**
     * Crea la tabla con el nombre de columna "Nombre Hotel".
     *
     * @param modeloTabla
     */
    public void CrearTablaHotel(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Nombre Hotel");
    }
    
    public void AbrirFileChooser(){
               new CtrlJFileChooser(nombreHotel);
    }
    /**
     *Laa principal función de este metodo es rellenar la tabla con todos los hoteles existentes.
     * Por parametro recibimos la tabla donde se rellenará.
     * #tamañolistaHoteles devuelve el numero de directorios que hay para luego usarlo en el for.(es un limitador del for)
     * Borra los registros que hay en la tabla y los vuelve a rellenar
     * @param modeloTabla
     */
    public void listarHoteles(TableModelNoEditable modeloTabla) {       
        int tamañolistaHoteles = FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio().length;
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[1];
        for (int i = 0; i < tamañolistaHoteles; i++) {      
            columna[0] = FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio()[i];
            modeloTabla.addRow(columna);
        }
    }
   
    public void setNombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
    }
    
}
