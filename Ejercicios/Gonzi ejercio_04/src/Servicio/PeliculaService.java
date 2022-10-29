package Servicio;

import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

//@author Facundo Cruz
public class PeliculaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearPelicula(ArrayList<Pelicula> lista) {

        System.out.println("¿Cuántas peliculas desea ingresar?");
        int cant = leer.nextInt();
        for (int i = 0; i < cant; i++) {
            System.out.println("Pelicula " + (i + 1));
            Pelicula p1 = new Pelicula();
            System.out.println("Ingrese el titulo");
            p1.setTitulo(leer.next());
            System.out.println("Ingrese el director");
            p1.setDirector(leer.next());
            System.out.println("Ingrese la duracion en hs");
            p1.setDuracion(leer.nextDouble());
            lista.add(p1);
            if (i<cant-1) {
                System.out.println("¿Desea ingresar otra pelicula?(Si/No)");
                if (leer.next().equalsIgnoreCase("no")) {
                    System.out.println("Finalizando...");
                    break;
                }
            }
        }
        
    }
  

}
