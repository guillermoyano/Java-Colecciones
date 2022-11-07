package eja02colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Tonna/SA FR34K
 */
/**/
public class EjA02Colecciones {

    /*2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<String> perros = new ArrayList<>();
        String opcion;
        do {
            System.out.println("Ingrese la raza del perro");
            perros.add(leer.next());
            System.out.println("Desea ingresar otra raza de perro (S/N)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("s"));
        System.out.println("Lista de Razas de perros");
        for (String razas : perros) {
            System.out.println(razas);
        }
        System.out.println("Cantidad de perros: " + perros.size());

        Iterator recorrer = perros.iterator();
        System.out.println("Ingrese una raza de perro a buscar:");
        String busca = leer.next();
        int a = 0;
        while (recorrer.hasNext()) {
            if (recorrer.next().equals(busca)) {
                recorrer.remove();
                a = 1;
            }
        }
        if (a == 1) {
            System.out.println("La raza del perro ha sido encontrada y eliminada de la lista");
        } else {
            System.out.println("La raza del perro no esta en la lista");
        }
        Collections.sort(perros);
        System.out.println("Razas de perros");
        for (String aux : perros) {
            System.out.println(aux);
        }
        System.out.println("Cantidad de perros: " + perros.size());

    }
}
