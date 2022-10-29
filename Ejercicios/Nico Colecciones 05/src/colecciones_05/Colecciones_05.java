/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones_05;

import Entidades.Paises;
import Servicios.ServicioPais;
import java.util.HashSet;

/**
 *
 * @author Pergo
 */
public class Colecciones_05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashSet<Paises> PaisesSet = new HashSet();
        ServicioPais sv = new ServicioPais();
        sv.cargarPaises(PaisesSet);
        sv.mostrar(PaisesSet);    
       
        sv.eliminarPais(sv.ordenar(PaisesSet));
    }

}
