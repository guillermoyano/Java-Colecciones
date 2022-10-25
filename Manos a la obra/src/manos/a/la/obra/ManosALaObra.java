package manos.a.la.obra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class ManosALaObra {

    public static void main(String[] args) {
        //Toma la Lista, el Conjunto y el Mapa del ejemplo
        //y agrega 5 objetos a cada uno.
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashMap<Integer, String> alumnos = new HashMap();
        int num;
        String nombre;
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingresá un número y un nombre");
            alumnos.put(num = leer.nextInt(),nombre = leer.next() );
        }
        
        
            System.out.println(alumnos);
        

        

    }
}
