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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /*
    SINGLETON.
     */
    private static EscrituraYLecturaFicheroXML escrituraYLecturaXML = null;

    public static EscrituraYLecturaFicheroXML devolverFicherosEscrituraXML() {

        if (escrituraYLecturaXML != null) {
            return escrituraYLecturaXML;
        } else {
            escrituraYLecturaXML = new EscrituraYLecturaFicheroXML();
            return escrituraYLecturaXML;
        }
    }

  
    /*
    Fin Singleton
     */
    //ESCRIBIR
    /**
     *
     * @param nombreFichero
     * @return true si no salta ninguna excepcion, false salta.
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
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
            //Crea la factory.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Crea el documento.
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Implementamos el DOM
            DOMImplementation implementation = builder.getDOMImplementation();
            //Creamos el Documento con los parametros (buscar para que sirve cada uno)
            Document document = implementation.createDocument(null, "HOTELES", null);
            //le decimos que versión de xml es.
            document.setXmlVersion("1.0");
            
            if(archivo.length() > 0){
                try {
                    leerFicheroClientesXML(nombreFichero);
                } catch (SAXException ex) {
                    System.out.println(ex);
                }
            }
            //Definimos el elemento Raíz.
            Element elementoRaiz = document.getDocumentElement();
            //Definimos La primera etiqueta, que es Hoteles.
            Element HotelesNode = document.createElement("HOTELES");
            //hacemos que recorra todos los hoteles, cada elemento de leerDirectorio es un Hotel.
            for (int i = 0; i < FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio().length; i++) {
                //Hacemos que el nombre Del hotel sea el del fichero.
                Element HotelNode = document.createElement("HOTEL");
                Text nombreHotelValue = document.createTextNode(FicherosEscriturayLectura.devolverFicherosEscritura().leerDirectorio()[i]);
                HotelNode.appendChild(nombreHotelValue);
                //Ahora creamos todos los elementos de los Clientes.
                Element ClientesNode = document.createElement("CLIENTES");
                for (Clientes c : FicherosEscriturayLectura.devolverFicherosEscritura().getListaDeClientes()) {
                    Element Cliente = document.createElement("CLIENTE");
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
                    //Lo metemos en el node.
                    ClientesNode.appendChild(NombreClienteNode);
                    ClientesNode.appendChild(DNIClienteNode);
                    ClientesNode.appendChild(nHabitacionClienteNode);
                    ClientesNode.appendChild(nNochesClienteNode);
                }
                //lo añadimos a Hoteles
                HotelNode.appendChild(ClientesNode);
                //Añadimos el hotel al elemento raiz
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

    /**
     *
     * @param nombreFichero
     * @return true si no hay ningun error, false si hay error.
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
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
    //FIN ESCRITURA XML
    //LECTURA DEL XML

    public boolean leerFicheroClientesXML(String nombreFichero) throws ParserConfigurationException, SAXException, IOException {
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.xml");
        if (!archivo.exists()) {
            System.out.println("Fichero No existente");
            return false;
        }
        //inicializamos el arraylist.
        ArrayList<Clientes> listaDeClientesXML = new ArrayList<Clientes>();

        //Cargamos el archivo xml-
        DocumentBuilderFactory cargarArchivoFactory = DocumentBuilderFactory.newInstance();
        //instanciamos
        DocumentBuilder db = cargarArchivoFactory.newDocumentBuilder();
        //parseamos el documento
        Document document = db.parse(archivo);
        //Lo normalizamos
        document.getDocumentElement().normalize();
        //Ahora vamos a crear una lista de los nodos donde almacenaremos todos los clientes.
        NodeList listaDeClientes = document.getDocumentElement().getElementsByTagName("CLIENTES");
        //Inicializamos el nodo donde almacenaremos los items de cada cliente.
        Node nodoClientes;
        for (int i = 0; i < listaDeClientes.getLength(); i++) {
            nodoClientes = listaDeClientes.item(i);
            NodeList NodeListClientes = nodoClientes.getChildNodes();
            Node atributosClientes;
            //Atributos del cliente
            // Se tienen que inicializar.
            String dni = null;
            String nombre = null;
            int nHabitacion = 0;
            int nNoches = 0;

            for (int j = 0; j < NodeListClientes.getLength(); j++) {
                atributosClientes = NodeListClientes.item(j);
                if (atributosClientes.getNodeName().equals("NOMBRECLIENTE")) {
                    nombre = atributosClientes.getTextContent();
                }
                if (atributosClientes.getNodeName().equals("DNICLIENTE")) {
                    dni = atributosClientes.getTextContent();
                }
                if (atributosClientes.getNodeName().equals("NHABITACIONCLIENTE")) {
                    nHabitacion = Integer.parseInt(atributosClientes.getTextContent());
                }
                if (atributosClientes.getNodeName().equals("NNOCHES")) {
                    nNoches = Integer.parseInt(atributosClientes.getTextContent());
                }

            }
            listaDeClientesXML.add(new Clientes(nombre, dni, nHabitacion, nNoches));
            
        }
        FicherosEscriturayLectura.devolverFicherosEscritura().setListaDeClientes(listaDeClientesXML);
        return true;
    }
/*
    public boolean leerFicheroTrabajadoresXML(String nombreFichero) throws ParserConfigurationException, SAXException, IOException {
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.xml");
        if (!archivo.exists()) {
            System.out.println("Fichero No existente");
            return false;
        }
        //inicializamos el arraylist.
        ArrayList<Trabajador> listaDeTrabajadoresXML = new ArrayList<Trabajador>();
        ArrayList<Clientes> listaDeClientesXML = new ArrayList<Clientes>();
        //Cargamos el archivo xml
        DocumentBuilderFactory cargarArchivoFactory = DocumentBuilderFactory.newInstance();
        //instanciamos
        DocumentBuilder db = cargarArchivoFactory.newDocumentBuilder();
        //parseamos el documento
        Document document = db.parse(archivo);
        //Lo normalizamos
        document.getDocumentElement().normalize();
        //Ahora vamos a crear una lista de los nodos donde almacenaremos todos los Trabajadores.
        NodeList listaDeTrabajadores = document.getDocumentElement().getElementsByTagName("TRABAJADORES");
        //Inicializamos el nodo donde almacenaremos los items de cada cliente.
        Node nodoTrabajadores;
        for (int i = 0; i < listaDeTrabajadores.getLength(); i++) {
            nodoTrabajadores = listaDeTrabajadores.item(i);
            NodeList NodeListTrabajadores = nodoTrabajadores.getChildNodes();
            Node atributosTrabajadores;
            //Atributos de los Trabajadores.
            // Se tienen que inicializar.
            String dni = null;
            String nombre = null;
            String ocupacion = null;

            for (int j = 0; j < NodeListTrabajadores.getLength(); j++) {
                atributosTrabajadores = NodeListTrabajadores.item(j);
                if (atributosTrabajadores.getNodeName().equals("NOMBRETRABAJADOR")) {
                    nombre = atributosTrabajadores.getTextContent();
                }
                if (atributosTrabajadores.getNodeName().equals("DNITRABAJADOR")) {
                    dni = atributosTrabajadores.getTextContent();
                }
                if (atributosTrabajadores.getNodeName().equals("OCUPACIONTRABAJADOR")) {
                    nombre = atributosTrabajadores.getTextContent();
                }
                if (atributosTrabajadores.getNodeName().equals("CLIENTESQUEATIENDEELTRABAJADOR")) {
                    NodeList NodeListClientesEnTrabajadores = atributosTrabajadores.getChildNodes();
                    Node clientesEnTrabajadoresNode;
                    for (int k = 0; k < NodeListClientesEnTrabajadores.getLength(); k++) {
                        clientesEnTrabajadoresNode = NodeListClientesEnTrabajadores.item(k);
                        if (clientesEnTrabajadoresNode.getNodeName().equals("CLIENTESQUEATIENDEELTRABAJADOR")) {
                            NodeList listaNodoArt = clientesEnTrabajadoresNode.getChildNodes();
                            Node nodoArt;
                            String nombreArt = null, descripcionArt = null;
                            int idArt = 0;
                            double precio = 0;
                            for (int l = 0; l < listaNodoArt.getLength(); l++) {
                                nodoArt = listaNodoArt.item(l);
                                NodeList atributosArt = nodoArt.getChildNodes();
                                Node atribArt;
                            }
                            arrayArticulos.add(new Articulo(idArt, id, nombre, descripcionArt, precio));

                        }
                    }

                }
                listaDeTrabajadoresXML.add(new Trabajador(nombre, dni, ocupacion));

            }

            
        }
    return true;
    }
    */
    }
