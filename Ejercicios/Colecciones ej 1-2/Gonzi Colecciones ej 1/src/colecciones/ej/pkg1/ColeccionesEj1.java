/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El 
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y 
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide 
salir, se mostrará todos los perros guardados en el ArrayList.


Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá 
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro 
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista 
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará 
la lista ordenada.

 */
package colecciones.ej.pkg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ColeccionesEj1 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<String> nombresPerros = new ArrayList();
        String perro;

        int opcion;
        do {
            System.out.println("\tMenu ");
            System.out.println("1 - Cargar Perro");
            System.out.println("2 - Eliminar Perro");
            System.out.println("3 - Mostrar lista Actual");
            System.out.println("5 - Salir");
            System.out.println("Elija su opcion:");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del Perro");
                    nombresPerros.add(leer.next());
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del perro para eliminar");
                    perro = leer.next();
                    if (nombresPerros.contains(perro)) {
                        nombresPerros.remove(perro);
                    } else {
                        System.out.println("El perro no se encuentra");
                    }
                    break;
                case 3:
                    System.out.println("Los perros cargados hasta ahora son: ");
                    for (String var : nombresPerros) {
                        System.out.println(var);
                    }
                    System.out.println("Hay " + nombresPerros.size() + " Perros");
                    break;
                case 5:
                    System.out.println("Hasta Luego...");
                    break;
                default:
                    System.out.println("Esa no es una opcion valida, vuelva a intentar...");
                    break;
            }
        } while (!(opcion == 5));

        System.out.println("El total de los perros cargados son:  ");
        for (String var : nombresPerros) {
            System.out.println(var);
        }
        System.out.println("Hay " + nombresPerros.size() + " Perros");

        System.out.println("Ingrese un perro para eliminar");
        String nombreRemove = leer.next();
        Iterator<String> it = nombresPerros.iterator();
        int cont = 0;
        while (it.hasNext()) {
            String aux = it.next();
            if (aux.equals(nombreRemove)) {
                it.remove();
                cont++;
            }
        }
        if (cont > 0) {
            System.out.println("Se encontro el perro y se eliminó");
        } else {
            System.out.println("No se encontro el perro");
        }

        Collections.sort(nombresPerros, Comparadores.ordenarDesc);

        System.out.println("El total de los perros cargados y Ordenados "
                + "Descendentemente (Z -> A) son:  ");
        for (String var : nombresPerros) {
            System.out.println(var);
        }
        System.out.println("Hay " + nombresPerros.size() + " Perros");

    }

}
