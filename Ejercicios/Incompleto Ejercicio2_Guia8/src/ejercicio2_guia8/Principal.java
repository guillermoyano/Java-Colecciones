

package ejercicio2_guia8;

//@author pittu

import Entidad.Alumno;
import Servicio.ServicioAlumno;
import java.util.ArrayList;


public class Principal {

    public static void main(String[] args) {
        ArrayList<Alumno> alumnos=new ArrayList();
        ServicioAlumno accion=new ServicioAlumno();
        
        alumnos=accion.crearAlumno(alumnos);
         //accion.crearAlumno(alumnos);
        accion.mostrarAlumnos(alumnos);
        
        
        
    }

}
