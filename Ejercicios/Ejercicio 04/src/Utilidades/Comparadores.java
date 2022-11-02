package Utilidades;

import Entidades.Pelicula;
import java.util.Comparator;

public class Comparadores {
    
    public static Comparator <Pelicula> duracionAscendente = new Comparator <Pelicula>() {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t1.getDuracion().compareTo(t2.getDuracion());
        }
    };
    
     public static Comparator <Pelicula> duracionDescendente = new Comparator <Pelicula>() {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t2.getDuracion().compareTo(t1.getDuracion());
        }
    };
     
     public static Comparator<Pelicula> ordendarPorTitulo = new Comparator<Pelicula> () {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t1.getTitulo().toLowerCase().compareTo(t2.getTitulo().toLowerCase());
        }
    };
    public static Comparator<Pelicula> ordendarPorDirector = new Comparator<Pelicula> () {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t1.getDirector().toLowerCase().compareTo(t2.getDirector().toLowerCase());
        }
    };
            
            

}
