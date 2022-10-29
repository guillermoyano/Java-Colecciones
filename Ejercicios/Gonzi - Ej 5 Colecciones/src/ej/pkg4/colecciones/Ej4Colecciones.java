/**
 * Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
 * usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
 * conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
 * si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
 * los servicios en la clase correspondiente)
 * Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
 * cómo se ordena un conjunto.
 * Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
 * buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
 * usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
 * al usuario.
 */
package ej.pkg4.colecciones;

import Comparadores.Comparador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ej4Colecciones {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashSet<String> listaPaises = new HashSet();
        String pais;
        String opcion;
        do {
            pais = JOptionPane.showInputDialog("Ingresa un País para agregar a la lista");
            listaPaises.add(pais);
            opcion = JOptionPane.showInputDialog("Quiere cargar otro País?");
            if (opcion.equalsIgnoreCase("No")) {
                System.out.println("Finalizando....");
                break;
            }
        } while (true);

        System.out.println("La lista Cargada es: ");

        for (String aux : listaPaises) {
            System.out.println(aux);
        }

        ArrayList<String> listaP = new ArrayList(listaPaises);

        Collections.sort(listaP, Comparador.ordenarAZ);

        System.out.println("Lista ordenada de Paises de la A --> Z");
        for (String aux : listaP) {
            System.out.println(aux);
        }

        System.out.println("Ingrese un pais para eliminar");
        String paisB = leer.next();

        Iterator<String> it = listaP.iterator();
        int cont = 0;
        while (it.hasNext()) {

            if (it.next().equalsIgnoreCase(paisB)) {
                System.out.println("Se Borró el pais");
                it.remove();
                cont++;
                break;
            }
        }
        if (cont == 0) {
            System.out.println("No se encontró el pais");
        } else {
            System.out.println("La nueva lista de paises es: ");
            for (String aux : listaP) {
                System.out.println(aux);
            }
        }

    }

}
