/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Anguar Alberto Rodriguez Fonseca
 */
public class Cliente {

    private int id;//Varaible id
    private int cantidadAsusntos;// Variable cantidadAsusntos
    private int tiempoTolerancia;// Variable tiempoTolerancia
    private int edad;// Variable edad
    private String nombre;// Variable nombre
    private boolean esAdultoMayor;// Variable esAdultoMayor
    private boolean esMujerEmbarazada;// Variable esMujerEmbarazada
    private boolean tieneNino;// Variable tieneNino
    private boolean tieneDiscapaciadad;// Variable tieneDiscapacidad
    private boolean requierePlataforma;// Variable requierePlataforma
    private char genero;// Variable genero
    private char prioridad;// Variable prioridad

    /**
     * Metodo constructor
     * @param id
     * El id del cliente
     * @param cantidadAsusntos
     * Los asuntos que se realizaran
     * @param tiempoTolerancia
     * El tiempo de entrada y de salida
     * @param edad
     * La edad del cliente
     * @param nombre
     * El nombre del cliente
     * @param esAdultoMayor
     * Si el cliente es una persona adulta mayor
     * @param esMujerEmbarazada
     * Si la cliente esta embarazada
     * @param tieneNino
     * Si el cliente tiene un nino en brazos
     * @param tieneDiscapaciadad
     * Si el cliente cuenta con alguna discapacidad
     * @param requierePlataforma
     * Si se requiere el uso de una plataforma
     * @param genero
     * El genero del cliente si es hombre o mujer
     * @param prioridad 
     * Si el cliente cuenta con una prioridad de atencion alta.
     */
    
    public Cliente(int id, int cantidadAsusntos, int tiempoTolerancia, int edad, String nombre, boolean esAdultoMayor, boolean esMujerEmbarazada, boolean tieneNino, boolean tieneDiscapaciadad, boolean requierePlataforma, char genero, char prioridad) {
        this.id = id;
        this.cantidadAsusntos = cantidadAsusntos;
        this.tiempoTolerancia = tiempoTolerancia;
        this.edad = edad;
        this.nombre = nombre;
        this.esAdultoMayor = esAdultoMayor;
        this.esMujerEmbarazada = esMujerEmbarazada;
        this.tieneNino = tieneNino;
        this.tieneDiscapaciadad = tieneDiscapaciadad;
        this.requierePlataforma = requierePlataforma;
        this.genero = genero;
        this.prioridad = prioridad;
    }

    /**
     * Obtener la informacion
     * @return 
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadAsusntos() {
        return cantidadAsusntos;
    }

    public void setCantidadAsusntos(int cantidadAsusntos) {
        this.cantidadAsusntos = cantidadAsusntos;
    }

    public int getTiempoTolerancia() {
        return tiempoTolerancia;
    }

    public void setTiempoTolerancia(int tiempoTolerancia) {
        this.tiempoTolerancia = tiempoTolerancia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsAdultoMayor() {
        return esAdultoMayor;
    }

    public void setEsAdultoMayor(boolean esAdultoMayor) {
        this.esAdultoMayor = esAdultoMayor;
    }

    public boolean isEsMujerEmbarazada() {
        return esMujerEmbarazada;
    }

    public void setEsMujerEmbarazada(boolean esMujerEmbarazada) {
        this.esMujerEmbarazada = esMujerEmbarazada;
    }

    public boolean isTieneNino() {
        return tieneNino;
    }

    public void setTieneNino(boolean tieneNino) {
        this.tieneNino = tieneNino;
    }

    public boolean isTieneDiscapaciadad() {
        return tieneDiscapaciadad;
    }

    public void setTieneDiscapaciadad(boolean tieneDiscapaciadad) {
        this.tieneDiscapaciadad = tieneDiscapaciadad;
    }

    public boolean isRequierePlataforma() {
        return requierePlataforma;
    }

    public void setRequierePlataforma(boolean requierePlataforma) {
        this.requierePlataforma = requierePlataforma;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public char getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(char prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cantidadAsusntos=" + cantidadAsusntos + ", tiempoTolerancia=" + tiempoTolerancia + ", edad=" + edad + ", nombre=" + nombre + ", esAdultoMayor=" + esAdultoMayor + ", esMujerEmbarazada=" + esMujerEmbarazada + ", tieneNino=" + tieneNino + ", tieneDiscapaciadad=" + tieneDiscapaciadad + ", requierePlataforma=" + requierePlataforma + ", genero=" + genero + ", prioridad=" + prioridad + '}';
    }
    
    
}
