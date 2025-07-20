/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.Comparator;
/**
 *
 * @author Frank
 */
public class SeleccionPrioridad  implements Comparator<Ticket>{
    public int compare(Ticket t1, Ticket t2) {
        char prioridad1 = t1.getPrioridadCliente();
        char prioridad2 = t2.getPrioridadCliente();

        if (prioridad1 == prioridad2) {
            long tiempo1 = t1.getGeneracionTicket();
            long tiempo2 = t2.getGeneracionTicket();

            if (tiempo1 < tiempo2) {
                return -1;
            } else if (tiempo1 > tiempo2) {
                return 1;
            } else {
                return 0;
            }
        }

        
        if (prioridad1 < prioridad2) {
            return -1;
        } else {
            return 1;
        }
    }
}
