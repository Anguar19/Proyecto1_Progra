/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;

/**
 *
 * @author Frank
 */
public class MaquinaTickets {
    private int contador;
    private char prioridadActual = 'A'; // Prioridad por defecto

    // Constructor de la clase maquina 
    public MaquinaTickets() {
        this.contador = 0;
    }

    // Constructor con contador inicial
    public MaquinaTickets(int contadorInicial) {
        this.contador = contadorInicial;
    }

    // Getters y Setters
    public int getContador() {
        return contador;
    }

    public void setContador(int nuevoContador) {
        this.contador = nuevoContador;
    }

    public char getPrioridadActual() {
        return prioridadActual;
    }

    public void setPrioridadActual(char nuevaPrioridad) {
        this.prioridadActual = nuevaPrioridad;
    }

    // Genera un nuevo ticket para un cliente
    public Ticket generarTicket(Cliente cliente) {
        incrementarContador();
        return new Ticket(contador, prioridadActual, cliente);
    }

    // Incrementa el contador en 1
    public void incrementarContador() {
        contador++;
    }
}