package Comparadores;

import Entidad.Alumnos;
import java.util.Comparator;

public class Comparar {
//
    public static Comparator <Alumnos> alfabeticoAscendenteApellido = new Comparator<Alumnos>() {
        @Override
        public int compare(Alumnos t, Alumnos t1) {
            return t.getApellido().toLowerCase().compareTo(t1.getApellido().toLowerCase());
        }
    } ;
    
     public static Comparator <Alumnos> nombreDescendente = new Comparator<Alumnos>() {
        @Override
        public int compare(Alumnos t, Alumnos t1) {
            return t1.getNombre().toLowerCase().compareTo(t.getNombre().toLowerCase());
        }
    } ;
       
            
            
           
            
    
}
