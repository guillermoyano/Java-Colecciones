/*
Crea un conjunto al que se le va a llamar jugadores. Inserta en el conjunto los jugadores del FC 
Barcelona.
Realiza un bucle sobre los jugadores del conjunto y muestra sus nombres.
Consulta si en el conjunto existe el jugador «Neymar JR». Avisa si existe o no.
Crea un segundo conjunto jugadores2 con los jugadores «Piqué» y «Busquets».
Consulta si todos los elementos de jugadores2 existen en jugadores.
Realiza una unión de los conjuntos jugadores y jugadores2.
Elimina todos los jugadores del conjunto jugadores2 y muestra el número de jugadores que tiene 
el conjunto jugadores2 (debería ahora ser cero)
 */
package Servicio;

import Entidad.Jugadores;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class JugadoresServicio {

    TreeSet<String> Jugadores = new TreeSet();
    TreeSet<String> Jugadores2 = new TreeSet();

    public void llenarSet() {

        Jugadores a = new Jugadores();
        Jugadores.add("Marc - André ter Stegen");
        Jugadores.add("Iñaki Peña");
        Jugadores.add("Héctor Bellerín");
        Jugadores.add("Ronald Araujo");
        Jugadores.add("Andreas Christensen");
        Jugadores.add("Marcos Alonso");
        Jugadores.add("Jordi Alba");
        Jugadores.add("Jules Kounde");
        Jugadores.add("Eric Garcia");
        Jugadores.add("Pedri");
        Jugadores.add("Franck Kessie");
        Jugadores.add("Sergi Roberto");
        Jugadores.add("Gavi");
        Jugadores.add("Ousmane Dembélé");
        Jugadores.add("Frenkie de Jong");
        Jugadores.add("Robert Lewandowski");
        Jugadores.add("Ansu Fati");
        Jugadores.add("Ferran Torres");
        Jugadores.add("Memphis Depay");
        Jugadores.add("Raphinha");
        Jugadores2.add("Gerard Piqué");
        Jugadores2.add("Sergio Busquets");
    }

    public void mostrar() {
        System.out.println("......................................................................");
        System.out.println("La lista de los jugadores de la plantilla actual del F.C. Barcelona son: ");
        for (String var : Jugadores) {
            System.out.println(var);
        }
        System.out.println("");
        System.out.println("......................................................................");
        System.out.println("");
        System.out.println("La lista de los jugadores, en una lista a parte son: ");
        for (String var : Jugadores2) {
            System.out.println(var);
        }
        System.out.println("");

    }

    public void neymar() {
        System.out.println("Vamos a ver si actualmente el jugador Neymar JR está en la plantilla del Club");
        System.out.println("");
        String nombre = "Neymar";
        int cont = 0;
        for (String var : Jugadores) {
            if (var.equalsIgnoreCase("Neymar JR")) {
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("No se encuentra actualmente Neymar jugando para el F.C. Barcelona");
        } else if (cont != 0) {
            System.out.println("Si se encuentra actualmente Neymar jugando para el F.C. Barcelona");
        }
    }

    public void estan() {
        System.out.println("");
        System.out.println("......................................................................");
        System.out.println("");
        int cont = 0;
        Iterator<String> it = Jugadores.iterator();
        while (it.hasNext()){
            if (Jugadores2.contains(it.next())){
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("No están los jugadores en la lista");
        } else if (cont != 0) {
            System.out.println("Sí están los jugadores en la lista");
        }
    }
    
    public void unir(){
        Jugadores.addAll(Jugadores2);
    }
    
    public void eliminar(){
        Jugadores2.removeAll(Jugadores2);
        
        System.out.println("El tamaño actual de la lista Jugadores 2 es: " +Jugadores2.size());
    }

}
