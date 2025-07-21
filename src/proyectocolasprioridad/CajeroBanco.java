/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Frank
 */
public class CajeroBanco {
   private String nombre;
   private boolean disponible;
   private Cliente clienteActual;
   private List<Cliente> clientesAtendidos;
   private long inicioAtencion;
   private long totalClientesAtendidos;

   

    public CajeroBanco(String nombre) {
    this.nombre = nombre;
    this.disponible = true;
    this.totalClientesAtendidos = 0;
    this.clientesAtendidos = new ArrayList<>(); 
}

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponibilidad(){
        return disponible;
    }

    public List<Cliente> getClientesAtendidos() {
        return clientesAtendidos;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }
    
   public void atencionCliente(Cliente cliente){
       this.clienteActual = cliente;
       this.disponible = false;
       this.inicioAtencion= System.currentTimeMillis();
       cliente.setInicioAtencion(this.inicioAtencion);
   }
   
   public void finAtencion(){ 
       if(clienteActual != null){ 
           long atencionFin = System.currentTimeMillis();
           clienteActual.setFinAtencion(atencionFin);
           clienteActual.setAtencion(true);
           clientesAtendidos.add(clienteActual);
           totalClientesAtendidos += (atencionFin - inicioAtencion);
           clienteActual = null;
           disponible = true;
       } 
   }
   
   public int getTotalClientesAtendidos(){ 
       return clientesAtendidos.size();
   } 
   
   public double getTiempoEspera(){ 
       if(clientesAtendidos.isEmpty())return 0;
       return clientesAtendidos.stream()
               .mapToInt(Cliente::getEsperaTiempo)
               .average().orElse(0);
   }  
   
   public double getTiempoAtencion(){
       if(clientesAtendidos.isEmpty()) return 0;
       return(double) totalClientesAtendidos/(100 * 60 * clientesAtendidos.size());
   }
   
}

