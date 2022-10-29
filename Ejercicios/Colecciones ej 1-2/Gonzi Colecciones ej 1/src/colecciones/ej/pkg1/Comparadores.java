package colecciones.ej.pkg1;

import java.util.Comparator;

public class Comparadores {

    public static Comparator<String> ordenarDesc = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    };

}
