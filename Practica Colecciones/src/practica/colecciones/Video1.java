package practica.colecciones;

import java.util.ArrayList;

/**
 *
 * @author Guillote
 */
public class Video1 {

    public static void main(String[] args) {
        //Arrays
        String [] nombresArray = new String [5];
        for (int i = 0; i < nombresArray.length; i++) {
            nombresArray [i] = "Toto " + (i+1);
        }
        
        for (String var : nombresArray) {
            System.out.println(var);
        }
        
        //Colecciones
        ArrayList<String> nombresArrayList = new ArrayList();
        nombresArrayList.add("Toto");
        nombresArrayList.add("Toto");
        nombresArrayList.add("Toto");
        System.out.println(nombresArrayList.size());
        
        nombresArrayList.remove("Toto");
        System.out.println(nombresArrayList.size());
        
        //Máximo valor de Integer (Es una clase, empieza en mayúscula
        System.out.println(Integer.MAX_VALUE);
    }

}
