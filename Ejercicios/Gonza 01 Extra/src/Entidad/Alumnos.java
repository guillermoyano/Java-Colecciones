package Entidad;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class Alumnos {
    public String Nombre;
    public String Apellido;
    public String Nacionalidad;
    public Date FechaNacimiento;

    public Alumnos() {
    }

    public Alumnos(String Nombre, String Apellido, String Nacionalidad, Date FechaNacimiento) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Nacionalidad = Nacionalidad;
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Nombre);
        hash = 53 * hash + Objects.hashCode(this.Apellido);
        hash = 53 * hash + Objects.hashCode(this.Nacionalidad);
        hash = 53 * hash + Objects.hashCode(this.FechaNacimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumnos other = (Alumnos) obj;
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellido, other.Apellido)) {
            return false;
        }
        if (!Objects.equals(this.Nacionalidad, other.Nacionalidad)) {
            return false;
        }
        if (!Objects.equals(this.FechaNacimiento, other.FechaNacimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Nacionalidad=" + Nacionalidad + ", FechaNacimiento=" + FechaNacimiento.toLocaleString() + '}';
    }
    
    

}
