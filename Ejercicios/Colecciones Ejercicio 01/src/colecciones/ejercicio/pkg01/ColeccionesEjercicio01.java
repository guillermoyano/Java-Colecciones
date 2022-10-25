package colecciones.ejercicio.pkg01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo
 * String. El programa pedirá una raza de perro en un bucle, el mismo se
 * guardará en la lista y después se le preguntará al usuario si quiere guardar
 * otro perro o si quiere salir. Si decide salir, se mostrará todos los perros
 * guardados en el ArrayList.
 */
public class ColeccionesEjercicio01 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<String> perritos = new ArrayList();
        String opcion = " ", raza;

        do {
            System.out.println("Ingrese una raza de perro");
            raza = leer.next();
            perritos.add(raza);

            System.out.println("Desea salir? para salir presione S. Para seguir agregando razas"
                    + "presione N");
            opcion = leer.next();
        } while (!opcion.equalsIgnoreCase("s"));

        for (String var : perritos) {
            System.out.println(var);
        }

        /**
         * Continuando el ejercicio anterior, después de mostrar los perros, al
         * usuario se le pedirá un perro y se recorrerá la lista con un
         * Iterator, se buscará el perro en la lista. Si el perro está en la
         * lista, se eliminará el perro que ingresó el usuario y se mostrará la
         * lista ordenada. Si el perro no se encuentra en la lista, se le
         * informará al usuario y se mostrará la lista ordenada.
         */
        Iterator iterator = perritos.iterator();

        System.out.println("Elementos de la lista de razas de perros");

        System.out.println("Ingrese la raza de perros que quiere encontrar");
        String comparar = leer.next();
        int conta=0;
        while (iterator.hasNext()) {

            if (iterator.next().equals(comparar)) {
                iterator.remove();
                conta++;
            }
        }
        System.out.println("");
        
        if (conta ==0){
            System.out.println("Esa raza no está en la lista");
        }
        System.out.println("........................");
        
        Collections.sort(perritos);

        for (String var : perritos) {
            System.out.println(var);
        }
    }

}
