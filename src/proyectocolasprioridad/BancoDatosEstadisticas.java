/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Anguar Alberto Rodriguez Fonseca
 */
public class BancoDatosEstadisticas {
    private int clientesIngresados;
    private int ClientesAtendidos;
    private int clientesPorAtender;
    private List<Cliente> ClientesSinAtender;
    private Map<Character, Integer> categoriaCliente;

   public BancoDatosEstadisticas() {
    this.clientesIngresados = 0;
    this.ClientesAtendidos = 0;
    this.clientesPorAtender = 0;
    this.ClientesSinAtender = new ArrayList<>();
    this.categoriaCliente = new HashMap<>();
    definicionCategorias();
}
    
    private void definicionCategorias(){
      categoriaCliente.put('A', 0);
      categoriaCliente.put('B', 0);
      categoriaCliente.put('C', 0);
      categoriaCliente.put('D', 0);
      categoriaCliente.put('E', 0);
      categoriaCliente.put('F', 0);
      categoriaCliente.put('G', 0);
    }
    
    public void registroIngresoCliente(){
        clientesIngresados++;
    }
    
    public void registroClientesAtendidos(Cliente cliente){ 
        ClientesAtendidos++;
        char categoria = cliente.getTicket().charAt(0);
        categoriaCliente.put(categoria, categoriaCliente.get(categoria) + 1);
    }
    
    public void registroClientesPorAtender(Cliente cliente){
       clientesPorAtender++;
       ClientesSinAtender.add(cliente);
    } 

    public int getClientesIngresados() {
        return clientesIngresados;
    }

    public int getClientesAtendidos() {
        return ClientesAtendidos;
    }

    public int getClientesPorAtender() {
        return clientesPorAtender;
    }

    public List<Cliente> getClientesSinAtender() {
        return ClientesSinAtender;
    }

    public Map<Character, Integer> getCategoriaCliente() {
        return categoriaCliente;
    }
    
    
}
