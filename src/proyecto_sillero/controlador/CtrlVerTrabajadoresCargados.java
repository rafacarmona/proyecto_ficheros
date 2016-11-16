/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import java.io.IOException;
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
    private TableModelNoEditable TMClientesEnTrabajadoresCargados;
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
        TMClientesEnTrabajadoresCargados = new TableModelNoEditable();
        //Le decimos quien va a ser su modelo de tabla. en este caso será noEditable.
        vista.getjTableCargarClientesTrabajador().setModel(TMClientesEnTrabajadoresCargados);
        //Listar los Clientes y asignarColumnaVerClientes //Falta

        //Según lo que pase (de 0 a 3) cargará un listar u otro.
        switch (extension) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3: //xml
                break;
            default:
                break;
        }

        //Ponemos la vista visible.
        vista.setVisible(true);
    }
    
        public void listarTrabajadoresObj(){
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjTrabajadores(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir Trabajador obj");
        } catch (ClassNotFoundException ex) {
             System.out.println("Error, Clase no encontrada Trabajador.");//cambiar luego
        }
        for(Trabajador t: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()){
            String nombre = t.getNombre();
            String dni = t.getDNI();
            String ocupacion = t.getOcupacion();
        }
    }
}
