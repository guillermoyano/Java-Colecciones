package Entidad;

import java.util.ArrayList;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class Alumno {
public String nombrealumno;
public ArrayList <Integer> notas;

    public Alumno() {
        notas = new ArrayList();
    }

    public Alumno(String nombrealumno, ArrayList<Integer> notas) {
        this.nombrealumno = nombrealumno;
        this.notas = notas;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombrealumno=" + nombrealumno + ", notas=" + notas + '}';
    }


}
