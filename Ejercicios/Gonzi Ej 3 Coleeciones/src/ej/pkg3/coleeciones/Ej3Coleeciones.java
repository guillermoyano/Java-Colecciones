/**
 * Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
 * alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
 * con sus 3 notas.
 * En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
 * toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
 * pregunta al usuario si quiere crear otro Alumno o no.
 * Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
 * Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
 * final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
 * del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
 * promedio final, devuelto por el método y mostrado en el main.
 */
package ej.pkg3.coleeciones;

import Entidades.Alumno;
import Servicio.AlumnoServicio;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej3Coleeciones {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AlumnoServicio as = new AlumnoServicio();
        Alumno a = new Alumno();
        ArrayList<Alumno> Estudiantes = new ArrayList();

        do {

            Estudiantes.add(as.crearAlumno());

            System.out.println("Quiere continuar creando alumnos? [Si] / [No]");
            if (leer.next().equalsIgnoreCase("no")) {
                break;
            }

        } while (true);

        System.out.println("Los alumnos son: ");
        for (Alumno aux : Estudiantes) {
            System.out.println(aux.toString());
        }

        System.out.println("Ingrese el nombre del alumno para calcular la nota final");

        String nombre = leer.next();
        int cont = 0;
        double notaF = 0;
        for (Alumno aux : Estudiantes) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                notaF = as.notaFinal(aux);
                cont++;
                break;
            }
        }
        if (cont == 0) {
            System.out.println("No se encontró el alumno");
        } else {
            System.out.println("La nota final de " + nombre + " es: " + notaF);
        }

    }

}
