package Entidad.Servicio;

import Entidad.Ficha;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioFicha {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Ficha d1 = new Ficha();
    ArrayList<String> FichasDomino = new ArrayList();
    ArrayList<String> Mesa = new ArrayList();
    ArrayList<String> ManoRobot = new ArrayList();

    public Ficha CargaFicha() {
        d1.setNum1(String.valueOf((int) (Math.random() * 6)));
        d1.setNum2(String.valueOf((int) (Math.random() * 6)));
        System.out.println("Ficha al Azar");
        System.out.println("[" + d1.getNum1() + " : " + d1.getNum2() + "]");
        return d1;
    }

    public void GirarFicha() {
        System.out.println("Ficha Inversa");
        System.out.println("[" + d1.getNum2() + " : " + d1.getNum1() + "]");
    }

    public void EsDoble() {

        if (d1.getNum1().equals(d1.getNum2())) {
            System.out.println("Es un ficha doble");
        } else {
            System.out.println("No es una ficha doble");
        }
    }

    public void FichasD() {
        for (Integer i = 0; i < 7; i++) {
            for (Integer j = 0; j < 7; j++) {
                d1.setNum1(String.valueOf(i));
                d1.setNum2(String.valueOf(j));
                if (i == 0) {
                    FichasDomino.add(d1.getNum1() + ":" + d1.getNum2());
                }
                if ((i == 1 && j > 0) || (i == 2 && j > 1) || (i == 3 && j > 2) || (i == 4 && j > 3) || (i == 5 && j > 4) || (i == 6 && j > 5)) {
                    FichasDomino.add(d1.getNum1() + ":" + d1.getNum2());
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Todas las fichas del Domino");
        for (String aux : FichasDomino) {
            System.out.print("[" + aux + "] ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void ManoRobot() throws InterruptedException {
        int x = FichasDomino.size();
        for (int j = 0; j < 5; j++) {
            int i = (int) (Math.random() * x);
            ManoRobot.add(FichasDomino.get(i));
            FichasDomino.remove(i);
            x--;
        }
        System.out.println("Repartiendo....");
        Collections.sort(ManoRobot);
        System.out.println("Fichas del Robot, al azar, ordenadas.");
        Thread.sleep(750);
        for (String aux : ManoRobot) {
            System.out.print("[" + aux + "] ");
        }
        System.out.println("\nFichas que quedan en la Mesa");
        Thread.sleep(750);
        for (String aux : FichasDomino) {
            System.out.print("[" + aux + "] ");
        }
        

    }

    public void PrimerFicha() {
        System.out.println("");
        int a;
        int b = 0;
        int ubicacion = 0;
        do {
            for (int i = 0; i < ManoRobot.size(); i++) {
                if (ManoRobot.get(i).substring(0, 1).equals(ManoRobot.get(i).substring(2, 3))) {
                    int valor = Integer.parseInt((String) ManoRobot.get(i).substring(0, 1));
                    int valor1 = Integer.parseInt((String) ManoRobot.get(i).substring(2, 3));
                    int valor2 = valor + valor1;
                    if (valor2 >= 0) {
                        a = valor2;
                        ubicacion = i + 1;
                    }
                }
            }
            if (ubicacion != 0) {
                System.out.println("Mayor Ficha doble del Robot, para empezar");
                System.out.println("[" + ManoRobot.get(ubicacion - 1) + "]");
                Mesa.add(ManoRobot.get(ubicacion - 1));
                ManoRobot.remove(ubicacion - 1);
                b = 1;
                Jugadas();
//                System.out.println("Fichas de la Mesa");
//                for (String aux : FichasDomino) {
//                System.out.print("[" + aux + "] ");    
//                }
//                System.out.println("");
//                break;
            } else {
                RobarFicha();
                b = 1;
            }

        } while (b != 1);
    }

    public void RobarFicha() {
        String opcion;
        System.out.println("\nNo hay Ficha Doble, para empezar");
        System.out.println("Desea que el Robot robe otra ficha???(S/N)");
        opcion = leer.next();
        if (opcion.equalsIgnoreCase("S")) {
            System.out.println("Robar Ficha de la mesa");
            int x = FichasDomino.size();
            int i = (int) (Math.random() * x);
            ManoRobot.add(FichasDomino.get(i));
            FichasDomino.remove(i);
            System.out.println("Fichas que le quedan al Robot");
            for (String aux : ManoRobot) {
                System.out.print("[" + aux + "] ");
            }
            PrimerFicha();

        } else {
            System.out.println("Juego Terminado...");
        }
    }

    public void RobarFicha2() {
        int x = FichasDomino.size();
        int i = (int) (Math.random() * x);
        ManoRobot.add(FichasDomino.get(i));
        FichasDomino.remove(i);
    }

    public void Jugadas() {
        System.out.println("\nEmpieza el Juego!!!");
        System.out.println("");
        System.out.println("Fichas en la Mesa");
        for (String aux : Mesa) {
            System.out.print("[" + aux + "] ");
        }
        System.out.println("");
        System.out.println("Fichas del Robot");
        for (String aux : ManoRobot) {
            System.out.print("[" + aux + "] ");
        }
        int a = 0;
        int ubicacion = 0;
        String opcion;
        String opcion1;
        do {
            int b = 0;
            for (int i = 0; i < ManoRobot.size(); i++) {
                if (Mesa.get(a).substring(2, 3).equals(ManoRobot.get(i).substring(0, 1))) {
                    Mesa.add(a + 1, ManoRobot.get(i));
                    ManoRobot.remove(i);
                    a++;
                    b++;
                    break;
                }
            }
            for (int i = 0; i < ManoRobot.size(); i++) {
                if (Mesa.get(a).substring(2, 3).equals(ManoRobot.get(i).substring(2, 3))) {
                    Mesa.add(a + 1, ManoRobot.get(i).substring(2, 3) + ":" + ManoRobot.get(i).substring(0, 1));
                    ManoRobot.remove(i);
                    a++;
                    b++;
                    break;
                }
            }
            System.out.println("");
            System.out.println("Fichas en la Mesa");
            for (String aux : Mesa) {
                System.out.print("[" + aux + "] ");
            }
            System.out.println("");
            System.out.println("Fichas del Robot");
            for (String aux : ManoRobot) {
                System.out.print("[" + aux + "] ");
            }
            if (b == 0) {
                System.out.println("");
                System.out.println("No hay fichas disponible para jugar");
                System.out.println("Desea robar de la mesa, otra ficha...(S/N)");
                opcion1 = leer.next();
                if (opcion1.equalsIgnoreCase("S")) {
                    RobarFicha2();
                    for (String aux : ManoRobot) {
                        System.out.print("[" + aux + "] ");

                    }
                }
            }
            System.out.println("\nSiguiente Jugada??? (S/N)");
            opcion = leer.next();
            if(FichasDomino.isEmpty() || ManoRobot.isEmpty()){
                if(ManoRobot.isEmpty()){
                    System.out.println("El Robot a ganado!!!, no le quedan fichas en su mano...");
                    System.out.println("Juego Terminado....");
                    opcion="N";
                }
                if(FichasDomino.isEmpty()){
                    System.out.println("El Robot a perdido!!!, no hay podido descartas todas las fichas de su mano...");
                    System.out.println("Game Over...");
                    opcion="N";
                }
            }
        } while (opcion.equalsIgnoreCase("S"));
    }
}
