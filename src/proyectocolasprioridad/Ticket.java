/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;

/**
 *
 * @author Franklin Castillo Umaña
 */


public class Ticket {
    private String numeroTicket;
    private String nombreCliente;
    public char prioridadCliente;
    private long GeneracionTicket;
    private int tolerancia;
    private int tiempoDelTramite;

    public Ticket(String numeroTicket, String nombreCliente, char prioridadCliente, long GeneracionTicket, int tolerancia, int tiempoDelTramite) {
        this.numeroTicket = numeroTicket;
        this.nombreCliente = nombreCliente;
        this.prioridadCliente = prioridadCliente;
        this.GeneracionTicket = GeneracionTicket;
        this.tolerancia = tolerancia;
        this.tiempoDelTramite = tiempoDelTramite;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public char getPrioridadCliente() {
        return prioridadCliente;
    }

    public void setPrioridadCliente(char prioridadCliente) {
        this.prioridadCliente = prioridadCliente;
    }

    public long getGeneracionTicket() {
        return GeneracionTicket;
    }

    public void setGeneracionTicket(long GeneracionTicket) {
        this.GeneracionTicket = GeneracionTicket;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }

    public int getTiempoDelTramite() {
        return tiempoDelTramite;
    }

    public void setTiempoDelTramite(int tiempoDelTramite) {
        this.tiempoDelTramite = tiempoDelTramite;
    }
    
    public boolean haExpirado() {
        long tiempoTranscurrido = (System.currentTimeMillis() - GeneracionTicket) / (100 * 60);
        return tiempoTranscurrido >= tolerancia;
    }

    @Override
    public String toString() {
        return "Ticket{" + "numeroTicket=" + numeroTicket + ", nombreCliente=" + nombreCliente + ", prioridadCliente=" + prioridadCliente + ", GeneracionTicket=" + GeneracionTicket + ", tolerancia=" + tolerancia + ", tiempoDelTramite=" + tiempoDelTramite + '}';
    }
    
    
}