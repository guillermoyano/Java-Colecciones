/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos 
productos que venderemos y el precio que tendrán. Además, se necesita que la 
aplicación cuente con las funciones básicas. 
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio, 
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar 
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio. 
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package Servicio;

import Entidades.Productos;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductosServicio {

    HashMap<String, Double> almacen = new HashMap();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void menu() {
        int opcion = 0;
        do {

            System.out.println("---------- Menú ----------");
            System.out.println("---------- Elija la opción deseada ----------");
            System.out.println("---------- 1) Cargar productos y precios ----------");
            System.out.println("---------- 2) Mostrar la lista de productos ----------");
            System.out.println("---------- 3) Modificar precio ----------");
            System.out.println("---------- 4) Eliminar producto ----------");
            System.out.println("---------- 5) Salir ----------");
            opcion = leer.nextByte();
            switch (opcion) {
                case 1:
                    System.out.println("");
                    ingresarProductos();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    mostrarProductos();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    modificarPrecio();
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    eliminarProducto();
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Adios pedazo de soquete");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Esa opción no existe. Metiste el dedo como el culo");
            }

        } while (opcion != 5);

    }

    public void ingresarProductos() {

        String opcion = " ";
        do {
            Productos p = new Productos();
            System.out.println("Ingrese el producto");
            p.setBien(leer.next());
            System.out.println("Ingrese el precio del producto");
            p.setPrecio(leer.nextDouble());
            almacen.put(p.getBien(), p.getPrecio());
            System.out.println("Desea ingresar más productos? (Si / No)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("Si"));

    }

    public void mostrarProductos() {
        for (Map.Entry<String, Double> var : almacen.entrySet()) {
            String key = var.getKey();
            Double value = var.getValue();
            System.out.println("El producto es: " + key + ". Y su precio es: " + value);
        }
    }

    public void modificarPrecio() {
        
        if (almacen.size() == 0) {
            System.out.println("La lista está vacía, no hay nada para modificar");
        } else {
        String modificar;
        System.out.println("Ingrese el producto que desea modificar el precio en la lista");
        modificar = leer.next();
        int cont = 0;

        for (Map.Entry<String, Double> var : almacen.entrySet()) {
            if (var.getKey().equalsIgnoreCase(modificar)) {
                cont++;
                System.out.println("Se encontró el producto " + modificar);
                System.out.println("Ingrese el nuevo precio del producto " + modificar);
                var.setValue(leer.nextDouble());
                System.out.println("El nuevo precio del producto " + modificar + " es " + var.getValue());
            }
        }
        if (cont == 0) {
            System.out.println("No se encontró el producto " + modificar);
        }
        }
    }

    public void eliminarProducto() {
        /*
        if (mapaProductos.containsKey(nombre)) {
            System.out.println("Se eliminó el producto: " + nombre);
            mapaProductos.remove(nombre);
        } else {
            System.out.println("No se encontró el producto");
        }

        */
        
        if (almacen.size() == 0) {
            System.out.println("La lista está vacía, no hay nada para eliminar");
        } else {
            String eliminar;
            System.out.println("Ingrese el producto que desea eliminar de la lista");
            eliminar = leer.next();
            int cont = 0;

            for (Map.Entry<String, Double> var : almacen.entrySet()) {
                if (var.getKey() != null && var.getKey().equals(eliminar)) {
                    cont++;
                    almacen.remove(var.getKey());
                    System.out.println("Se removió correctamente el producto " + eliminar + " de la lista");
                    break;
                }
            }
            if (cont == 0) {
                System.out.println("El producto no existe " + eliminar + " en la lista");
            }
        }
    }
}
