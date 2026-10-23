package listas_enlazadas1.modelo;

public class ListaEnlazada {

    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
        }
    }

    private Nodo cabeza;
    private int cantidad;

    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        cantidad++;
    }

    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        cantidad++;
    }

    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public int tamanio() {
        return cantidad;
    }

    public void mostrar() {
        System.out.print("Contenido de la lista: ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public int contarOcurrencias(int valor) {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                contador++;
            }
            actual = actual.siguiente;
        }
        return contador;
    }

    /*
     * En ListaEstatica cada eliminación obliga a correr hacia la izquierda todos los
     * elementos que quedan detrás para no dejar huecos, así que borrar k ocurrencias
     * puede costar O(n * k). Acá alcanza con reenganchar el puntero del nodo anterior:
     * se recorre la lista una sola vez, O(n), sin mover ningún dato.
     */
    public void eliminarTodas(int valor) {
        while (cabeza != null && cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            cantidad--;
        }
        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.dato == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                cantidad--;
            } else {
                actual = actual.siguiente;
            }
        }
    }
}
