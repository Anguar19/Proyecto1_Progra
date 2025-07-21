/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Frank
 */
public class BancoSistema {
    PrioridadDeCola cola;
    List<CajeroBanco> cajeros;
    CajeroBanco plataformaServicios;
    BancoDatosEstadisticas estadisticas;

    public BancoSistema() {
        cola = new PrioridadDeCola(25);
        cajeros = new ArrayList<CajeroBanco>();
        estadisticas = new BancoDatosEstadisticas();

        for (int i = 1; i <= 5; i++) {
            cajeros.add(new CajeroBanco("Caja " + i));
        }

        plataformaServicios = new CajeroBanco("Plataforma de Servicios");
    }

     public Ticket generarTicket(String nombre, String tipoCliente) {
        String numero = GenerarTickets.generadorTickets(tipoCliente);
        char prioridad = numero.charAt(0);
        Ticket ticket = new Ticket(numero, nombre, prioridad, System.currentTimeMillis(),
                GenerarAletoriamente.Tolerancia(), GenerarAletoriamente.inicarTramite());

        if (cola.agregarTicket(ticket)) {
            estadisticas.registroIngresoCliente();
            return ticket;
        }
        return null;
    }

   public String atenderCliente(String nombreCaja) {
        List<Ticket> expirados = cola.obtenerTicketsExpirados();
        for (int i = 0; i < expirados.size(); i++) {
            Ticket t = expirados.get(i);
            Cliente cliente = new Cliente(t.getNombreCliente(), t);
            estadisticas.registroClientesPorAtender(cliente);
        }

        if (nombreCaja.equals("Plataforma de Servicios")) {
            return atenderEnPlataforma();
        } else {
            return atenderEnCajaNormal(nombreCaja);
        }
    }

    private String atenderEnPlataforma() {
        if (!plataformaServicios.isDisponibilidad()) {
            return "La Plataforma de Servicios está ocupada";
        }

        Ticket t = cola.obtenerSiguienteTicketParaPlataforma();
        if (t == null) {
            return "No hay clientes con prioridad E en la fila";
        }

        Cliente c = new Cliente(t.getNombreCliente(), t);
        plataformaServicios.atencionCliente(c);
        plataformaServicios.finAtencion();
        estadisticas.registroClientesAtendidos(c);

        return "Cliente atendido en Plataforma de Servicios: " + t.toString();
    }

    private String atenderEnCajaNormal(String nombreCaja) {
        CajeroBanco cajeroEncontrado = null;

        for (int i = 0; i < cajeros.size(); i++) {
            if (cajeros.get(i).getNombre().equals(nombreCaja)) {
                cajeroEncontrado = cajeros.get(i);
                break;
            }
        }

        if (cajeroEncontrado == null) {
            return "Caja no encontrada";
        }

        if (!cajeroEncontrado.isDisponibilidad()) {
            return "La " + nombreCaja + " está ocupada";
        }

        Ticket t = cola.obtenerSiguienteTicket();
        if (t == null) {
            return "No hay clientes en la fila";
        }

        if (t.getPrioridadCliente() == 'E') {
            return "Este cliente debe ser atendido en Plataforma de Servicios";
        }

        Cliente c = new Cliente(t.getNombreCliente(), t);
        cajeroEncontrado.atencionCliente(c);
        cajeroEncontrado.finAtencion();
        estadisticas.registroClientesAtendidos(c);

        return "Cliente atendido en " + nombreCaja + ": " + t.toString();
    }

    public String obtenerEstadoColas() {
    String texto = "=== ESTADO DE COLAS ===\n\n";
    texto += "Clientes en fila: " + cola.getTamaño() + "/25\n\n";

    texto += "Estado de Cajeros:\n";
    for (CajeroBanco caj : cajeros) {
        texto += "- " + caj.getNombre() + ": ";
        texto += (caj.isDisponibilidad() ? "Disponible" : "Ocupado");

        List<Cliente> atendidos = caj.getClientesAtendidos();
        if (atendidos.isEmpty()) {
            texto += " (Atendidos: sin registros)\n";
        } else {
            texto += " (Atendidos: ";
            for (Cliente cliente : atendidos) {
                texto += cliente.toString() + "; ";
            }
            texto = texto.substring(0, texto.length() - 2); 
            texto += ")\n";
        }
    }

    texto += "- " + plataformaServicios.getNombre() + ": ";
    texto += (plataformaServicios.isDisponibilidad() ? "Disponible" : "Ocupado");

    List<Cliente> atendidosPlataforma = plataformaServicios.getClientesAtendidos();
    if (atendidosPlataforma.isEmpty()) {
        texto += " (Atendidos: sin registros)\n";
    } else {
        texto += " (Atendidos: ";
        for (Cliente cliente : atendidosPlataforma) {
            texto += cliente.toString() + "; ";
        }
        texto = texto.substring(0, texto.length() - 2); 
        texto += ")\n";
    }

    texto += "\nPróximos en fila:\n";
    List<Ticket> lista = cola.obtenerTicketsEnCola();
    int cantidad = Math.min(5, lista.size());
    for (int i = 0; i < cantidad; i++) {
        Ticket t = lista.get(i);
        texto += (i + 1) + ". " + t.getNumeroTicket() + " - " + t.getNombreCliente() + "\n";
    }

    return texto;
}


