/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author pittu
 */
public class Alumno {

    private String nombre;
    private Integer[] notas;

    public Alumno() {
        
    }
    
       

    public Alumno(String nombre, Integer[] notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer[] getNotas() {
        return notas;
    }

    public void setNotas(Integer n1,Integer n2, Integer n3) {
        this.notas[0] = n1;
        this.notas[1] = n2;
        this.notas[2] = n3;
    }

   

    
    
    

    

}
