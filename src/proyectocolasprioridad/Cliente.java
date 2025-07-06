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
    private int id;
    private int cantidadAsusntos;
    private int tiempoTolerancia;
    private int edad;
    private String nombre;
    private boolean esAdultoMayor;
    private boolean esMujerEmbarazada;
    private boolean tieneNino;
    private boolean tieneDiscapaciadad;
    private boolean requierePlataforma;
    private char genero;
    private char prioridad;

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
