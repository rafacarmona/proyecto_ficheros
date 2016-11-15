/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.controlador;

import DAO.FicherosEscriturayLectura;
import java.io.IOException;
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
        chooser = new JFileChooser("./Hoteles/"+nombreHotel);
        chooser.setFileFilter(filtroTxt);
        chooser.setFileFilter(filtroObj);
        chooser.setFileFilter(filtroDat);
        chooser.setFileFilter(filtroXML);
        int result = chooser.showOpenDialog(chooser);
        chooser.setVisible(true);
        //Esto borrar luego, es para prueba.
        switch(result){
            case JFileChooser.CANCEL_OPTION:
                break;
            case JFileChooser.APPROVE_OPTION: leerFicheroSegunExtension();
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("error");
                break;
        }
        
        }
  
    /**
     * Esto tiene un error guapisimo y es que con el else me lo pueden liar poniendo un fichero con otro nombre
     * Soluionar: necesitamos conseguir la ruta relativa!! Quitar toda esta ursureria que tengo monta' para probar todo esto.
     * Solucionar el leer archivo.
     * Intentar darle a esto una mejor solucion que tengo un tinglao guapisimo.
     * Error: el Dao realmente al leer no debería crear una ruta para ese fichero si no existe, tener cuidado con eso loco.
     * Posible solución: 
     * Podemos coger la ruta Absoluta de ./Hoteles/nombreHotel/ y compararla con la ruta absoluta de ./Hoteles/nombreHotel/nombreFichero.ext
     * 
     */
    public void leerFicheroSegunExtension(){
        String extension = chooser.getSelectedFile().toString();
        int n = chooser.getSelectedFile().toString().length();
        String ClientesOTrabajadores = extension.substring(18, n-12);
        System.out.println(ClientesOTrabajadores);
        try{
        if(ClientesOTrabajadores.substring(0,8).equals("Clientes")){
            this.nombreFichero = chooser.getSelectedFile().toString().substring(n-12, n);
            switch(ClientesOTrabajadores.substring(8)){
                case ".dat": FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosDatClientes(nombreFichero);
                    System.out.println(nombreFichero);
                    break;
                case ".obj": FicherosEscriturayLectura.devolverFicherosEscritura().leerFicherosObjClientes(nombreFichero);
                    break;
                case ".xml": 
                    break;
                case ".txt": FicherosEscriturayLectura.devolverFicherosEscritura().leerFicheroTxtClientes(nombreFichero);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }else{
            switch(ClientesOTrabajadores.substring((ClientesOTrabajadores.length()-4), ClientesOTrabajadores.length())){
                case ".dat": System.out.println("Es dato");
                    break;
                case ".obj": System.out.println("Es obj");
                    break;
                case ".xml": System.out.println("Es xml");
                    break;
                case ".txt": System.out.println("es txt");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
       }catch(IOException e){
            System.out.println("error IOException");
       }catch(ClassNotFoundException e){
            System.out.println("Error");
       }
    }

    
}
