/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_sillero.modelo.Clientes;
import proyecto_sillero.vista.VistaJDVerClientesCargados;

/**
 *
 * @author Rafa
 */
public class CtrlVerClientesCargados {
    //Atributos:
    String nombreFichero;
    //Controladores:
    private TableModelNoEditable TMClientesCargados;
    //Vistas:
    private VistaJDVerClientesCargados vista;

    public CtrlVerClientesCargados(String nombreFichero, int extension) {
        //Asignamos el nombre pasado por parámetro al de la clase.
        this.nombreFichero = nombreFichero;
        //Creamos la vista lo primero
        vista = new VistaJDVerClientesCargados(null, true);
        //Le decimos quien es su Controlador.
        vista.setCtrlClientesCargados(this);
        //Le ponemos la Localización en el centro
        vista.setLocationRelativeTo(null);
        //Creamos el TableModel
        TMClientesCargados = new TableModelNoEditable();
        //Le decimos quien va a ser su modelo de tabla. en este caso será noEditable.
        vista.getjTableClientesCargados().setModel(TMClientesCargados);
        //Listar CLientes y asignarColumnaVerClientes
        asignarColumnaVerClientes(TMClientesCargados);
        //Según lo que pase (de 0 a 3) cargará un listar u otro.
        switch(extension){
            case 0: listarClientesObj(TMClientesCargados);
                    break;
            case 1: listarClientesTxt(TMClientesCargados);
                break;
            case 2: listarClientesDat(TMClientesCargados);
                break;
            case 3: //xml
                break;
            default:
                break;
        }
        
        //Ponemos la vista visible.
        vista.setVisible(true);
    }
    
    public void asignarColumnaVerClientes(TableModelNoEditable modeloTabla){
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Numero de habitación");
        modeloTabla.addColumn("Numero de noches");
    }
    
    public void listarClientesObj(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            String nombre = "Nuevo Hotel";
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombre);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente obj ioexception");
        } catch (ClassNotFoundException ex) {
             System.out.println("Erroaaaaaaaaaaaaaaaaaaaa");//cambiar luego
        }
        for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()){
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            modeloTabla.addRow(columna);
        }
    }
    
    public void listarClientesTxt(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            String nombre = "Nuevo Hotel";
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtClientes(nombre);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente txt");
        }
        for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()){
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            modeloTabla.addRow(columna);
        }
    }
    
       public void listarClientesDat(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            String nombre = "Nuevo Hotel";
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatClientes(nombre);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente txt");
        }
        for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()){
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            modeloTabla.addRow(columna);
        }
    }
    
    
    
}
