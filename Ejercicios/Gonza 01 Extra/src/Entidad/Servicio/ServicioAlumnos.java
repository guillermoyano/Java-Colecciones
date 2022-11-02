package Entidad.Servicio;

import Entidad.Alumnos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import newpackage.utilidades.Comparadores;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioAlumnos {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Alumnos> TAlumnos = new ArrayList();
    ArrayList<Alumnos> Argentina = new ArrayList();
    ArrayList<Alumnos> Chile = new ArrayList();
    ArrayList<Alumnos> Venezuela = new ArrayList();
    Date FechaActual = new Date();

    public Alumnos Estudiante() {
        Alumnos d1 = new Alumnos();
        System.out.println("Alta de Alumnos");
        System.out.println("---------------");
        System.out.println("Nombre del Alumno:");
        String nombre = leer.next();
        d1.setNombre(nombre.substring(0, 1).toUpperCase().concat(nombre.substring(1).toLowerCase()));
        System.out.println("Apellido del Alumno:");
        String apellido = leer.next();
        d1.setApellido(apellido.substring(0, 1).toUpperCase().concat(apellido.substring(1).toLowerCase()));
        System.out.println("Nacionalidad del Alumno:");
        System.out.println("1- Argentina");
        System.out.println("2- Chile");
        System.out.println("3- Venezuela");
        System.out.println("Ingrese su opcion:");
        int op1;
        do {
            op1 = leer.nextInt();
            switch (op1) {
                case 1:
                    d1.setNacionalidad("Argentina");
                    break;
                case 2:
                    d1.setNacionalidad("Chile");
                    break;
                case 3:
                    d1.setNacionalidad("Venezuela");
                    break;
                default:
                    System.out.println("Solo 1, 2 o 3... Intente nuevamente...");
            }
        } while (!(op1 < 4) || !(op1 > 0));
        System.out.println("Fecha de Nacimiento del Alumno");
        int dia;
        int mes;
        int año;
        int cont;
        do {
            cont = 0;
            dia = 0;
            mes = 0;
            año = 0;
            do {
                System.out.println("Ingrese el dia:");
                dia = leer.nextInt();
                if (dia < 1 || dia > 31) {
                    System.out.println("el dia es invalido, intente nuevamente...");
                }
            } while (dia < 1 || dia > 31);
            System.out.println("Ingrese el mes:");
            do {
                mes = leer.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("el mes es invalido, intente nuevamente...");
                }
            } while (mes < 1 || mes > 12);
            System.out.println("Ingrese el año");
            do {
                año = leer.nextInt();
                if (año < 1900 || año > 2012) {
                    System.out.println("el año es invalido, intente nuevamente...");
                }
            } while (año < 1900 || año > 2012);
            if (!(año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
                if (mes == 2) {
                    if (dia > 28) {
                        System.out.println("El dia, el mes o el año son incorrectos...");
                        cont = 1;
                    }
                }
            }
        } while (!(cont == 0));

        Date FechaNac = new Date(año - 1900, mes - 1, dia);
        d1.setFechaNacimiento(FechaNac);
        return new Alumnos(d1.getNombre(), d1.getApellido(), d1.getNacionalidad(), d1.getFechaNacimiento());

    }

    public void AltaAlumnos() {
        String opcion;
        do {
            TAlumnos.add(Estudiante());
            System.out.println("-------------------------------");
            System.out.println("Desea ingresar otro alumno?? (S/N)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("S"));
    }

    public void ModificarAlumno() {
        System.out.println("Modificacion de Alumno");
        String op1;
        int cont;
        do {
            cont=0;
            System.out.println("Ingrese el nombre");
            String nombre = leer.next();
            System.out.println("Ingrese el apellido");
            String apellido = leer.next();
            for (Alumnos aux : TAlumnos) {
                if (aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido)) {
                    int op2;
                    do {
                        cont = 1;
                        System.out.println("1- Cambiar nombre");
                        System.out.println("2- Cambiar apellido");
                        System.out.println("3- Cambiar nacionalidad");
                        System.out.println("4- Cambiar fecha de nacimiento");
                        System.out.println("Ingrese su opcion");
                        op2 = leer.nextInt();
                        switch (op2) {
                            case 1:
                                System.out.println("Ingrese nuevo nombre");
                                String nombren = leer.next();
                                aux.setNombre(nombren.substring(0, 1).toUpperCase().concat(nombren.substring(1).toLowerCase()));
                                break;
                            case 2:
                                System.out.println("Ingrese nuevo apellido");
                                String apellidon = leer.next();
                                aux.setApellido(apellidon.substring(0, 1).toUpperCase().concat(apellidon.substring(1).toLowerCase()));
                                break;
                            case 3:
                                System.out.println("Ingrese nueva nacionalidad");
                                System.out.println("1- Argentina");
                                System.out.println("2- Chile");
                                System.out.println("3- Venezuela");
                                System.out.println("Ingrese su opcion:");
                                int op3;
                                do {
                                    op3 = leer.nextInt();
                                    switch (op3) {
                                        case 1:
                                            aux.setNacionalidad("Argentina");
                                            break;
                                        case 2:
                                            aux.setNacionalidad("Chile");
                                            break;
                                        case 3:
                                            aux.setNacionalidad("Venezuela");
                                            break;
                                        default:
                                            System.out.println("Solo 1, 2 o 3... Intente nuevamente...");
                                    }
                                } while (!(op3 < 4) || !(op3 > 0));
                            case 4:
                                System.out.println("Ingrese nueva fecha de nacimiento");
                                int dia;
                                int mes;
                                int año;
                                int cont1;
                                do {
                                    cont1 = 0;
                                    dia = 0;
                                    mes = 0;
                                    año = 0;
                                    do {
                                        System.out.println("Ingrese el dia:");
                                        dia = leer.nextInt();
                                        if (dia < 1 || dia > 31) {
                                            System.out.println("el dia es invalido, intente nuevamente...");
                                        }
                                    } while (dia < 1 || dia > 31);
                                    System.out.println("Ingrese el mes:");
                                    do {
                                        mes = leer.nextInt();
                                        if (mes < 1 || mes > 12) {
                                            System.out.println("el mes es invalido, intente nuevamente...");
                                        }
                                    } while (mes < 1 || mes > 12);
                                    System.out.println("Ingrese el año");
                                    do {
                                        año = leer.nextInt();
                                        if (año < 1900 || año > 2012) {
                                            System.out.println("el año es invalido, intente nuevamente...");
                                        }
                                    } while (año < 1900 || año > 2012);
                                    if (!(año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
                                        if (mes == 2) {
                                            if (dia > 28) {
                                                System.out.println("El dia, el mes o el año son incorrectos...");
                                                cont1 = 1;
                                            }
                                        }
                                    }
                                } while (!(cont1 == 0));
                                Date FechaNac = new Date(año - 1900, mes - 1, dia);
                                aux.setFechaNacimiento(FechaNac);
                                break;
                            default:
                                System.out.println("Opcion invalida, intente nuevamente...");
                        }
                    } while (!(op2 < 5) || !(op2 > 0));
                }
            }
            if (cont == 0) {
                System.out.println("El alumno no se encuentra en la lista...");
            }
            System.out.println("Desea mofificar otro alumno?? (S/N)");
            op1 = leer.next();
        } while (op1.equalsIgnoreCase("S"));
    }

    public void BajaAlumno() {
        System.out.println("Eliminacion de Alumno");
        String op1;
        int cont;
        do {
            cont=0;
            System.out.println("Ingrese el nombre");
            String nombre = leer.next();
            nombre = nombre.substring(0, 1).toUpperCase().concat(nombre.substring(1).toLowerCase());
            System.out.println("Ingrese el apellido");
            String apellido = leer.next();
            apellido = apellido.substring(0, 1).toUpperCase().concat(apellido.substring(1).toLowerCase());
            for (Alumnos aux : TAlumnos) {
                if (aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido)) {
                    TAlumnos.remove(aux);
                    cont = 1;
                    System.out.println("Alumno eliminado");
                    break;
                }
            }
            if (cont == 0) {
                System.out.println("El alumno no se encuentra en la lista...");
            }
            System.out.println("Desea eliminar otro alumno?? (S/N)");
            op1 = leer.next();
        } while (op1.equalsIgnoreCase("S"));
    }

    public void MostrarAlumnos() {
        for (Alumnos aux : TAlumnos) {
            System.out.println(aux);
        }
    }

    public void MostrarApellidoAsc() {
        System.out.println("Lista Alumnos por apellidos ascendentemente");
        Collections.sort(TAlumnos, Comparadores.OPApellidoAsc);
        MostrarAlumnos();
    }

    public void MostrarNombreDesc() {
        System.out.println("Lista Alumnos por nombres descendentemente");
        Collections.sort(TAlumnos, Comparadores.OPNombreDesc);
        MostrarAlumnos();

    }

    public void MostrarEdad() {
        System.out.println("Mostrar edad de Alumno");
        String op1;
        int cont;
        do {
            cont=0;
            System.out.println("Ingrese el nombre");
            String nombre = leer.next();
            System.out.println("Ingrese el apellido");
            String apellido = leer.next();
            for (Alumnos aux : TAlumnos) {
                if (aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido)) {
                    int edad = (FechaActual.getYear()) - aux.getFechaNacimiento().getYear();
                    System.out.println("El alumno " + nombre + " " + apellido + ", tiene " + edad + " años.");
                    cont = 1;
                }
            }
            if (cont == 0) {
                System.out.println("El alumno no se encuentra en la lista...");
            }
            System.out.println("Desea ver la edad de otro alumno?? (S/N)");
            op1 = leer.next();
        } while (op1.equalsIgnoreCase("S"));
    }

    public void ListasParalelas() {
        System.out.println("Listas Paralelas por Nacionalidad");
        for (Alumnos aux : TAlumnos) {
            if (aux.getNacionalidad().equals("Argentina")) {
                Argentina.add(aux);
            }
            if (aux.getNacionalidad().equals("Chile")) {
                Chile.add(aux);
            }
            if (aux.getNacionalidad().equals("Venezuela")) {
                Venezuela.add(aux);
            }
        }
        int op3;
        String op1;
        do {
            System.out.println("1- Argentina");
            System.out.println("2- Chile");
            System.out.println("3- Venezuela");
            System.out.println("Ingrese su opcion:");
            op3 = leer.nextInt();
            switch (op3) {
                case 1:
                    if (Argentina.isEmpty()) {
                        System.out.println("No hay ningun alumno con esa nacionalidad...");
                    } else {
                        for (Alumnos aux : Argentina) {
                            System.out.println(aux);
                        }
                    }
                    break;
                case 2:
                    if (Chile.isEmpty()) {
                        System.out.println("No hay ningun alumno con esa nacionalidad...");
                    } else {
                        for (Alumnos aux : Chile) {
                            System.out.println(aux);
                        }
                    }
                    break;
                case 3:
                    if (Venezuela.isEmpty()) {
                        System.out.println("No hay ningun alumno con esa nacionalidad...");
                    } else {
                        for (Alumnos aux : Venezuela) {
                            System.out.println(aux);
                        }
                    }
                    break;
                default:
                    System.out.println("Solo 1, 2 o 3... Intente nuevamente...");
            }
            System.out.println("Desea ver otra lista?? (S/N)");
            op1 = leer.next();
        } while (op1.equalsIgnoreCase("S"));
    }

    public void ReporteFinal() {
        System.out.println("Reporte Final");
        int cont = 0;
        int cont1 = 0;
        for (Alumnos aux : TAlumnos) {
            if (((FechaActual.getYear()) - aux.getFechaNacimiento().getYear()) > 25) {
                cont++;
            }
            if ((aux.getApellido().substring(0, 1).equalsIgnoreCase("L")) || (aux.getApellido().substring(0, 1).equalsIgnoreCase("P"))) {
                cont1++;
            }
        }
        System.out.println("La cantidad de Alumnos mayores a 25 años, es: " + cont);
        System.out.println("La cantidad de Alumnos con apellidos que empiecen con (P) o (L), es: " + cont1);
        if (Argentina.isEmpty() && Chile.isEmpty() && Venezuela.isEmpty()) {
            System.out.println("Para ver la cantidad de alumnos por nacionalidad, primero debe inicializar las listas paralelas...");
        } else {
            System.out.println("La cantidad de Alumnos Argentinos es: " + Argentina.size());
            System.out.println("La cantidad de Alumnos Chilenos es: " + Chile.size());
            System.out.println("La cantidad de Alumnos Venezolanos es: " + Venezuela.size());
        }
    }

    public void Menu() {
        int opc;
        do {
            System.out.println("Menu de Alumnos");
            System.out.println("---------------");
            System.out.println("1- Ingresar Alumno");
            System.out.println("2- Modificar Alumno");
            System.out.println("3- Borrar Alumno");
            System.out.println("4- Mostrar Alumnos por apellido ascendentemente");
            System.out.println("5- Mostrar Alumnos por nombre descendentemente");
            System.out.println("6- Mostrar edad del Alumno");
            System.out.println("7- Mostrar lista paralelas por nacionalidad");
            System.out.println("8- Mostrar Reporte final");
            System.out.println("9- Mostrar Lista de Alumnos Completa");
            System.out.println("10- Salir");
            System.out.println("Ingrese su opcion: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    AltaAlumnos();
                    continue;
                case 2:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("No hay ningun alumno para modificar...");
                    } else {
                        ModificarAlumno();
                    }
                    continue;
                case 3:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("No hay ningun alumno para borrar...");
                    } else {
                        BajaAlumno();
                    }
                    continue;
                case 4:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("Lista vacia, primero ingrese alumnos...");
                    } else {
                        MostrarApellidoAsc();
                    }
                    continue;
                case 5:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("Lista vacia, primero ingrese alumnos...");
                    } else {
                        MostrarNombreDesc();
                    }
                    continue;
                case 6:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("No hay ningun alumno para mostrar su edad...");
                    } else {
                        MostrarEdad();
                    }
                    continue;
                case 7:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("Lista vacia, primero ingrese alumnos...");
                    } else {
                        ListasParalelas();
                    }
                    continue;
                case 8:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("El reporte no se hara, mientras la lista este vacia...");
                    } else {
                        ReporteFinal();
                    }
                    continue;
                case 9:
                    if (TAlumnos.isEmpty()) {
                        System.out.println("Debera ingresar al menos un alumno, ya que la lista esta vacia...");
                    } else {
                        MostrarAlumnos();
                    }
                    continue;
                case 10:
                    System.out.println("Programa finalizado... Chau...");
                    break;
                default:
                    System.out.println("Opcion invalida... Intenta nuevamente...");
            }
        } while (opc != 10);
    }
}
