/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;

/**
 *
 * @author Anguar Alberto Rodriguez Fonseca
 */
public class Cliente {
    private String nombre;
    private String ticket;
    private boolean atencion;
    private long inicioAtencion;
    private long finAtencion;

 public Cliente(String nombre, Ticket ticket) {
        this.nombre = nombre;
        this.ticket = ticket.getNumeroTicket();
        this.atencion = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public boolean isAtencion() {
        return atencion;
    }

    public void setAtencion(boolean atencion) {
        this.atencion = atencion;
    }

    public long getInicioAtencion() {
        return inicioAtencion;
    }

    public void setInicioAtencion(long inicioAtencion) {
        this.inicioAtencion = inicioAtencion;
    }

    public long getFinAtencion() {
        return finAtencion;
    }

    public void setFinAtencion(long finAtencion) {
        this.finAtencion = finAtencion;
    }
    
    public int getEsperaTiempo() {
    if (inicioAtencion > 0 && finAtencion > 0) {
        long diferencia = finAtencion - inicioAtencion; 
        return (int) (diferencia / (1000 * 60));
    } else {
        return 0;
    }
}

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Ticket: " + ticket + ", Atendido: " + atencion;
}
    
    
}
