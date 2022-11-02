/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
 */
package Servicio;

import Entidades.Pelicula;
import Utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Pelicula> cine = new ArrayList();

    public void crearPelicula() {
        String respuesta = "";
        do {
            Pelicula p = new Pelicula();
            System.out.println("Ingrese el nombre de la Película");
            p.setTitulo(leer.next());
            System.out.println("Ingrese el nombre del director");
            p.setDirector(leer.next());
            System.out.println("Ingrese la duración de la película en minutos");
            p.setDuracion(leer.nextInt());
            System.out.println("...............................");
            cine.add(p);
            System.out.println("Desea agregar otra película? (S - N)");
            respuesta = leer.next();
        } while (respuesta.equalsIgnoreCase("S"));
    }

    public void mostrarCine() {
        for (Pelicula var : cine) {
            System.out.println(var);
        }
        System.out.println("......................................................................");
    }

    public void menorUnaHora() {
        System.out.println("Las películas que duran menos de una hora son: ");
        for (Pelicula var : cine) {
            if (var.getDuracion() < 60) {
                System.out.println(var);
            }
        }
    }

    public void segunDuracionDescendente() {
        Collections.sort(cine, Comparadores.duracionDescendente);
        System.out.println("......................................................................");
        System.out.println("Las películas ordenadas según duración Descendente son: ");
        for (Pelicula var : cine) {
            System.out.println(var.getTitulo() + "---->" + var.getDuracion());
        }
    }

    public void segunDuracionAscendente() {
        Collections.sort(cine, Comparadores.duracionAscendente);
        System.out.println("......................................................................");
        System.out.println("Las películas ordenadas según duración ascendente son: ");
        for (Pelicula var : cine) {
            System.out.println(var.getTitulo() + "---->" + var.getDuracion());
        }
    }

    public void porTitulo() {
        Collections.sort(cine, Comparadores.duracionAscendente);
        System.out.println("......................................................................");
        System.out.println("Las peliculas ordenadas por titulo alfabeticamente son:");
        for (Pelicula var : cine) {
            System.out.println("Titulo: " + var.getTitulo());
        }
    }

    public void porDirector() {
        Collections.sort(cine, Comparadores.duracionAscendente);
        System.out.println("......................................................................");
        System.out.println("Las peliculas ordenadas por titulo alfabeticamente son:");
        for (Pelicula var : cine) {
            System.out.println("Director: " + var.getDirector() + "---> Pelicula: " + var.getTitulo());
        }
    }

}
