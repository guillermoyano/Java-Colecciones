package colecciones_ejercio_04v2;

//@author Facundo Cruz
import Entidad.Pelicula;
import Servicio.PeliculaService;
import java.util.ArrayList;
import java.util.Collections;
import utilidades.Comparadores;

public class Colecciones_ejercio_04v2 {

    public static void main(String[] args) {
        PeliculaService sv = new PeliculaService();
        ArrayList<Pelicula> al = new ArrayList();
        sv.crearPelicula(al);
        System.out.println("Todas las peliculas cargadas son: ");
        for (Pelicula var : al) {
            System.out.println(var.toString());
        }
        System.out.println("---------------------------------------");
        System.out.println("Las peliculas con duración mayor a una hora son:");
        for (Pelicula var : al) {
            if (var.getDuracion() >= 1) {
                System.out.println(var.getTitulo());
            }
        }
        System.out.println("---------------------------------------");
        Collections.sort(al, Comparadores.ordendarPorDuracionAsc);
        System.out.println("Las peliculas ordenadas por duracion de menor a mayor son:");
        for (Pelicula var : al) {
            System.out.println(var.getTitulo()+"-->"+var.getDuracion());
        }
        System.out.println("---------------------------------------");
        Collections.sort(al, Comparadores.ordendarPorDuracionDesc);
        System.out.println("Las peliculas ordenadas por duracion de mayor a menor son:");
        for (Pelicula var : al) {
            System.out.println(var.getTitulo()+"-->"+var.getDuracion());
        }
        System.out.println("---------------------------------------");
        Collections.sort(al, Comparadores.ordendarPorTitulo);
        System.out.println("Las peliculas ordenadas por titulo alfabeticamente son:");
        for (Pelicula var : al) {
            System.out.println("Titulo: "+var.getTitulo());
        }
        System.out.println("---------------------------------------");
        Collections.sort(al, Comparadores.ordendarPorDirector);
        System.out.println("Las peliculas ordenadas por director alfabeticamente son:");
        for (Pelicula var : al) {
            System.out.println("Director: "+var.getDirector()+"---> Pelicula: "+var.getTitulo());
        }
    }

}
