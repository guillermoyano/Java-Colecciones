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
package Servicios;

import Comparadores.Comparadores;
import Entidades.Paises;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Pergo
 */
public class ServicioPais {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void cargarPaises(HashSet PaisesSet) {

        String opc = "";
        do {
            Paises p = new Paises();
            System.out.println("Ingrese el nombre del pais");
            p.setPais(leer.next());
            PaisesSet.add(p);
            System.out.println("Desea agregar otro pais? (Si/No)");
            opc = leer.next();
        } while (!opc.equalsIgnoreCase("no"));
    }

    public void mostrar(HashSet PaisesSet) {
        for (Object aux : PaisesSet) {
            System.out.println(aux);
        }
    }

    public ArrayList ordenar(HashSet PaisesSet) {
        System.out.println("----------Ordenamos Alfabeticamente----------");
        ArrayList<Paises> ordenar = new ArrayList<>(PaisesSet);
        Collections.sort(ordenar, Comparadores.ordenarAlf);
        for (Paises aux : ordenar) {
            System.out.println(aux);

        }
        return ordenar;
    }

    public void eliminarPais(ArrayList ordenar) {
        System.out.println("----------Eliminando pais----------");
        System.out.println("Que pais desea eliminar?");
        String comparar = leer.next();
        int conta = 0;
        Iterator<Paises> it = ordenar.iterator();
        while (it.hasNext()) {
            String aux = it.next().getPais();
            if (aux.equalsIgnoreCase(comparar)) {
                it.remove();
                conta++;
            }
        }
        if (conta == 1) {
            System.out.println("Se encontro el pais se eliminara de la lista ");
            System.out.println("Los paises que quedaron son: ");
            for (Object aux : ordenar) {

                System.out.println(aux);
            }
        } else {
            System.out.println("No se encontro el pais en el listado");
        }
    }
}
