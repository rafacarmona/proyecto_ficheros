/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rafa
 */
public class Trabajador implements Serializable{
    /**
     * Definimos los atributos de la clase.
     * nombre es el nombre del trabajador (nombre + Apellidos)
     * DNI es el dni del usuario. (en este ejemplo no es necesario )
     * ocupacion es la ocupacion que ocupa el trabajador. 
     */
   private String nombre;
   private String DNI;
   private String ocupacion;
  // private ArrayList<Clientes> listaDeClientes;

    public Trabajador(String nombre, String DNI, String ocupacion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.ocupacion = ocupacion;
//        this.listaDeClientes = listaDeClientes;
    }

    public Trabajador(ArrayList<Clientes> listaDeClientes) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
   
}
