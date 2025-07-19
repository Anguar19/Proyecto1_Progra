/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.ArrayList;
/**
 *
 * @author Anguar Alberto Rodriguez Fonseca
 */
public class PrioridadDeCola {
        private ArrayList<Ticket> cola;
    private int capacidadMaxima;
    private int clientesTotales;

    public PrioridadDeCola(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cola = new ArrayList<Ticket>();
        this.clientesTotales = 0;
    }

    public boolean agregarTicket(Ticket ticket) {
        if (cola.size() >= capacidadMaxima) {
            return false;
        }
        int i = 0;
        while (i < cola.size() && comparar(ticket, cola.get(i)) >= 0) {
            i++;
        }
        cola.add(i, ticket);
        clientesTotales++;
        return true;
    }
    public Ticket obtenerSiguienteTicket() {
        if (cola.size() > 0) {
            return cola.remove(0);
        }
        return null;
    }
    public Ticket obtenerSiguienteTicketParaPlataforma() {
        for (int i = 0; i < cola.size(); i++) {
            Ticket t = cola.get(i);
            if (t.getPrioridadCliente() == 'E') {
                cola.remove(i);
                return t;
            }
        }
        return null;
    }

    public int getTamaño() {
        return cola.size();
    }

    public int getClientesTotales() {
        return clientesTotales;
    }

    public ArrayList<Ticket> obtenerTicketsExpirados() {
        ArrayList<Ticket> expirados = new ArrayList<Ticket>();

        for (int i = 0; i < cola.size(); i++) {
            Ticket t = cola.get(i);
            if (t.haExpirado()) {
                expirados.add(t);
                cola.remove(i);
                i--; 
            }
        }

        return expirados;
    }

    public ArrayList<Ticket> obtenerTicketsEnCola() {
        return new ArrayList<Ticket>(cola); 
    }

    private int comparar(Ticket t1, Ticket t2) {
        char p1 = t1.getPrioridadCliente();
        char p2 = t2.getPrioridadCliente();

        if (p1 == p2) {
            long tiempo1 = t1.getGeneracionTicket();
            long tiempo2 = t2.getGeneracionTicket();

            if (tiempo1 < tiempo2) return -1;
            else if (tiempo1 > tiempo2) return 1;
            else return 0;
        }

        if (p1 < p2) return -1;
        else return 1;
    }
}
