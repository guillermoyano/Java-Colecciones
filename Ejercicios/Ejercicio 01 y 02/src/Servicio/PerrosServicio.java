/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El 
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y 
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide 
salir, se mostrará todos los perros guardados en el ArrayList. 
Después de mostrar los perros, al usuario se le pedirá 
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro 
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista 
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará 
la lista ordenada.
*/
package Servicio;

import Entidades.Perros;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class PerrosServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList <String> Razas = new ArrayList();
    
    public void cargarRazas(){
        String opcion = " ";
        do{
            Perros p = new Perros();
            System.out.println("Tipee la raza de perro que quiere ingresar a la lista");
            p.setPerros(leer.next());
            Razas.add(p.getPerros());
            System.out.println("Desea seguir agregando más razas? (Si / No)");
            opcion = leer.next();
        }while(opcion.equalsIgnoreCase("Si"));
    }
    
    public void mostrarRazas(){
        
        Collections.sort(Razas);
        
        for (String var : Razas) {
            System.out.println(var);
        }
        System.out.println("");
    }
    
    public void iterar(){
        String comparar = " ";
        Iterator <String> it = Razas.iterator();
        int cont = 0;
        System.out.println("Ingrese la raza de perros que quiere buscar en la lista");
        comparar = leer.next();
        while (it.hasNext()){
            if(it.next().equals(comparar)){
                it.remove();
                cont++;
                System.out.println("");
                System.out.println("Se encontró la raza " +comparar+ " y se eliminó de la lista");
                for (String var : Razas) {
                    System.out.println(var);
                }
            }
        }
        
        if (cont == 0){
            System.out.println("La raza " +comparar+ " no se encontró en la lista");
            for (String var : Razas) {
                System.out.println(var);
            }
        }
    }

}
