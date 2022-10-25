package practica.colecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Video3 {

    public static void main(String[] args) {
        
        

    public ServicioMascota() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.mascotas = new ArrayList();

    }

    public Mascota crearMascota() {
        System.out.println("Introducir nombre de la mascota");
        String nombre = leer.next();
        System.out.println("Introducir apodo");
        String apodo = leer.next();
        System.out.println("Introducir tipo de mascota");
        String tipo = leer.next();
        
        Mascota m = new Mascota(nombre, apodo, tipo);
        mascotas.add(m);
        return m;
    }
    
    public void mostrarrMascota(){
        System.out.println("Las mascotas actuales de la lista Mascotas son:");
        for (Mascota var : mascotas) {
            System.out.println(var.toString());
        }
        System.out.println("cantidad= " mascotas.size());
    }
    
    /**
     * Crea Mascotas, TODOS chiquitos
     * 
     * @param cantidad equivale a la cantidad de mascotas a crear y añadir a la lista
     * 
     */
    public void fabricaChiquitos(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            Mascota var = new Mascota ("Fer", "Chiquito", "Beagle");
            mascotas.add(var);
            //Se puede hacer de la forma de arriba, pero se hace de la forma de abajo que es más limpia
            mascotas.add(new Mascota ("Fer", "Chiquito", "Beagle"))
        }
    }
    
    /**
     * 
     * Crea mascotas pidiendo datos por teclado
     */
    public void fabricaMascota(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            //Se llama al método
            Mascotas mascotasCreada = crearMascota();
            
            System.out.println(mascotasCreada.toString());
        }
    }
    
    
    
    /**
     * EN EL MAIN:
     * 
     * ServicioMascota servMasc = new ServicioMascota();
     * 
     * servMasc.fabricaMascota(2); -- Dentro del paréntesis la cantidad de mascotas a crear
     * 
     * servMasc.mostrarMAscotas();
     * 
     */

}


