/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocolasprioridad;
import javax.swing.JOptionPane;
/**
 *
 * @author Anguar Alberto Rodriguez Fonseca
 */
public class SistemaBancario {
    private BancoSistema controlador;

    public SistemaBancario() {
        this.controlador = new BancoSistema();
    }

    public void ejecutarSistema() {
        String[] opciones = {
            "1. Generar Ticket",
            "2. Atender Cliente",
            "3. Mostrar Estado de Colas",
            "4. Generar Reportes",
            "5. Ver Estadísticas",
            "6. Salir"
        };

        int seleccion;
        do {
            String menu = "=== SISTEMA BANCARIO - COLAS CON PRIORIDAD ===\n\n";
            for (String opcion : opciones) {
                menu += opcion + "\n";
            }

            String input = JOptionPane.showInputDialog(null, menu, "Menú Principal",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                seleccion = 6;
            } else {
                try {
                    seleccion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    seleccion = 0;
                }
            }

            ejecutarOpcion(seleccion);
        } while (seleccion != 6);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                generarTicket();
                break;
            case 2:
                atenderCliente();
                break;
            case 3:
                mostrarEstadoColas();
                break;
            case 4:
                generarReportes();
                break;
            case 5:
                verEstadisticas();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema bancario");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private void generarTicket() {
        String[] tiposCliente = {
            "Adulto Mayor",
            "Mujer Embarazada/Con Niño",
            "Persona con Discapacidad",
            "Múltiples Asuntos",
            "Plataforma de Servicios",
            "Mujer",
            "Hombre"
        };

        String tipoSeleccionado = (String) JOptionPane.showInputDialog(null,
                "Seleccione el tipo de cliente:",
                "Generar Ticket",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tiposCliente,
                tiposCliente[0]);

        if (tipoSeleccionado != null) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Ticket ticket = controlador.generarTicket(nombre, tipoSeleccionado);
                if (ticket != null) {
                    JOptionPane.showMessageDialog(null,
                            "Ticket generado exitosamente:\n" + ticket.toString());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La fila está llena (máximo 25 clientes)");
                }
            }
        }
    }

    private void atenderCliente() {
        String[] cajas = {
            "Caja 1", "Caja 2", "Caja 3", "Caja 4", "Caja 5", "Plataforma de Servicios"
        };

        String cajaSeleccionada = (String) JOptionPane.showInputDialog(null,
                "Seleccione la caja para atender:",
                "Atender Cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                cajas,
                cajas[0]);

        if (cajaSeleccionada != null) {
            String resultado = controlador.atenderCliente(cajaSeleccionada);
            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private void mostrarEstadoColas() {
        String estado = controlador.obtenerEstadoColas();
        JOptionPane.showMessageDialog(null, estado, "Estado de Colas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void generarReportes() {
        String[] tiposReporte = {
            "Clientes Atendidos por Cajero",
            "Promedio de Tiempo de Espera por Cajero",
            "Total de Clientes que Entraron",
            "Total de Clientes Atendidos y Sin Atender",
            "Clientes Atendidos por Categoría",
            "Clientes que se Fueron sin Atender"
        };

        String tipoSeleccionado = (String) JOptionPane.showInputDialog(null,
                "Seleccione el tipo de reporte:",
                "Generar Reportes",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tiposReporte,
                tiposReporte[0]);

        if (tipoSeleccionado != null) {
            String reporte = controlador.generarReporte(tipoSeleccionado);
            JOptionPane.showMessageDialog(null, reporte, "Reporte",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void verEstadisticas() {
        String estadisticas = controlador.obtenerEstadisticas();
        JOptionPane.showMessageDialog(null, estadisticas, "Estadísticas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();
        sistema.ejecutarSistema();
    }
}
