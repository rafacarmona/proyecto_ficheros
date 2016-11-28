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
    
        private static EscrituraYLecturaFicheroXML escrituraYLecturaXML = null;

    public static EscrituraYLecturaFicheroXML devolverFicherosEscrituraXML() {

        if (escrituraYLecturaXML != null) {
            return escrituraYLecturaXML;
        } else {
            escrituraYLecturaXML = new EscrituraYLecturaFicheroXML();
            return escrituraYLecturaXML;
        }
    }

    public boolean escribirFicheroClientesXML(String nombreFichero) throws TransformerConfigurationException, TransformerException {
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.xml");
        try {
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
            Document document = implementation.createDocument(null, "HOTELES", null);
            //le decimos que versión de xml es.
            document.setXmlVersion("1.0");

            //Definimos el elemento Raíz.
            Element elementoRaiz = document.getDocumentElement();
            //Definimos La primera etiqueta, que es Hoteles.
            Element HotelesNode = document.createElement("HOTELES");
            //hacemos que recorra todos los hoteles, cada elemento de leerDirectorio es un Hotel.
            for (int i = 0; i < FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio().length; i++) {
                //Hacemos que el nombre Del
                Element HotelNode = document.createElement("HOTEL");
                Text nombreHotelValue = document.createTextNode(FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio()[i]);
                HotelNode.appendChild(nombreHotelValue);
                //Ahora creamos todos los elementos de los Clientes.
                Element ClientesNode = document.createElement("CLIENTES");
                for (Clientes c : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()) {
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
                    Text nHabitacionClienteNodeValue = document.createTextNode(c.getNHabitacion() + "");
                    nHabitacionClienteNode.appendChild(nHabitacionClienteNodeValue);
                    //Definimos el numero de Noches
                    Element nNochesClienteNode = document.createElement("NNOCHES");
                    Text nNochesClienteNodeValue = document.createTextNode(c.getNNoches() + "");
                    nNochesClienteNode.appendChild(nNochesClienteNodeValue);

                    ClientesNode.appendChild(NombreClienteNode);
                    ClientesNode.appendChild(DNIClienteNode);
                    ClientesNode.appendChild(nHabitacionClienteNode);
                    ClientesNode.appendChild(nNochesClienteNode);
                }
                //lo añadimos a Hoteles
                HotelNode.appendChild(ClientesNode);
                /*
                //Todos los elementos de los Trabajadores.
                Element TrabajadoresNode = document.createElement("TRABAJADORES");
                for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
                    //Definimos el nombre Del Trabajador.
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
                    //le asignamos los nodos
                    TrabajadoresNode.appendChild(nombreDelTrabajadorNode);
                    TrabajadoresNode.appendChild(DNITrabajadorNode);
                    TrabajadoresNode.appendChild(ocupacionTrabajadorNode);
                    //listamos los clientes que pertenece a cada trabajador.
                    for (Clientes ct : t.getListaDeClientes()) {
                        Element ClienteTrabajadorNode = document.createElement("CLIENTESQUEATIENDEELTRABAJADOR");
                        Text oClienteTrabajadorNodeValue = document.createTextNode(ct.getNombre());
                        ClienteTrabajadorNode.appendChild(oClienteTrabajadorNodeValue);

                        //le asignamos el nodo
                        TrabajadoresNode.appendChild(ClienteTrabajadorNode);
                    }

                }
                //Lo añadimos a hoteles.
                HotelNode.appendChild(TrabajadoresNode);
                */
                elementoRaiz.appendChild(HotelNode);
                //con el source generamos el xml
                Source source = new DOMSource(document);
                //le indicamos en que fichero se va a guardar pasandole la ruta por parámetro.
                Result rutaAlmacenFichero = new StreamResult(archivo);
                // lo transformamos y creamos la instancia
                Transformer transfomer = TransformerFactory.newInstance().newTransformer();
                //le pasamos por parametro el xml que generamos y la ruta de almacenaje.
                transfomer.transform(source, rutaAlmacenFichero);
            }

        } catch (IOException ioe) {
            return false;
        } catch (ParserConfigurationException pce) {
            return false;
        }

        return true;
    }
     public boolean escribirFicheroTrabajadoresXML(String nombreFichero) throws TransformerConfigurationException, TransformerException {
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.xml");
        try {
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
            Document document = implementation.createDocument(null, "HOTELES", null);
            //le decimos que versión de xml es.
            document.setXmlVersion("1.0");

            //Definimos el elemento Raíz.
            Element elementoRaiz = document.getDocumentElement();
            //Definimos La primera etiqueta, que es Hoteles.
            Element HotelesNode = document.createElement("HOTELES");
            //hacemos que recorra todos los hoteles, cada elemento de leerDirectorio es un Hotel.
            for (int i = 0; i < FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio().length; i++) {
                //Hacemos que el nombre Del
                Element HotelNode = document.createElement("HOTEL");
                Text nombreHotelValue = document.createTextNode(FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio()[i]);
                HotelNode.appendChild(nombreHotelValue);
                
                //Todos los elementos de los Trabajadores.
                Element TrabajadoresNode = document.createElement("TRABAJADORES");
                for (Trabajador t : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeTrabajadores()) {
                    //Definimos el nombre Del Trabajador.
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
                    //le asignamos los nodos
                    TrabajadoresNode.appendChild(nombreDelTrabajadorNode);
                    TrabajadoresNode.appendChild(DNITrabajadorNode);
                    TrabajadoresNode.appendChild(ocupacionTrabajadorNode);
                    //listamos los clientes que pertenece a cada trabajador.
                    for (Clientes ct : t.getListaDeClientes()) {
                        Element ClienteTrabajadorNode = document.createElement("CLIENTESQUEATIENDEELTRABAJADOR");
                        Text oClienteTrabajadorNodeValue = document.createTextNode(ct.getNombre());
                        ClienteTrabajadorNode.appendChild(oClienteTrabajadorNodeValue);

                        //le asignamos el nodo
                        TrabajadoresNode.appendChild(ClienteTrabajadorNode);
                    }

                }
                //Lo añadimos a hoteles.
                HotelNode.appendChild(TrabajadoresNode);
                elementoRaiz.appendChild(HotelNode);
                //con el source generamos el xml
                Source source = new DOMSource(document);
                //le indicamos en que fichero se va a guardar pasandole la ruta por parámetro.
                Result rutaAlmacenFichero = new StreamResult(archivo);
                // lo transformamos y creamos la instancia
                Transformer transfomer = TransformerFactory.newInstance().newTransformer();
                //le pasamos por parametro el xml que generamos y la ruta de almacenaje.
                transfomer.transform(source, rutaAlmacenFichero);
            }

        } catch (IOException ioe) {
            return false;
        } catch (ParserConfigurationException pce) {
            return false;
        }

        return true;
    }
}
