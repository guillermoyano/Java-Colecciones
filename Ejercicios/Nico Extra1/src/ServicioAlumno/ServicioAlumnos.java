/*
Crea una clase Alumnos, donde tendrá como Atributos el nombre, apellido, la nacionalidad y 
su fecha de nacimiento. La nacionalidad podrá ser ARGENTINA – CHILENA – VENEZOLANA
solamente.
Necesidades:
 Crear los métodos de A – B -M (Alta – Baja – modificación ) que manipulen los 
objetos de este tipo.
 Crear una lista de 20 alumnos (hacer uso del constructor que recibe parámetros , 
para no hacer carga manual de los datos)
 Ordenar y mostrar la lista de alumnos ordenados por orden alfabético según su 
apellido de forma ascendente. 
 Ordenar y mostrar la lista de alumnos ordenados por orden alfabético según su 
nombre de forma descendente. 
 Con un alumno especifico (suponiendo que no existen dos alumnos con el mismo 
nombre y apellido), mostrar por pantalla su edad. Considerar, el manejo de fechas, 
utilizando el atributo fecha de nacimiento.
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
package ServicioAlumno;

import Alumno.Alumnos;
import Comparadores.Comparador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Pergo
 */
public class ServicioAlumnos {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Alumnos> aL = new ArrayList();

