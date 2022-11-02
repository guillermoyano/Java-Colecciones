/* 
 Crear listas paralelas de Alumnos, según la nacionalidad.
 Realizar un reporte final de datos que informe:
o Cuantos alumnos son mayores de 25 años.
o Cuantos alumnos tiene su apellido que comienzan con letra L o P
o Cuantos alumnos hay de nacionalidad ARGENTINA – CHILENA –
VENEZOLANA.
Recordar:
 Hacer uso de paquetes y clases correspondientes para buena estructura de 
nuestro proyecto.
 Todos los métodos deben ser pensados para reutilizar y adaptarse a futuros 
cambios (por ejemplo, mañana quiero carga de 30 alumnos, y las instrucciones 
deben prevenir esta modificación)
 */
package Servicio;

import Comparadores.Comparar;
import Entidad.Alumnos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnosServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Alumnos> clase = new ArrayList();

    public void menu() {

        int opcion = 0;

        do {
            System.out.println("........ MENU ........");
            System.out.println("Vamos a cargar los datos de los alumnos");
            System.out.println("1) Alta de alumno");
            System.out.println("2) Mostrar");
            System.out.println("3) Baja alumno");
            System.out.println("4) Modificación de alumno");
            System.out.println("5) Ordenar alfabéticamente los apellidos en forma ascendente");
            System.out.println("6) Ordenar alfabéticamente los nombres en forma descendente");
            System.out.println("8) Calcular edad");
            System.out.println("8) Modificación de alumno");
            System.out.println("9) Modificación de alumno");
            System.out.println("0) Salir");

            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Alta();
                    break;
                case 2:
                    Mostrar();
                    break;
                case 3:
                    Baja();
                    break;
                case 4:
                    Modificacion();
                    break;
                case 5:
                    alfabeticoAscendenteApellido();
                    break;
                case 6:
                    nombreDescendente();
                    break;
                case 7:
                    edad();
                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:

                    break;
                default:
            }
        } while (opcion != 0);
    }

    public void Alta() {
        int opciones = 0;
        String salir = " ";
        do {
            Alumnos a = new Alumnos();
            System.out.println("Ingrese el nombre del Alumno");
            a.setNombre(leer.next());
            System.out.println("Ingrese el apellido del Alumno");
            a.setApellido(leer.next());
            System.out.println("Ingrese la nacionalidad del Alumno");
            do {
                System.out.println("opcion 1) Argentina");
                System.out.println("opcion 2) Chilena");
                System.out.println("opcion 3) Venezolana");
                System.out.println("Ingrese la opción deseada");
                opciones = leer.nextInt();

                switch (opciones) {
                    case 1:
                        a.setNacionalidad("Argentina");
                        break;
                    case 2:
                        a.setNacionalidad("Chilena");
                        break;
                    case 3:
                        a.setNacionalidad("Venezolana");
                        break;
                    default:
                        System.out.println("Error. Esa opción no está en el menú.");
                        System.out.println("Recuerde que las nacionalidades disponibles son: ");
                        System.out.println("Argentina - Chilena - Venezolana");
                }
            } while (opciones < 1 || opciones > 3);
            int cont = 0;
            System.out.println("Ingrese fecha de nacimiento.");
            System.out.println("Primero el día");
            a.setDia(leer.nextInt());
            System.out.println("Ahora el mes");
            a.setMes(leer.nextInt());
            System.out.println("Y por último el año");
            a.setAnio(leer.nextInt());
            a.getNacimiento().set(a.getAnio(), a.getMes() - 1, a.getDia());
            clase.add(a);
            System.out.println("Quiere seguir ingresando más alumnos (Si / No)");
            salir = leer.next();
        } while (salir.equalsIgnoreCase("Si"));
    }

    public void Mostrar() {
        for (Alumnos var : clase) {
            System.out.println(var);
        }
    }

    public void Baja() {
        String bajarlo, bajarlo2;
        int cont = 0;
        System.out.println("...............................................................................................");
        System.out.println("Carguemos los datos para dar de baja a un alumno del registro");
        System.out.println("Ingrese el nombre del alumno que quiere eliminar del registro");
        bajarlo = leer.next();
        System.out.println("Ingrese el apellido del alumno que quiere eliminar del registro");
        bajarlo2 = leer.next();
        for (Alumnos var : clase) {
            if (var.getNombre().equalsIgnoreCase(bajarlo) && var.getApellido().equalsIgnoreCase(bajarlo2)) {
                clase.remove(var);
                cont++;
                System.out.println("Se dió de baja correctamente al alumno " + bajarlo2 + ", " + bajarlo);
                break;
            }
        }
        if (cont == 0) {
            System.out.println(" El alumno " + bajarlo2 + ", " + bajarlo + " no se encuentra en la lista");
        }
        for (Alumnos var : clase) {
            System.out.println(var);
        }
    }

    public void Modificacion() {
        Alumnos a = new Alumnos();
        String modifica1, modifica2;
        int contar = 0;
        System.out.println("...............................................................................................");
        System.out.println("Se pedirán los datos del alumno que quiera modificar sus datos");
        System.out.println("Ingrese el nombre del alumno que quiere modificar en el registro");
        modifica1 = leer.next();
        System.out.println("Ingrese el apellido del alumno que quiere modificar en el registro");
        modifica2 = leer.next();
        int opciones = 0;
        String salir = " ";
        int cont = 0;
        for (Alumnos var : clase) {
            if (var.getNombre().equalsIgnoreCase(modifica1) && var.getApellido().equalsIgnoreCase(modifica2)) {
                do {
                    System.out.println("Vamos a modificar los datos del alumno que ingresó: " + modifica2 + ", " + modifica1);
                    System.out.println("Qué datos desea cambiar?");
                    System.out.println("1) Nombre");
                    System.out.println("2) Apellido");
                    System.out.println("3) Nacionalidad");
                    System.out.println("4) Día de nacimiento");
                    System.out.println("5) Mes de nacimiento");
                    System.out.println("6) Año de nacimiento");
                    System.out.println("0) Salir");
                    System.out.println("Ingrese su opción");
                    opciones = leer.nextInt();
                    switch (opciones) {
                        case 1:
                            System.out.println("Ingrese el nombre del Alumno");
                            var.setNombre(leer.next());
                            break;
                        case 2:
                            System.out.println("Ingrese el apellido del Alumno");
                            var.setApellido(leer.next());
                            break;
                        case 3:
                            System.out.println("Ingrese la nacionalidad del Alumno");
                            do {
                                System.out.println("opcion 1) Argentina");
                                System.out.println("opcion 2) Chilena");
                                System.out.println("opcion 3) Venezolana");
                                System.out.println("Ingrese la opción deseada");
                                opciones = leer.nextInt();
                                switch (opciones) {
                                    case 1:
                                        var.setNacionalidad("Argentina");
                                        break;
                                    case 2:
                                        var.setNacionalidad("Chilena");
                                        break;
                                    case 3:
                                        var.setNacionalidad("Venezolana");
                                        break;
                                    default:
                                        System.out.println("Error. Esa opción no está en el menú.");
                                        System.out.println("Recuerde que las nacionalidades disponibles son: ");
                                        System.out.println("Argentina - Chilena - Venezolana");
                                }
                            } while (opciones < 1 || opciones > 3);
                            break;
                        case 4:
                            System.out.println("Cambiamos el día de nacimiento");
                            var.setDia(leer.nextInt());
                            break;
                        case 5:
                            System.out.println("Cambiamos el mes de nacimiento");
                            var.setMes(leer.nextInt());
                            break;
                        case 6:
                            System.out.println("Cambiamos el año de nacimiento");
                            var.setAnio(leer.nextInt());
                            break;
                        default:
                            System.out.println("Ingresó una opción incorrecta");
                    }
                } while (opciones != 0);
                contar++;
                System.out.println("Se modificó correctamente el alumno " + modifica2 + ", " + modifica1);
                break;
            }
        }
        if (contar == 0) {
            System.out.println(" El alumno " + modifica2 + ", " + modifica1 + " no se encuentra en la lista");
        }
        for (Alumnos var : clase) {
            System.out.println(var);
        }
    }

    public void alfabeticoAscendenteApellido() {
        Collections.sort(clase, Comparar.alfabeticoAscendenteApellido);
        Mostrar();
    }

    public void nombreDescendente() {
        Collections.sort(clase, Comparar.nombreDescendente);
        Mostrar();
    }

    public void edad() {
        Alumnos a = new Alumnos();
        Calendar today = Calendar.getInstance();
        String verifica, verifica1;
        int difanio = 0;
        System.out.println("Ingrese el nombre del alumno que desea saber la edad");
        verifica = leer.next();
        System.out.println("Ingrese el apellido del alumno que desea saber la edad");
        verifica1 = leer.next();
        for (Alumnos var : clase) {
            if (var.getNombre().equalsIgnoreCase(verifica) && var.getApellido().equalsIgnoreCase(verifica1)) {
                difanio = today.get(Calendar.YEAR) - var.getAnio();
                int difmes = today.get(Calendar.MONTH) - var.getMes();
                int difdia = today.get(Calendar.DAY_OF_MONTH) - var.getDia();

                if (difmes < 0 || (difmes == 0 && difdia < 0)) {
                    difanio = difanio - 1;
                }
            }
        }
        System.out.println("La edad es: " + difanio);
    }
}
