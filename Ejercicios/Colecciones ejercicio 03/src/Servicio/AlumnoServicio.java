/*
Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package Servicio;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

public class AlumnoServicio {

    public ArrayList<Alumno> mi() {
        ArrayList<Alumno> miAlum = new ArrayList();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc = 1;
        String opc2;
        while (opc != 0) {
            Alumno miAlumno = crearAlumno();
            miAlum.add(miAlumno);
            System.out.println("----------------------------");
            System.out.println("Quiere ingresar otro alumno?");
            opc2 = leer.next();
            if ("S".equals(opc2) || "s".equals(opc2) || "Si".equals(opc2) || "si".equals(opc2)) {
                opc = 1;
            } else {
                opc = 0;
            }
        }
        return miAlum;
    }

    public Alumno crearAlumno() {
        Alumno miAlumno = new Alumno();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del alumno");
        miAlumno.setNombre(leer.next());

        double nota;
        ArrayList<Double> notas1 = new ArrayList();

        int tamaño = 0;

        while (tamaño != 3) {
            System.out.println("Ingrese la nota");
            nota = leer.nextDouble();
            notas1.add(nota);
            miAlumno.setNotas(notas1);

            tamaño = miAlumno.getNotas().size();
        }

        return miAlumno;
    }

    public double notaFinal(ArrayList<Alumno> miAlumn) {

        double nota;
        ArrayList<Alumno> alumnos1 = miAlumn;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        nota = 0;
        String nombre;

        int opc = 1;
        String opc2;

        while (opc != 0) {
            System.out.println("----------------------------");

            System.out.println("Ingrese el nombre del alumno que quiere sacar la nota final");
            nombre = leer.next();
            String busqueda = nombre;

            int cont = 0;
            for (Alumno cadena : alumnos1) {
                if (cadena.getNombre().equals(busqueda)) {
                    System.out.println("----------------------------");

                    System.out.println("El alumno " + cadena.getNombre());

                    System.out.println("Sus notas son:");
                    System.out.println(cadena.getNotas());

                    nota = (cadena.getNotas().get(0) + cadena.getNotas().get(1) + cadena.getNotas().get(2)) / 3;

                } else {
                    cont = cont + 1;
                }
            }

            if (cont == alumnos1.size()) {
                System.out.println("----------------------------");

                System.out.println("El alumno no existe");
            } else {
                System.out.println("Su promedio es:");
                System.out.println(nota);
            }
            System.out.println("----------------------------");

            System.out.println("Quiere sacar el promedio de otro alumno?");
            opc2 = leer.next();

            if ("S".equals(opc2) || "s".equals(opc2) || "Si".equals(opc2) || "si".equals(opc2)) {
                opc = 1;
            } else {
                opc = 0;
            }
        }
        //System.out.println(alumnos1);
        System.out.println("----------------------------");
        System.out.println("El programa finalizo");

        return nota;
    }

}
