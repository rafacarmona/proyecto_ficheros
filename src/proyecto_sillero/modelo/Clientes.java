/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.modelo;

import java.io.Serializable;

/**
 *
 * @author Rafa
 */
public class Clientes implements Serializable{
    /**
     * nombre=nombre del cliente
     * DNI es el dni del cliente (no tiene por que calcularse en este ejemplo)
     * NHabitacion es el numero de habitacion que ocupa el cliente
     * NNoches es el numero de noches que ocupa el cliente
     */
    private String nombre;
    private String DNI;
    private int NHabitacion;
    private int NNoches;

    public Clientes(String nombre, String DNI, int NHabitacion, int NNoches) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.NHabitacion = NHabitacion;
        this.NNoches = NNoches;
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

    public int getNHabitacion() {
        return NHabitacion;
    }

    public void setNHabitacion(int NHabitacion) {
        this.NHabitacion = NHabitacion;
    }

    public int getNNoches() {
        return NNoches;
    }

    public void setNNoches(int NNoches) {
        this.NNoches = NNoches;
    }
    
    @Override
    public String toString() {
        return getNHabitacion()+"";
    }
 

    
    
}
