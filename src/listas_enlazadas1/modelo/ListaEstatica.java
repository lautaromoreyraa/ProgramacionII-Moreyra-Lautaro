package listas_enlazadas1.modelo;

public class ListaEstatica{
    private final int capacidad;
    private int cantidad;
    private int [] datos;

    public ListaEstatica(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void insertar(int valor) {
        if (cantidad >= capacidad) {
            throw new IllegalStateException("Error: La lista está llena. No se puede insertar " + valor);
        }
        datos[cantidad] = valor;
        cantidad++;
    }

    public int buscar(int valor) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void insertarEnPosicion(int indice, int valor) {
        if (cantidad >= capacidad) {
            throw new IllegalStateException("Error: La lista está llena. No se puede insertar " + valor);
        }
        // se permite indice == cantidad para poder insertar al final
        if (indice < 0 || indice > cantidad) {
            throw new IndexOutOfBoundsException("Error: Índice " + indice + " fuera de rango");
        }
        for (int i = cantidad; i > indice; i--) {
            datos[i] = datos[i - 1];
        }
        datos[indice] = valor;
        cantidad++;
    }

    public int eliminarEnPosicion(int indice) {
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException("Error: Índice " + indice + " fuera de rango");
        }
        int eliminado = datos[indice];
        for (int i = indice; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        cantidad--;
        return eliminado;
    }

    public void mostrar() {
        System.out.print("Contenido de la lista: ");
        for (int i = 0; i < cantidad; i++){
            System.out.print(datos[i]);
            if (i < cantidad - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Capacidad actual: " + cantidad + "/" + capacidad);
    }


}
