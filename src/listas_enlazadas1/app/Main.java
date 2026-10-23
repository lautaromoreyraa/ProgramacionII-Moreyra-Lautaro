package listas_enlazadas1.app;

import listas_enlazadas1.modelo.ListaEnlazada;
import listas_enlazadas1.modelo.ListaEstatica;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Lista estática ===");
        ListaEstatica listaEstatica = new ListaEstatica(5);

        listaEstatica.insertar(1);
        listaEstatica.insertar(2);
        listaEstatica.insertar(3);
        listaEstatica.insertar(4);
        listaEstatica.mostrar();

        System.out.println("Buscar 3: índice " + listaEstatica.buscar(3));
        System.out.println("Buscar 9: índice " + listaEstatica.buscar(9));

        listaEstatica.insertarEnPosicion(1, 10);
        listaEstatica.mostrar();

        try {
            listaEstatica.insertar(5);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Eliminado: " + listaEstatica.eliminarEnPosicion(0));
        listaEstatica.mostrar();

        try {
            listaEstatica.eliminarEnPosicion(7);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("=== Lista enlazada ===");
        ListaEnlazada listaEnlazada = new ListaEnlazada();

        listaEnlazada.insertarFinal(2);
        listaEnlazada.insertarFinal(3);
        listaEnlazada.insertarInicio(1);
        listaEnlazada.insertarFinal(4);
        listaEnlazada.mostrar();

        System.out.println("Tamaño: " + listaEnlazada.tamanio());
        System.out.println("¿Está el 3? " + listaEnlazada.buscar(3));
        System.out.println("¿Está el 9? " + listaEnlazada.buscar(9));

        listaEnlazada.insertarInicio(7);
        listaEnlazada.insertarFinal(7);
        listaEnlazada.insertarInicio(7);
        listaEnlazada.mostrar();

        System.out.println("Ocurrencias del 7: " + listaEnlazada.contarOcurrencias(7));
        listaEnlazada.eliminarTodas(7);
        listaEnlazada.mostrar();
        System.out.println("Tamaño: " + listaEnlazada.tamanio());
    }
}
