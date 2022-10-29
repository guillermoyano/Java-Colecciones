package Entidad.Servicio;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioAlumnos {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ArrayList<Alumno> Estudiantes = new ArrayList();

    public Alumno IngresarDatos() {
        Alumno d1 = new Alumno();
        d1.getNotas().clear();
        System.out.println("Ingrese el nombre");
        d1.setNombrealumno(leer.next());
        int x = 0;
        do {
            System.out.println("Ingrese la nota " + (x + 1));
            int nota=leer.nextInt();
            while(nota<0 || nota>10){
                System.out.println("Nota invalida, ingrese nuevamente");
                nota=leer.nextInt();
              }
                 d1.notas.add(nota);
            x++;
        } while (x != 3);
        System.out.println(d1.getNombrealumno() + " " + d1.getNotas());
        return new Alumno(d1.getNombrealumno(), d1.getNotas());
    }

    public void IngresoAlumnos() {
        String opcion;
        do {
            Estudiantes.add(IngresarDatos());
            System.out.println("Desea ingresar otro alumno? (S/N)");
            opcion = leer.next();
        } while (!opcion.equalsIgnoreCase("N"));

    }

    public void mostrar() {
        for (Alumno Estudiante : Estudiantes) {
            System.out.println(Estudiante.toString());
        }
    }

    public void Promedio() {
        String opcion;
        do {
            System.out.println("Ingrese el nombre del Alumno para sacar promedio");
            String nombre = leer.next();
            int x = 0;
            for (Alumno Estudiante : Estudiantes) {
                if (Estudiante.getNombrealumno().equalsIgnoreCase(nombre)) {
                    int prom = (Estudiante.notas.get(0) + Estudiante.notas.get(1) + Estudiante.notas.get(2)) / 3;
                    System.out.println("El Alumno " + Estudiante.getNombrealumno() + " tiene de promedio un " + prom);
                    x++;
                }
            }
            if (x == 0) {
                System.out.println("El Alumno no se encuentra en la lista a buscar...");
            }
            System.out.println("Desea ingresar otro alumno? (S/N)");
            opcion = leer.next();
        } while (!opcion.equalsIgnoreCase("N"));
        if(opcion.equalsIgnoreCase("N")){
            System.out.println("Programa Finalizado, Adios...");
        }
    }
}