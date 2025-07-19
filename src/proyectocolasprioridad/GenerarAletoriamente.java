/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocolasprioridad;
import java.util.Random;
/**
 *
 * @author Anguar Alberto Rodriguez Fonseca
 */
public class GenerarAletoriamente {
    private static Random random = new Random();
    
    public static int generarNumeroAleatorio(int minimo, int maximo){
        return random.nextInt(maximo - minimo + 1)+minimo;
    }
    
    public static int inicarTramite(){
        return generarNumeroAleatorio(10,120);
    }
    
    public static int Tolerancia(){
        return generarNumeroAleatorio(5,150);
    }
}
