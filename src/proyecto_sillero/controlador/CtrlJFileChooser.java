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
//Lo creamos e instanciamos.

    private JFileChooser chooser;
    private FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("txt", "txt");
    private FileNameExtensionFilter filtroObj = new FileNameExtensionFilter("obj", "obj");
    private FileNameExtensionFilter filtroDat = new FileNameExtensionFilter("dat", "dat");
    private FileNameExtensionFilter filtroXML = new FileNameExtensionFilter("XML", "xml");
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
        String nombre = chooser.getSelectedFile().getName().toString();
        //Esto borrar luego, es para prueba.
        switch (result) {
            case JFileChooser.CANCEL_OPTION:
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
        System.out.println(extension);
        System.out.println(nombre.substring(0,nombre.length()-12));
        //Hacemos un switch en el que comprobaremos si es Cliente o trabajador. Dentro otro switch que compruebe la extension.
        switch (trabajadorOclientesSinExtension) {
            case "Clientes":
                switch (extension) {
                    case ".dat": {
                        try {
                            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatClientes(nombreFichero);
                        } catch (IOException ex) {
                            System.out.println("Error en .dat Clientes.");
                        }
                    }
                    break;
                    case ".txt": {
                        try {
                            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtClientes(nombreFichero);
                        } catch (IOException ex) {
                            System.out.println("Error en .txt Clientes.");
                        }
                    }
                    break;
                    case ".obj": {
                        try {
                            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombreFichero);
                        } catch (IOException ex) {
                            System.out.println("Error en .obj IO Clientes.");
                        } catch (ClassNotFoundException ex) {
                            System.out.println("Error en .obj CLASSNOTFOUND Clientes.");
                        }
                    }
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
                    case ".dat": {
                        try {
                            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatClientes(nombreFichero);
                        } catch (IOException ex) {
                            System.out.println("Error en .dat Trabajadores.");
                        }
                    }
                    break;
                    case ".txt": {
                        try {
                            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtTrabajadores(nombreFichero);
                        } catch (IOException ex) {
                            System.out.println("Error en .txt Trabajadores.");
                        }
                    }
                    break;
                    case ".obj": {
                        try {
                            FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjTrabajadores(nombreFichero);
                        } catch (IOException ex) {
                            System.out.println("Error en .obj IO Clientes.");
                        } catch (ClassNotFoundException ex) {
                            System.out.println("Error en .obj CLASSNOTFOUND Trabajadores.");
                        }
                    }
                    break;
                    case ".xml":
                        break;
                    default:
                        System.out.println("Error, esa extension no es válida.");
                        break;
                }
                break;
            default:
                System.out.println("No es ni un cliente ni trabajador hermano");
                break;

        }

    }

}
