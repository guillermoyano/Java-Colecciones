package newpackage.utilidades;

import Entidad.Alumnos;
import java.util.Comparator;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class Comparadores {

    public static Comparator<Alumnos> OPApellidoAsc = new Comparator<Alumnos>() {
        @Override
        public int compare(Alumnos t, Alumnos t1) {
            return t.getApellido().compareTo(t1.getApellido());
        }
    };
    public static Comparator<Alumnos> OPNombreDesc = new Comparator<Alumnos>() {
        @Override
        public int compare(Alumnos t, Alumnos t1) {
            return t1.getNombre().compareTo(t.getNombre());
        }
    };
            
}
