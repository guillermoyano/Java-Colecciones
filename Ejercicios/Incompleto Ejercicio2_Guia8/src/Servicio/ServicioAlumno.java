/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author pittu
 */

public class ServicioAlumno {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    
    
    public ArrayList<Alumno> crearAlumno(ArrayList<Alumno> a1){
        int opcion=0;
        String nombre;
       
        do {
            Integer[] notas=new Integer[3];
            
            System.out.println("Ingrese nombre del alumno");
            nombre=leer.next();
           for (int i = 0; i < notas.length; i++) {
                System.out.println("Ingrese nota "+ (i+1));
                notas[i] = leer.nextInt();
                
            }
           
            /*System.out.println("Ingrese nora 1");
            Integer nota1=leer.nextInt();
            System.out.println("Ingrese nora 2");
            Integer nota2=leer.nextInt();
            System.out.println("Ingrese nora 3");
            Integer nota3=leer.nextInt();*/
            Alumno alumno = new Alumno(nombre,notas);
            a1.add(alumno);
            /*Alumno a2=new Alumno();
            a2.setNombre(nombre);
            a2.setNotas(nota1,nota2,nota3);
            a1.add(a2);*/
            
            System.out.println("Ingrese 1 si desea agregar otro alumno o cualquier numero para salir");
            opcion=leer.nextInt();
            
            
            
        } while (opcion==1);
        
        return a1;
    
    }
    
    public void mostrarAlumnos(ArrayList<Alumno> a1){
        
        for (Alumno alumno : a1) {
            System.out.println(alumno.getNombre());
            
            for (int i = 0; i < 3; i++) {
                System.out.println(alumno.getNotas()[i]);
                
            }
            /*for (Integer notaA : alumno.getNotas()) {
                System.out.println(notaA);
            }*/
            }
        
            
        }
    
    public void notaFinal(ArrayList<Alumno> a1){
        System.out.println("Ingrese nombre de alumno");
        String buscar=leer.next();
        
         Iterator<Alumno> it = a1.iterator();
         
         while (it.hasNext()) {
           String aux2 = it.next().getNombre();

            if (aux2.equalsIgnoreCase(buscar)) {
                it.remove();
               // cont++;

            }

        }
         
         
        
    
    
    
    }
    
    
    
    }
    
    
    


