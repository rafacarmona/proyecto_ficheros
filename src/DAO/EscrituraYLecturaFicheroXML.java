/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import proyecto_sillero.modelo.Clientes;
import proyecto_sillero.modelo.Trabajador;

/**
 *
 * @author Rafa
 */
public class EscrituraYLecturaFicheroXML {    
    
    public boolean escribirFicheroClientesXML(String nombreFichero){
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.txt");
        try{
           if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        //Comentario (averiguar que hace)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //Comentario (saber que hace)
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Implementamos el DOM
        DOMImplementation implementation = builder.getDOMImplementation();
        //Creamos el Documento con los parametros (buscar para que sirve cada uno)
        Document document = implementation.createDocument(null, "Hoteles", null);
        //le decimos que versión de xml es.
        document.setXmlVersion("1.0");
                
        //Definimos el elemento Raíz.
        Element elementoRaiz = document.getDocumentElement();
        //Definimos La primera etiqueta, que es Hoteles.
        Element HotelesNode = document.createElement("HOTELES");
        //hacemos que recorra todos los hoteles, cada elemento de leerDirectorio es un Hotel.
        for(int i = 0; i < FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio().length; i++){
            //Hacemos que el nombre Del
            Element HotelNode = document.createElement("HOTEL");
            Text nombreHotelValue = document.createTextNode(FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio()[i]);
            HotelNode.appendChild(nombreHotelValue);
            //Ahora creamos todos los elementos de los Clientes.
            Element ClientesNode = document.createElement("CLIENTES");
            for(Clientes c: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()){
                //Definimos el nombreDel cliente.
                Element NombreClienteNode = document.createElement("NOMBRECLIENTE");
                Text NombreClienteNodeValue = document.createTextNode(c.getNombre());
                NombreClienteNode.appendChild(NombreClienteNodeValue);
                //Definimos el DNI del cliente.
                Element DNIClienteNode = document.createElement("DNICLIENTE");
                Text DNIClienteNodeValue = document.createTextNode(c.getDNI());
                DNIClienteNode.appendChild(DNIClienteNodeValue);
                //Definimos el numero De Hotel
                Element nHabitacionClienteNode = document.createElement("NHABITACIONCLIENTE");
                Text nHabitacionClienteNodeValue = document.createTextNode(c.getNHabitacion()+"");
                nHabitacionClienteNode.appendChild(nHabitacionClienteNodeValue);
                //Definimos el numero de Noches
                Element nNochesClienteNode = document.createElement("NOMBRECLIENTE");
                Text nNochesClienteNodeValue = document.createTextNode(c.getNNoches()+"");
                nNochesClienteNode.appendChild(nNochesClienteNodeValue);
                
            }
            //Todos los elementos de los Trabajadores.
            Element TrabajadoresNode = document.createElement("TRABAJADORES");
            for(Trabajador t: FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()){
                  //Definimos el nombreDel Trabajador.
                Element nombreDelTrabajadorNode = document.createElement("NOMBRETRABAJADOR");
                Text NombreDelTrabajadorNodeValue = document.createTextNode(t.getNombre());
                nombreDelTrabajadorNode.appendChild(NombreDelTrabajadorNodeValue);
                  //Definimos el nombreDel cliente.
                Element DNITrabajadorNode = document.createElement("DNITRABAJADOR");
                Text DNITrabajadorNodeValue = document.createTextNode(t.getDNI());
               DNITrabajadorNode.appendChild(DNITrabajadorNodeValue);
                  //Definimos el nombreDel cliente.
                Element ocupacionTrabajadorNode = document.createElement("OCUPACIONTRABAJADOR");
                Text ocupacionTrabajadorNodeValue = document.createTextNode(t.getOcupacion());
                ocupacionTrabajadorNode.appendChild(ocupacionTrabajadorNodeValue);
            }
        }
        
        }catch(IOException ioe){
            return false;
        }catch(ParserConfigurationException pce){
            return false;
        }
        
        
        return true;
    }
}
