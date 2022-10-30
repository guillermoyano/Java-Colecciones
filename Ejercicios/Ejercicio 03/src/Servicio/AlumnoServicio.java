/*
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide 
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le 
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno: 
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota 
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro 
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este 
promedio final, devuelto por el método y mostrado en el main
*/
package Servicio;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList <Alumno> pruebas = new ArrayList();
    
    public void cargarAlumno(){
        String opcion = " ";
        do{
            Alumno a = new Alumno();
            System.out.println("Ingrese el nombre del alumno");
            a.setAlumno(leer.next());
            System.out.println(".........................................................");
            System.out.println("Ingrese la nota del primer examen");
            a.setNota1(leer.nextInt());
            System.out.println("Ingrese la nota del segundo examen");
            a.setNota2(leer.nextInt());
            System.out.println("Ingrese la nota del tercer examen");
            a.setNota3(leer.nextInt());
            pruebas.add(a);
            System.out.println("Quiere cargar los datos de otro alumno? (Si / No)");
            opcion = leer.next();
        }while (opcion.equalsIgnoreCase("Si"));
    }
    
    public void mostrarLista(){
        for (Alumno var : pruebas) {
            System.out.println(var);
        }
    }
    
    public void notaFinal(){
        String buscar;
        int cont = 0;
        System.out.println("Ingrese el nombre del alumno que desa buscar");
        buscar = leer.next();
        
        for (Alumno var : pruebas) {
            if (var.getAlumno().equalsIgnoreCase(buscar)){
                cont++;
                System.out.println("Se encontró al alumno " +buscar+ " en la lista");
                System.out.println("El promedio del alumno "+buscar+ " es: ");
                System.out.println(   (var.getNota1()+var.getNota2()+var.getNota3())/3 );
            }
        }
        
        if (cont == 0){
            System.out.println("No se encontró al alumno " +buscar+ " en la lista");
        }
        
    }
}
