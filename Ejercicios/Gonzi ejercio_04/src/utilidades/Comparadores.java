/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Entidad.Pelicula;
import java.util.Comparator;


//@author Facundo Cruz

public class Comparadores {
    public static Comparator<Pelicula> ordendarPorDuracionAsc = new Comparator<Pelicula> () {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDuracion().compareTo(o2.getDuracion());
        }
    };
    public static Comparator<Pelicula> ordendarPorDuracionDesc = new Comparator<Pelicula> () {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o2.getDuracion().compareTo(o1.getDuracion());
        }
    };
    public static Comparator<Pelicula> ordendarPorTitulo = new Comparator<Pelicula> () {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getTitulo().toLowerCase().compareTo(o2.getTitulo().toLowerCase());
        }
    };
    public static Comparator<Pelicula> ordendarPorDirector = new Comparator<Pelicula> () {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDirector().toLowerCase().compareTo(o2.getDirector().toLowerCase());
        }
    };
}
