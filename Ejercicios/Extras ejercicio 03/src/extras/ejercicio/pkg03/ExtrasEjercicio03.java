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
package extras.ejercicio.pkg03;

import Servicio.JugadoresServicio;

public class ExtrasEjercicio03 {

    public static void main(String[] args) {
        JugadoresServicio js = new JugadoresServicio();
        
        js.llenarSet();
        js.mostrar();
        js.neymar();
        js.estan();
        js.unir();
        js.mostrar();
        js.eliminar();
        js.mostrar();
    }

}