    public void menu() {

        int opcion = 0;

        do {
            System.out.println("---------- MENU ----------");

            System.out.println("1) Alta de alumno");
            System.out.println("2) Mostrar");
            System.out.println("3) Baja alumno");
            System.out.println("4) Modificación de alumno");
            System.out.println("5) Ordenar alfabéticamente los apellidos en forma ascendente");
            System.out.println("6) Ordenar alfabéticamente los apellidos en forma descendente");
            System.out.println("7) Calcular edad");
            System.out.println("8) Listado por nacionalidad");
            System.out.println("9) Reporte Final");
            System.out.println("0) Salir");

            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    baja();
                    break;
                case 4:
                    modificacion();
                    break;
                case 5:
                    ordenarAs();
                    break;
                case 6:
                    ordenarDes();
                    break;
                case 7:
                    mostrarEdad();
                    break;
                case 8:
                    listasNac();
                    break;
                case 9:
                    reporteFin();
                    break;
                case 0:
                    System.out.println("Adios soperutano");

                default:
                    System.out.println("Elegiste una opcion incorrecta, try again soperutano");
            }
        } while (opcion != 0);
    }

    public void alta() {
        System.out.println("Vamos a cargar los datos de los alumnos");
        String opc = "";
        int opciones = 0;

        do {
            Alumnos a = new Alumnos();
            System.out.println("Ingrese el nombre del alumno");
            a.setNombre(leer.next());
            System.out.println("Ingrese el apellido del alumno");
            a.setApellido(leer.next());
            System.out.println("Ingrese la nacionalidad del alumno");
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
            } while (opciones < 1 || opciones > 4);
            System.out.println("Ingrese la fecha de nacimiento que ssea correcta por favor sino te linchamos pedaso de soquete");
            System.out.println("Ingrese el dia: ");
            int dia = leer.nextInt();
            System.out.println("Ingrese el mes:");
            int mes = leer.nextInt();
            System.out.println("Ingrese el año");
            int anio = leer.nextInt();
            Date nacimiento = new Date(anio - 1900, mes - 1, dia);
            a.setNacimiento(nacimiento);
            aL.add(a);
            System.out.println("Desea seguir agregando alumnos? (Si/No)");
            opc = leer.next();
        } while (!opc.equalsIgnoreCase("no"));

    }

    public void mostrar() {
        System.out.println("Mostraremos el listado de los alumnos cargados a continuacion: ");
        for (Alumnos aux : aL) {
            System.out.println(aux);
        }
    }

    public void baja() {
        Alumnos a = new Alumnos();
        System.out.println("Ingrese el nombre del alumno que desea elminiar ");

        String comparar1 = leer.next();
        System.out.println("Ingrese el apellido del alumno que desea eliminar");
        String comparar2 = leer.next();
        int conta = 0;
        for (Alumnos var : aL) {
            if (var.getNombre().equalsIgnoreCase(comparar1) && var.getApellido().equalsIgnoreCase(comparar2)) {
                aL.remove(var);
                conta++;
                System.out.println("Se dió de baja correctamente al alumno " + comparar2 + ", " + comparar1);
                break;
            }
        }

        if (conta == 1) {
            System.out.println("Se encontro el nombre y se eliminara de la lista ");
            System.out.println("Los alumnos que quedaron son: ");
            for (Alumnos aux : aL) {

                System.out.println(aux);
            }
        } else {
            System.out.println("No se encontro el alumno en el listado");
        }
    }

    public void modificacion() {
        Alumnos a = new Alumnos();
        String modifica1, modifica2;
        int contar = 0;
        System.out.println("...............................................................................................");
        System.out.println("Se pedirán los datos del alumno que quiera modificar sus datos");
        System.out.println("Ingrese el nombre del alumno que quiere eliminar del registro");
        modifica1 = leer.next();
        System.out.println("Ingrese el apellido del alumno que quiere eliminar del registro");
        modifica2 = leer.next();
        int opciones = 0;
        String salir = " ";
//        Date nac = new Date();
        int dia, mes, anio = 0;
        int cont = 0;
        for (Alumnos var : aL) {
            if (var.getNombre().equalsIgnoreCase(modifica1) && var.getApellido().equalsIgnoreCase(modifica2)) {
                do {
                    System.out.println("Vamos a modificar los datos del alumno que ingresó: " + modifica2 + ", " + modifica1);
                    System.out.println("Qué datos desea cambiar?");
                    System.out.println("1) Nombre");
                    System.out.println("2) Apellido");
                    System.out.println("3) Nacionalidad");
                    System.out.println("4) Fecha de nacimiento");
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
                            dia = leer.nextInt();

                            System.out.println("Cambiamos el mes de nacimiento");
                            mes = leer.nextInt();

                            System.out.println("Cambiamos el año de nacimiento");
                            anio = leer.nextInt();

                            Date nac = new Date(anio - 1900, mes - 1, dia);
                            var.setNacimiento(nac);

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
        System.out.println("El listado quedo de la siguiente forma: ");
        for (Alumnos aux : aL) {
            System.out.println(aux);
        }
    }

    public void ordenarAs() {
        System.out.println("Ordenamos alfabeticamente por apellido de manera Ascendente");
        Collections.sort(aL, Comparador.apellidoAsc);
        for (Alumnos aux : aL) {
            System.out.println(aux.getApellido() + " " + aux.getNombre());
        }
    }

    public void ordenarDes() {
        System.out.println("Ordenamos alfabeticamente por nombre de manera Descendente");
        Collections.sort(aL, Comparador.nombreDesc);
        for (Alumnos aux : aL) {
            System.out.println(aux.getApellido() + " " + aux.getNombre());
        }
    }

    public void mostrarEdad() {

        System.out.println("Ingrese el nombre del alumno que desea elminiar ");

        String comparar1 = leer.next();
        System.out.println("Ingrese el apellido del alumno que desea eliminar");
        String comparar2 = leer.next();

        Date comp = new Date();

        for (Alumnos var : aL) {
            if (var.getNombre().equalsIgnoreCase(comparar1) && var.getApellido().equalsIgnoreCase(comparar2)) {
                int difmes = comp.getMonth() - var.getNacimiento().getMonth();
                int difdia = comp.getDate() - var.getNacimiento().getDate();
                int difanio = comp.getYear() - var.getNacimiento().getYear();

                if (difmes < 0 || (difmes == 0 && difdia < 0)) {
                    difanio = difanio - 1;
                    System.out.println("La edad es: " + difanio);

                } else {
                    System.out.println("La edad es: " + difanio);
                }

            } else {
                System.out.println("No se encontro el alumno");
            }
        }
//        (comp.getYear() - var.getNacimiento().getYear())

    }

    public void listasNac() {
        ArrayList<Alumnos> arg = new ArrayList();
        ArrayList<Alumnos> chi = new ArrayList();
        ArrayList<Alumnos> ven = new ArrayList();
        for (Alumnos aux : aL) {
            if (aux.getNacionalidad().equalsIgnoreCase("Argentina")) {

                arg.add(aux);

            } else if (aux.getNacionalidad().equalsIgnoreCase("Chilena")) {

                chi.add(aux);
            } else if (aux.getNacionalidad().equalsIgnoreCase("Venezolana")) {

                ven.add(aux);

            }
        }
        System.out.println("El listado de personas de nacionalidad Argentina es: ");
        for (Alumnos aux : arg) {
            System.out.println(aux);
        }
        System.out.println("El listado de personas de nacionalidad Chilena es:");
        for (Alumnos aux : chi) {
            System.out.println(aux);
        }
        System.out.println("El listado de personas de nacionalidad Venezolana es:");
        for (Alumnos aux : ven) {
            System.out.println(aux);
        }
    }

    public void reporteFin() {

        int cont = 0;
        Date comp = new Date();
        for (Alumnos var : aL) {
            int difmes = comp.getMonth() - var.getNacimiento().getMonth();
            int difdia = comp.getDate() - var.getNacimiento().getDate();
            int difanio = comp.getYear() - var.getNacimiento().getYear();

            if (difmes < 0 || (difmes == 0 && difdia < 0)) {
                difanio = difanio - 1;

            } else {
                difanio = difanio;
            }
            if (difanio >= 25) {
                cont++;
            }

        }
        System.out.println("La cantidad de aluumnos mayores a 25 años es de: " + cont);
        int cont1 = 0;
        for (Alumnos aux : aL) {
            if (aux.getApellido().substring(0, 1).equalsIgnoreCase("l") || aux.getApellido().substring(0, 1).equalsIgnoreCase("p")) {
                cont1++;
            }
        }
        int contArg = 0, contChi = 0, contVen = 0;
        for (Alumnos aux : aL) {
            if (aux.getNacionalidad().equalsIgnoreCase("Argentina")) {

                contArg++;

            } else if (aux.getNacionalidad().equalsIgnoreCase("Chilena")) {

                contChi++;
            } else if (aux.getNacionalidad().equalsIgnoreCase("Venezolana")) {

                contVen++;

            }
        }
        System.out.println("La cantidad de alumnos de nacionalidad Argentina es de: " + contArg);
        System.out.println("La cantidad de alumnos de nacionalidad Chilena0 es de: " + contChi);
        System.out.println("La cantidad de alumnos de nacionalidad Venezolana es de: " + contVen);
    }
}