    public String generarReporte(String tipo) {
        if (tipo.equals("Clientes Atendidos por Cajero")) {
            return reporteClientesPorCajero();
        } else if (tipo.equals("Promedio de Tiempo de Espera por Cajero")) {
            return reporteTiempoEsperaPorCajero();
        } else if (tipo.equals("Total de Clientes que Entraron")) {
            return "Total de clientes que entraron al banco: " + estadisticas.getClientesIngresados();
        } else if (tipo.equals("Total de Clientes Atendidos y Sin Atender")) {
            return reporteClientesAtendidosYSinAtender();
        } else if (tipo.equals("Clientes Atendidos por Categoría")) {
            return reporteClientesPorCategoria();
        } else if (tipo.equals("Clientes que se Fueron sin Atender")) {
            return reporteClientesNoAtendidos();
        }
        return "Tipo de reporte no reconocido";
    }

    private String reporteClientesPorCajero() {
    String texto = "=== CLIENTES ATENDIDOS POR CAJERO ===\n\n";
    
    for (int i = 0; i < cajeros.size(); i++) {
        CajeroBanco c = cajeros.get(i);
        texto += c.getNombre() + ":\n";
        
        if (c.getClientesAtendidos().isEmpty()) {
            texto += "  (Sin clientes atendidos)\n";
        } else {
            for (Cliente cliente : c.getClientesAtendidos()) {
                texto += "  - " + cliente.toString() + "\n";
            }
        }
    }

    texto += plataformaServicios.getNombre() + ":\n";
    if (plataformaServicios.getClientesAtendidos().isEmpty()) {
        texto += "  (Sin clientes atendidos)\n";
    } else {
        for (Cliente cliente : plataformaServicios.getClientesAtendidos()) {
            texto += "  - " + cliente.toString() + "\n";
        }
    }

    return texto;
}

    private String reporteTiempoEsperaPorCajero() {
        String texto = "=== PROMEDIO DE TIEMPO DE ESPERA POR CAJERO ===\n\n";
        for (int i = 0; i < cajeros.size(); i++) {
            CajeroBanco c = cajeros.get(i);
            texto += c.getNombre() + ": " + c.getTiempoAtencion() + " min\n";
        }
        texto += plataformaServicios.getNombre() + ": " + plataformaServicios.getTiempoAtencion() + " min\n";
        return texto;
    }

    private String reporteClientesAtendidosYSinAtender() {
        String texto = "=== RESUMEN DE ATENCIÓN ===\n\n";
        texto += "Total de clientes que entraron: " + estadisticas.getClientesIngresados() + "\n";
        texto += "Total de clientes atendidos: " + estadisticas.getClientesAtendidos() + "\n";
        texto += "Total de clientes sin atender: " + estadisticas.getClientesSinAtender() + "\n";
        return texto;
    }

    private String reporteClientesPorCategoria() {
        String texto = "=== CLIENTES ATENDIDOS POR CATEGORÍA ===\n\n";
        Map<Character, Integer> mapa = estadisticas.getCategoriaCliente();

        texto += "A (Adulto Mayor): " + mapa.getOrDefault('A', 0) + "\n";
        texto += "B (Embarazada/Niño): " + mapa.getOrDefault('B', 0) + "\n";
        texto += "C (Discapacidad): " + mapa.getOrDefault('C', 0) + "\n";
        texto += "D (Múltiples Asuntos): " + mapa.getOrDefault('D', 0) + "\n";
        texto += "E (Plataforma): " + mapa.getOrDefault('E', 0) + "\n";
        texto += "F (Mujer): " + mapa.getOrDefault('F', 0) + "\n";
        texto += "G (Hombre): " + mapa.getOrDefault('G', 0) + "\n";

        return texto;
    }

    private String reporteClientesNoAtendidos() {
        String texto = "=== CLIENTES QUE SE FUERON SIN ATENDER ===\n\n";
        List<Cliente> lista = estadisticas.getClientesSinAtender();
        if (lista.size() == 0) {
            texto += "No hay clientes que se hayan ido sin atender.\n";
        } else {
            for (int i = 0; i < lista.size(); i++) {
                Cliente c = lista.get(i);
                texto += "- " + c.getNombre() + " (Ticket: " + c.getTicket() + ")\n";
            }
        }
        return texto;
    }

    public String obtenerEstadisticas() {
        String texto = "=== ESTADÍSTICAS GENERALES ===\n\n";
        texto += "Total de clientes ingresados: " + estadisticas.getClientesIngresados() + "\n";
        texto += "Total de clientes atendidos: " + estadisticas.getClientesAtendidos() + "\n";
        texto += "Total de clientes sin atender: " + estadisticas.getClientesSinAtender() + "\n";
        texto += "Clientes en fila actualmente: " + cola.getTamaño() + "\n\n";

        texto += "Eficiencia por cajero:\n";
        for (int i = 0; i < cajeros.size(); i++) {
            CajeroBanco c = cajeros.get(i);
            texto += "- " + c.getNombre() + ": " + c.getTotalClientesAtendidos();
            texto += " clientes, " + c.getTiempoEspera() + " min promedio espera\n";
        }

        texto += "- " + plataformaServicios.getNombre() + ": " + plataformaServicios.getClientesAtendidos();
        texto += " clientes, " + plataformaServicios.getTiempoEspera() + " min promedio espera\n";

        return texto;
    }
}

