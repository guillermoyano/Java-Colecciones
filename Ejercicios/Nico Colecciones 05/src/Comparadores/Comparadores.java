/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparadores;

import Entidades.Paises;
import java.util.Comparator;

/**
 *
 * @author Pergo
 */
public class Comparadores {

    public static Comparator<Paises> ordenarAlf= new Comparator<Paises>() {
        @Override
        public int compare(Paises t, Paises t1) {
            return t.getPais().compareToIgnoreCase(t1.getPais());
            
        }
    };
    

}
