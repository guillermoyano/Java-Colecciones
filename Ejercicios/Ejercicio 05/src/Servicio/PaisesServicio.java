/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos 
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el 
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir, 
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer 
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar 
cómo se ordena un conjunto.
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se 
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el 
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará 
al usuario.
 */
package Servicio;

import Entidades.Paises;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PaisesServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    HashSet<Paises> lista = new HashSet();

    public void cargarPaises() {
        String opcion = " ";
        do {
            Paises p = new Paises();
            System.out.println("Ingrese un país para cargar en la lista");
            p.setPais(leer.next());
            lista.add(p);
            //lista.add(p.getPais());
            System.out.println("Quiere seguir ingresando países? ( Si  /  No)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("Si"));

    }

    public void mostrarPaises() {
        for (Paises var : lista) {
            System.out.println(var);
        }
    }
    
    ArrayList<String> listaArray;

    public void ordenarPaises() {
        System.out.println("");
        System.out.println(".....Los países ordenados alfabéticamente son: .....");
        listaArray = new ArrayList(lista);
        Collections.sort(listaArray);

        for (Object var : listaArray) {
            System.out.println(var);
        }
    }

    public void iterar() {
        String comparar = " ";
        System.out.println("");
        System.out.println("Ingrese el país que desea buscar en la lista");
        comparar = leer.next();
        Iterator<String> it = listaArray.iterator();
        int cont = 0;
        while (it.hasNext()) {
            if (it.next().equals(comparar)) {
                it.remove();
                cont++;
                System.out.println("Se encontró el país " + comparar + " y se eliminó de la lista");
                for (Object var : listaArray) {
                    System.out.println(var);
                }
            }

            if (cont == 0) {
                System.out.println("El país " + comparar + " no estaba en la lista");
                for (Object var : listaArray) {
                    System.out.println(var);
                }

            }
        }
    }
}
    
