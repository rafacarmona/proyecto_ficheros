/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import proyecto_sillero.vista.VistaJDIntroducirHoteles;

/**
 *
 * @author Rafa
 */
public class CtrlIntroducirHoteles {
    /*
    Controladores
    */
    private CtrlIntroducirTrabajadoresClientes introducirTrabajadoresClientes;
    private TableModelNoEditable IntroducirVerHoteles;
    private CtrlInsertarHotel insertarHotel;
    /*
    VISTAS
    */
    private VistaJDIntroducirHoteles vista;
    /*
    Atributos.
    */
    private String nombreHotel;
    
    public CtrlIntroducirHoteles() {
        //Creamos vista.
        this.vista = new VistaJDIntroducirHoteles(null, true);
        vista.setIntroducirControlador(this);
        vista.setLocationRelativeTo(null);
        //Creamos tableModel
        IntroducirVerHoteles = new TableModelNoEditable();
        vista.getjTableHotelesInsertar().setModel(IntroducirVerHoteles);
        CrearTablaHotel(IntroducirVerHoteles);
        listarHoteles(IntroducirVerHoteles);
        vista.setVisible(true);
    }

    public void AbrirIntroducirHoteles() {
        new CtrlInsertarHotel();
    }
    
    public void AbrirAnnadirClienteyTrabajador(){
       new CtrlIntroducirTrabajadoresClientes(nombreHotel);
    }

    public void CrearTablaHotel(TableModelNoEditable modeloTabla) {
        modeloTabla.addColumn("Nombre Hotel");
    }
    
    public void listarHoteles(TableModelNoEditable modeloTabla) {
        int tamañolistaHoteles = FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio().length;
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[1];
        for(int i = 0; i < tamañolistaHoteles; i++){
            columna[0] = FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio()[i];
            modeloTabla.addRow(columna);
        }
    }
    
    public void setNombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
    }
    

}
