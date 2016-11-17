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
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rafa
 */
public class CtrlJFileChooser {
//Creamos el Jfilechooser.
    private JFileChooser chooser;
//Le creamos los filtros.    
    private FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("txt", "txt");
    private FileNameExtensionFilter filtroObj = new FileNameExtensionFilter("obj", "obj");
    private FileNameExtensionFilter filtroDat = new FileNameExtensionFilter("dat", "dat");
    private FileNameExtensionFilter filtroXML = new FileNameExtensionFilter("XML", "xml");
//Atributos de la clase.
    private String nombreHotel;
    private String nombreFichero;

    public CtrlJFileChooser(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        chooser = new JFileChooser("./Hoteles/" + nombreHotel);
        chooser.setFileFilter(filtroTxt);
        chooser.setFileFilter(filtroObj);
        chooser.setFileFilter(filtroDat);
        chooser.setFileFilter(filtroXML);
        int result = chooser.showOpenDialog(chooser);
        chooser.setVisible(true);
        //Esto borrar luego, es para prueba.
        switch (result) {
            case JFileChooser.CANCEL_OPTION:
                System.out.println();
                break;
            case JFileChooser.APPROVE_OPTION:
                leerFicheroSegunExtension();
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("error");
                break;
        }

    }

    /**
     * Esto tiene un error guapisimo y es que con el else me lo pueden liar
     * poniendo un fichero con otro nombre Soluionar: necesitamos conseguir la
     * ruta relativa!! Quitar toda esta ursureria que tengo monta' para probar
     * todo esto. Solucionar el leer archivo. Intentar darle a esto una mejor
     * solucion que tengo un tinglao guapisimo. Error: el Dao realmente al leer
     * no debería crear una ruta para ese fichero si no existe, tener cuidado
     * con eso loco. Posible solución: Podemos coger la ruta Absoluta de
     * ./Hoteles/nombreHotel/ y compararla con la ruta absoluta de
     * ./Hoteles/nombreHotel/nombreFichero.ext
     *
     */
    public void leerFicheroSegunExtension() {
        String nombre = chooser.getSelectedFile().getName().toString();
        //Vamos a comprobar si es un cliente o es un trabajador.
        String trabajadorOclientesSinExtension = nombre.substring((nombre.length() - 12), (nombre.length() - 4));
        //Con esto sacamos la extension del fichero
        String extension = nombre.substring(nombre.length() - 4);
        String nombreFichero = nombre.substring(0, nombre.length()-12);
        if(!trabajadorOclientesSinExtension.equals("Clientes")){
            nombreFichero =  nombre.substring(0, nombre.length()-16);
            trabajadorOclientesSinExtension = nombre.substring((nombre.length() - 16), (nombre.length() - 4));
        }
        System.out.println(nombreFichero);
        //Hacemos un switch en el que comprobaremos si es Cliente o trabajador. Dentro otro switch que compruebe la extension.
        switch (trabajadorOclientesSinExtension) {
            case "Clientes":
                switch (extension) {
                    case ".dat": 
                        new CtrlVerClientesCargados(nombreFichero, 2);
                    break;
                    case ".txt":
                       new CtrlVerClientesCargados(nombreFichero, 1);
                    
                    break;
                    case ".obj": 
                      new CtrlVerClientesCargados(nombreFichero, 0);
                    
                    break;
                    case ".xml":
                        break;
                    default:
                        System.out.println("Error, esa extension no es válida.");
                        break;
                }
                break;
            case "Trabajadores":
                switch (extension) {
                    case ".dat":  new CtrlVerTrabajadoresCargados(nombreFichero, 2);
                    break;
                    case ".txt": new CtrlVerTrabajadoresCargados(nombreFichero, 1);
                    break;
                    case ".obj": new CtrlVerTrabajadoresCargados(nombreFichero, 0);
                    break;
                    case ".xml":
                        break;
                    default:
                        System.out.println("Error, esa extension no es válida.");
                        break;
                }
                break;
            default:
                System.out.println("No es ni un cliente ni trabajador");
                break;

        }

    }

}
