package practica.colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Video2 {
    
 private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private List<String> mascotas;
    
    /*
    public MascotaServicio(){
        this.mascotas = new ArrayList();
    }
    */
    
    public void CrearMascota(){
        System.out.println("Introducir nombre de la mascota");
        String nombre = leer.next();
        System.out.println("Introducir apodo");
        String apodo = leer.next();
        System.out.println("Introducir tipo de mascota");
        String tipo = leer.next();
        
        String mascota = nombre+ " " +apodo+ " " +tipo;
        mascotas.add(mascota);
    }
    
    public void mostrarMascotas(){
        for (String var : mascotas) {
            System.out.println(var);
        }
        System.out.println("Cantidad= " +mascotas.size());
    }    

}
