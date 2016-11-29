/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.EscrituraYLecturaFicheroXML;
import DAO.FicherosEscriturayLectura;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
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
            case 3: listarClientesXML(TMClientesCargados);
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
    /**
     * INFORMACIÓN QUE CUBRE TODOS LOS MÉTODOS.
     * Lo primero que hacemos es limpiar la tabla, luego creamos un array de objetos[4].
     * Llamamos a la clase leerFicheroObjClientes, que nos cargará en memoria todos los clientes.
     * Con foreach recorremos todos los objetos.
     * Escribimos el array de objetos y lo añadimos a la Row.
     */
    /**
     * ListarClientes con la extensión obj.
     * @param modeloTabla 
     */
    public void listarClientesObj(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente obj");
        } catch (ClassNotFoundException ex) {
             System.out.println("Error, Clase no encontrada.");//cambiar luego
        }
        for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()){
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            modeloTabla.addRow(columna);
        }
    }
    /**
     * Listar Clientes con la extension txt.
     * @param modeloTabla 
     */
    public void listarClientesTxt(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtClientes(nombreFichero);
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
    
    /**
     * Listar Clientes con la extension Dat.
     * @param modeloTabla 
     */
       public void listarClientesDat(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatClientes(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente Dat");
        }
        for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()){
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            modeloTabla.addRow(columna);
        }
    }
    
        public void listarClientesXML(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[4];
        try {
            EscrituraYLecturaFicheroXML.devolverFicherosEscrituraXML().leerFicheroClientesXML(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error al añadir cliente xml");
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        }
        for(Clientes c: EscrituraYLecturaFicheroXML.devolverFicherosEscrituraXML().getListaDeClientesXML()){
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            modeloTabla.addRow(columna);
        }
    }
    
    
}
