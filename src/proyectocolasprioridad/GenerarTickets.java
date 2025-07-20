/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;

/**
 *
 * @author Frank
 */
public class GenerarTickets {

    public static String generadorTickets(String tipoDeCliente) {
       char prioridad = obtenerPrioridadCliente(tipoDeCliente);
       int numeroAletorio = GenerarAletoriamente.generarNumeroAleatorio(100,999);
       return prioridad + String.valueOf(numeroAletorio);
    }
    
    public static char obtenerPrioridadCliente(String tipoCliente){
        switch(tipoCliente){
            case  "Adulto Mayor":
                return 'A';
             case "Mujer Embarazada/Con Niño":
                return 'B';
            case "Persona Discapacitada":
                return 'C';
            case "Otros Asuntos":
                return 'D';
            case "Plataforma de Servicios":
                return 'E';
            case "Mujer":
                return 'F';
            case "Hombre":
                return 'G';
            default:
                return 'G';
        }
    }

}