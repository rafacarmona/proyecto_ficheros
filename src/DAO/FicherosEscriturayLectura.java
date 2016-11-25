/**
 * ¡OJO! el Fichero de escritura y lectura debería ir dividido en dos Ficheros diferentes (Fichero Escritura y Fichero Lectura)
 * y deberían heredar de una clase padre que contuviese el ArrayList. Por falta e tiempo y ganas lo hago todo en uno mismo, pero
 * en un futuro debería cambiarlo para que esté requetechupichachi.
 */
package DAO;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import proyecto_sillero.modelo.*;

/**
 * @version 0.1.1
 * @author Rafa
 */
public class FicherosEscriturayLectura {

    private ArrayList<Clientes> listaDeClientes;
    private ArrayList<Trabajador> listaDeTrabajadores;

    /**
     * Constructor Asignando el ArrayList. Declaramos los ArrayList y lo ponemos
     * en el constructor. Los usaremos para guardar los datos y los objetos.
     *
     * @param listaDeClientes
     * @param listaDeTrabajador
     */
    public FicherosEscriturayLectura() {
        listaDeClientes = new ArrayList<Clientes>();
        listaDeTrabajadores = new ArrayList<Trabajador>();
    }

    private static FicherosEscriturayLectura ficherosEscritura = null;

    public static FicherosEscriturayLectura devolverFicherosEscritura() {

        if (ficherosEscritura != null) {
            return ficherosEscritura;
        } else {
            ficherosEscritura = new FicherosEscriturayLectura();
            return ficherosEscritura;
        }
    }

    /**
     * ESCRIBIR FICHERO TXT CLIENTES #rutaPrincipal --> la Carpeta donde se
     * alojaran todos los hoteles. Se llamará por defecto "Hoteles". #subruta
     * --> Carpeta donde se alojan todos los archivos del hotel con el mismo
     * nombre que la carpeta. #archivo --> nombre del archivo, normalmente será
     * Nombre Hotel+Clientes/Trabajadores + la extensión del archivo.
     *
     * @param nombreFichero --> Nombre del Hotel + "Clientes.txt"
     * @param nombreCliente --> El nombre del cliente.
     * @param DNI --> DNI del cliente(ID) no comprobaremos nada de momento.
     * @param nHabitacion --> Numero de habitacion del cliente en el que se
     * alojar.
     * @param nNoches --> Numero de noches que se hospeda en el hotel.
     * @throws IOException
     */
    public void escribirFicheroTxtClientes(String nombreFichero, String nombreCliente,
            String DNI, int nHabitacion, int nNoches) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.txt");
        FileWriter fw;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (archivo.length() > 0) {
            leerFicheroTxtClientes(nombreFichero);
        }
        /**
         * Forma 1: creamos el file writer antes (Arriba, debajo del file
         * archivo, lo declaramos). Luego lo usamos en el printWriter
         */
        fw = new FileWriter(archivo, true);//File Writer, aqui ponemos si es true o false.
        PrintWriter pw = new PrintWriter(fw); //llama a la clase con la que escribiremos en el fichero de texto

