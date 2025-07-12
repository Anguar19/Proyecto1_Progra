/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;

/**
 *
 * @author Franklin Castillo Umaña
 */
import java.time.LocalDateTime;

public class Ticket {
    private int numero;
    private char letraPrioridad;
    private LocalDateTime horaGeneracion;
    private Cliente clienteAsociado;

    // Constructor
    public Ticket(int numero, char letraPrioridad, Cliente clienteAsociado) {
        this.numero = numero;
        this.letraPrioridad = letraPrioridad;
        this.horaGeneracion = LocalDateTime.now();
        this.clienteAsociado = clienteAsociado;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public char getLetraPrioridad() {
        return letraPrioridad;
    }

    public LocalDateTime getHoraGeneracion() {
        return horaGeneracion;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLetraPrioridad(char letraPrioridad) {
        this.letraPrioridad = letraPrioridad;
    }

    public void setHoraGeneracion(LocalDateTime horaGeneracion) {
        this.horaGeneracion = horaGeneracion;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    // Métodos para mostrar el ticket( cambiable a un jOpcion)
    public void imprimirTicket() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return " TICKET\n" +
               "Número: " + numero + "\n" +
               "Prioridad: " + letraPrioridad + "\n" +
               "Hora generación: " + horaGeneracion + "\n" +
               "Cliente: " + clienteAsociado.getNombre() + "\n" ;
               
    }
}