        //Aqui escribiremos lo que queremos que escriba (guarde) en el fichero:;
        pw.println(nombreCliente + "|" + DNI + "|" + nHabitacion + "|" + nNoches);
        pw.close(); //Cerramos la clase printWriter
    }

    /**
     * ESCRIBIR FICHERO TXT TRABAJADORES #rutaPrincipal --> la Carpeta donde se
     * alojaran todos los hoteles. Se llamará por defecto "Hoteles". #subruta
     * --> Carpeta donde se alojan todos los archivos del hotel con el mismo
     * nombre que la carpeta. #archivo --> nombre del archivo, normalmente será
     * Nombre Hotel+Clientes/Trabajadores + la extensión del archivo.
     *
     * @param nombreFichero --> nombre del Hotel + "Trabajadores.txt"
     * @param nombreTrabajador --> Nombre del trabajador
     * @param DNI --> DNI del trabajador (ID)
     * @param ocupacion --> Ocupación del trabajador.
     * @throws IOException
     */
    public void escribirFicheroTxtTrabajadores(String nombreFichero, String nombreTrabajador,
            String DNI, String ocupacion, ArrayList<Clientes> listaDClientes) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        String cadenaEscribir;
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.txt");
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (archivo.length() > 0) {
            leerFicheroTxtTrabajadores(nombreFichero);
        }
        /**
         * Forma 2:No creamos el file writer antes. Metemos directamente la ruta
         * y creamos el file Writer dentro del Print Writer.
         */
        PrintWriter pw = new PrintWriter(new FileWriter(archivo, true)); //llama a la clase con la que escribiremos en el fichero de texto
        cadenaEscribir = nombreTrabajador + "|" + DNI + "|" + ocupacion;
        for (Clientes c : listaDClientes) {
            String nombreCliente = c.getNombre();
            cadenaEscribir = cadenaEscribir + "|" + nombreCliente;
        }
        //Aqui escribiremos lo que queremos que escriba (guarde) en el fichero:;
        pw.println(cadenaEscribir);
        pw.close(); //Cerramos la clase printWriter
    }

    /**
     * ESCRIBIR FICHERO DAT(DATOS) CLIENTES #rutaPrincipal --> la Carpeta donde
     * se alojaran todos los hoteles. Se llamará por defecto "Hoteles". #subruta
     * --> Carpeta donde se alojan todos los archivos del hotel con el mismo
     * nombre que la carpeta. #archivo --> nombre del archivo, normalmente será
     * Nombre Hotel+Clientes/Trabajadores + la extensión del archivo.
     *
     * @param nombreFichero --> Nombre del Hotel + "Clientes.txt"
     * @param nombreCliente --> El nombre del cliente.
     * @param DNI --> DNI del cliente(ID) no comprobaremos nada de momento.
     * @param nHabitacion --> Numero de habitacion del cliente en el que se
     * alojar.
     * @param nNoches --> Numero de noches que se hospeda en el hotel.
     * @throws IOException
     */
    public void escribirFicherosDatClientes(String nombreFichero, String nombreCliente,
            String DNI, int nHabitacion, int nNoches) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.dat");
        FileOutputStream fos;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (archivo.length() > 0) {
            leerFicherosDatClientes(nombreFichero);
        }
        /**
         * DataOutputStream guarda como ficheros de datos. llama a la clase con
         * la que escribiremos en un fichero binario.
         */
        fos = new FileOutputStream(archivo, true);
        DataOutputStream dos = new DataOutputStream(fos);
        /**
         * Con .write escribiremos en el fichero, hay que recordar que se tiene
         * que acompañar con el tipo de dato que escribamos, UTF si es String,
         * Int para enteros, etc. Aqui escribiremos lo que queremos que escriba
         * (guarde) en el fichero:
         */
        dos.writeUTF(nombreCliente);
        dos.writeUTF(DNI);
        dos.writeInt(nHabitacion);
        dos.writeInt(nNoches);

        dos.close(); //Cerramos la clase printWriter

    }

    /**
     * ESCRIBIR FICHERO DAT(DATOS) Trabajadores #rutaPrincipal --> la Carpeta
     * donde se alojaran todos los hoteles. Se llamará por defecto "Hoteles".
     * #subruta --> Carpeta donde se alojan todos los archivos del hotel con el
     * mismo nombre que la carpeta. #archivo --> nombre del archivo, normalmente
     * será Nombre Hotel+Clientes/Trabajadores + la extensión del archivo.
     *
     * @param nombreFichero --> nombre del Hotel + "Trabajadores.txt"
     * @param nombreTrabajador --> Nombre del trabajador
     * @param DNI --> DNI del trabajador (ID)
     * @param ocupacion --> Ocupación del trabajador.
     * @throws IOException
     */
    public void escribirFicherosDatTrabajadores(String nombreFichero, String nombreTrabajador,
            String DNI, String ocupacion, ArrayList<Clientes> listaDClientes) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.dat");
        FileOutputStream fos;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (archivo.length() > 0) {
            leerFicherosDatTrabajadores(nombreFichero);
        }
        /**
         * DataOutputStream guarda como ficheros de datos. llama a la clase con
         * la que escribiremos en un fichero binario.
         */
        fos = new FileOutputStream(archivo, true);
        DataOutputStream dos = new DataOutputStream(fos);
        /**
         * Con .write escribiremos en el fichero, hay que recordar que se tiene
         * que acompañar con el tipo de dato que escribamos, UTF si es String,
         * Int para enteros, etc. Aqui escribiremos lo que queremos que escriba
         * (guarde) en el fichero:
         */
        for (Trabajador t : listaDeTrabajadores) {
            dos.writeUTF(nombreTrabajador);
            dos.writeUTF(DNI);
            dos.writeUTF(ocupacion);
            dos.writeInt(t.getListaDeClientes().size());
                for(Clientes c: listaDClientes){
                       dos.writeUTF(c.getNombre());
                }
        }
        dos.close(); //Cerramos la clase printWriter    
    }

    /**
     * ESCRIBIR EN OBJ (OBJETOS) CLIENTE #rutaPrincipal --> la Carpeta donde se
     * alojaran todos los hoteles. Se llamará por defecto "Hoteles". #subruta
     * --> Carpeta donde se alojan todos los archivos del hotel con el mismo
     * nombre que la carpeta. #archivo --> nombre del archivo, normalmente será
     * Nombre Hotel+Clientes/Trabajadores + la extensión del archivo.
     *
     * @param nombreFichero --> Nombre del Hotel + "Clientes.txt"
     * @param nombreCliente --> El nombre del cliente.
     * @param DNI --> DNI del cliente(ID) no comprobaremos nada de momento.
     * @param nHabitacion --> Numero de habitacion del cliente en el que se
     * alojar.
     * @param nNoches --> Numero de noches que se hospeda en el hotel.
     * @throws IOException
     */
    public void escribirFicherosObjClientes(String nombreFichero, String nombreCliente,
            String DNI, int nHabitacion, int nNoches) throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.obj");
        FileOutputStream fos;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (archivo.length() > 0) {
            leerFicherosObjClientes(nombreFichero);
        }
        /**
         * ObjectOutputStream llama a la clase con la que escribiremos un objeto
         * en un fichero. Con writeObject escribimos el objeto. Lee el Fichero
         * antes de escribir en el para que no sobreescriba.
         */
        fos = new FileOutputStream(archivo, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /**
         * Escribimos el ArrayList dentro del fichero. Si no existe la
         * listaDeClientes se crea. se pasan por parametros los atributos y se
         * crea la clase.
         */

        if (listaDeClientes == null) {
            listaDeClientes = new ArrayList<Clientes>();
        }
        listaDeClientes.add(new Clientes(nombreCliente, DNI, nHabitacion, nNoches));
        oos.writeObject(listaDeClientes);
        /**
         * for (Clientes c: listaDeClientes) { oos.writeObject(listaDeClientes);
         * }
         *
         */
        oos.close();
    }

    /**
     * ESCRIBIR EN OBJ (OBJETOS) Trabajadores #rutaPrincipal --> la Carpeta
     * donde se alojaran todos los hoteles. Se llamará por defecto "Hoteles".
     * #subruta --> Carpeta donde se alojan todos los archivos del hotel con el
     * mismo nombre que la carpeta. #archivo --> nombre del archivo, normalmente
     * será Nombre Hotel+Clientes/Trabajadores + la extensión del archivo.
     *
     * @param nombreFichero --> nombre del Hotel + "Trabajadores.txt"
     * @param nombreTrabajador --> Nombre del trabajador
     * @param DNI --> DNI del trabajador (ID)
     * @param ocupacion --> Ocupación del trabajador.
     * @throws IOException
     */
    public void escribirFicherosObjTrabajadores(String nombreFichero, String nombreTrabajador,
            String DNI, String ocupacion, ArrayList<Clientes> listaDClienteses) throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.obj");
        FileOutputStream fos;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (archivo.length() > 0) {
            leerFicherosObjTrabajadores(nombreFichero);
        }
        /**
         * ObjectOutputStream llama a la clase con la que escribiremos un objeto
         * en un fichero. Con writeObject escribimos el objeto. Lee el Fichero
         * antes de escribir en el para que no sobreescriba.
         */
        fos = new FileOutputStream(archivo, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /**
         * Escribimos el ArrayList dentro del fichero. Si no existe la
         * listaDeTrabajadores se crea. se pasan por parametros los atributos y
         * se crea la clase.
         */

        if (listaDeTrabajadores == null) {
            listaDeTrabajadores = new ArrayList<Trabajador>();
        }
        listaDeTrabajadores.add(new Trabajador(nombreTrabajador, DNI, ocupacion, listaDClienteses));

        for (Trabajador c : listaDeTrabajadores) {
            oos.writeObject(listaDeTrabajadores);
        }

        oos.close();
    }

    /**
     * #rutaPrincipal --> La ruta principal donde se guardan todos los Hoteles.
     * Ésta almacena todos los directorios de los hoteles. #subrtua --> La
     * subruta, donde se creará el directorio con el nombre de hotel que hemos
     * especificado.
     *
     * @param nombreHotel --> éste será el nombre del hotel, es decir, del
     * directorio.
     */
    public void crearDirectorio(String nombreHotel) {
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreHotel);

        if (!rutaPrincipal.exists() && !subruta.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else if (!subruta.exists()) {
            subruta.mkdir();
        }
    }

    /**
     * El metodo devuelve, básicamente, una Array de String de todos los hoteles
     * que hay. Con el isDirectory filtramos los directorios. #rutaPrincipal -->
     * es la ruta donde se encuentra el Directorio "Hoteles"(el directorio
     * principal) donde se alamacenan todos los otros hoteles.
     * #listaDeDirectorios --> es un array que contiene todos los directorios y
     * ficheros que se encuentra dentro de la ruta principal.
     * #contadorDeDirectorios --> contador que almacena el numero de directorios
     * que hay. #listaDeHoteles --> listaTodosLosHoteles.
     *
     * @return devuelve un array de String que contiene todos los nombres de los
     * hoteles.
     */
    public String[] leerDirectorio() {
        File rutaPrincipal = new File("./Hoteles");

        File[] listaDeDirectorios = rutaPrincipal.listFiles();
        int contadorDeDirectorios = 0;
        String[] listaDeHoteles;
        for (int z = 0; z < listaDeDirectorios.length; z++) {
            if (listaDeDirectorios[z].isDirectory()) {
                contadorDeDirectorios++;
            }
        }
        listaDeHoteles = new String[contadorDeDirectorios];
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
        }
        for (int i = 0; i < listaDeDirectorios.length; i++) {
            if (listaDeDirectorios[i].isDirectory()) {
                listaDeHoteles[i] = listaDeDirectorios[i].getName();
            }
        }

        return listaDeHoteles;
    }

    public void crearDirectorioPrincipal() {
        File rutaPrincipal = new File("./Hoteles");
        rutaPrincipal.mkdir();
    }

    /**
     * #rutaPrincipal --> la ruta donde están todos los hoteles. #subruta -->
     * nombredelFichero(Ya debería estar creado)
     *
     * @param nombreFichero --> nombreFichero al leer.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void leerFicherosObjClientes(String nombreFichero) throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.obj");
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * ObjectInputStream llama a la clase con la que leemos un objeto en un
         * fichero. Con writeObject escribimos el objeto.
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));

        //probar el removeAll
        listaDeClientes.removeAll(listaDeClientes);
        listaDeClientes = (ArrayList< Clientes>) ois.readObject();
        ois.close();
    }

    /**
     *
     * @param nombreFichero
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void leerFicherosObjTrabajadores(String nombreFichero) throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.obj");
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * ObjectInputStream llama a la clase con la que leemos un objeto en un
         * fichero. Con writeObject escribimos el objeto.
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
        //probar el removeAll
        listaDeTrabajadores.removeAll(listaDeTrabajadores);
        listaDeTrabajadores = (ArrayList< Trabajador>) ois.readObject();
        ois.close();
    }

    /**
     *
     * @param nombreFichero
     * @throws IOException
     */
    public void leerFicheroTxtClientes(String nombreFichero) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.txt");
        FileReader fr;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        //Aqui escribiremos lo que queremos que lea el fichero.
        //listaDeClientes.removeAll(listaDeClientes);
        String cadenaClientes = br.readLine();
        listaDeClientes.removeAll(listaDeClientes);
        while (cadenaClientes != null) {
            // guardamos cada dato del cliente en un array.
            String[] arrayDatosClientes = cadenaClientes.split("\\|");
            Clientes a = new Clientes(arrayDatosClientes[0], arrayDatosClientes[1], Integer.parseInt(arrayDatosClientes[2]), Integer.parseInt(arrayDatosClientes[3]));
            //lo añadimos

            listaDeClientes.add(a);
            cadenaClientes = br.readLine();
        }

        br.close();
    }

    /**
     *
     * @param nombreFichero
     * @throws IOException
     */
    public void leerFicheroTxtTrabajadores(String nombreFichero) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.txt");
        FileReader fr;

        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        //Aqui escribiremos lo que queremos que lea el fichero.
        listaDeTrabajadores.removeAll(listaDeTrabajadores);
        String cadenaTrabajadores = br.readLine();
        while (cadenaTrabajadores != null) {
            // guardamos cada dato del cliente en un array.
            String[] arrayDatosTrabajadores = cadenaTrabajadores.split("\\|");
            ArrayList<Clientes> listaDClientesEnTrabajadores = new ArrayList<Clientes>();
            for(int i = 3; i<arrayDatosTrabajadores.length; i++){
                for(Clientes c: getListaDeClientes()){
                  if(arrayDatosTrabajadores[i].equals(c.getNombre())){
                      listaDClientesEnTrabajadores.add(c);
                  }  
                }
            }
            Trabajador a = new Trabajador(arrayDatosTrabajadores[0], arrayDatosTrabajadores[1], arrayDatosTrabajadores[2], listaDClientesEnTrabajadores);
            //lo añadimos
            listaDeTrabajadores.add(a);
            cadenaTrabajadores = br.readLine();
        }
        br.close();
    }

    /**
     *
     * @param nombreFichero
     * @throws IOException
     */
    public void leerFicherosDatClientes(String nombreFichero) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        //Creamos flag
        boolean flag = false;
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.dat");
        FileInputStream fis;
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * DataInputStream lee como ficheros de datos. llama a la clase con la
         * que escribiremos en un fichero binario.
         */
        fis = new FileInputStream(archivo);
        DataInputStream dis = new DataInputStream(fis);
        listaDeClientes.removeAll(listaDeClientes);
        do {
            try {
                String nombreCliente = dis.readUTF();
                String DNI = dis.readUTF();
                int nHabitacion = dis.readInt();
                int nNoches = dis.readInt();

                Clientes c = new Clientes(nombreCliente, DNI, nHabitacion, nNoches);
                listaDeClientes.add(c);

            } catch (EOFException e) {
                flag = true;
            }

        } while (!flag);
        dis.close();

    }

    /**
     *
     * @param nombreFichero
     * @throws IOException
     */
    public void leerFicherosDatTrabajadores(String nombreFichero) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        //Creamos flag
        boolean flag = false;
        //creamos arraylist
        ArrayList<Clientes> listaDClientes = new ArrayList<Clientes>();
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Trabajadores.dat");
        FileInputStream fis;
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * DataInputStream lee como ficheros de datos. llama a la clase con la
         * que escribiremos en un fichero binario.
         */
        fis = new FileInputStream(archivo);
        DataInputStream dis = new DataInputStream(fis);
         listaDeClientes.removeAll(listaDeTrabajadores);
        do {
            try {
                String nombreTrabajador = dis.readUTF();
                String DNI = dis.readUTF();
                String ocupacion = dis.readUTF();
                int numeroDeClientesEnTrabajadores= dis.readInt();
                ArrayList<Clientes> listaDClientesEnTrabajadores = new ArrayList<Clientes>();
            for(int i = 0; i<numeroDeClientesEnTrabajadores; i++){
                for(Clientes c: getListaDeClientes()){
                  if(dis.readUTF().equals(c.getNombre())){
                      listaDClientesEnTrabajadores.add(c);
                  }  
                }
            }
              
                Trabajador t = new Trabajador(nombreTrabajador, DNI, ocupacion, listaDClientesEnTrabajadores);
                listaDeTrabajadores.add(t);

            } catch (EOFException e) {
                flag = true;
            }

        } while (!flag);
        dis.close();

    }

    public ArrayList<Clientes> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(ArrayList<Clientes> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public ArrayList<Trabajador> getListaDeTrabajadores() {
        return listaDeTrabajadores;
    }

    public void setListaDeTrabajadores(ArrayList<Trabajador> listaDeTrabajadores) {
        this.listaDeTrabajadores = listaDeTrabajadores;
    }

}
