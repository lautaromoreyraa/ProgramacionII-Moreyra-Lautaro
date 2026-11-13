package unidad4;

// =====================================================================================
// PASO 2 - ÁRBOL BINARIO DE BÚSQUEDA (ABB)
// =====================================================================================
// Un ABB es un árbol binario con una REGLA DE ORDEN que se cumple en TODOS los nodos:
//
//     todo lo que está en el subárbol IZQUIERDO  <  el nodo  <  todo lo del subárbol DERECHO
//
// Gracias a esa regla, para buscar un valor no hace falta recorrer todo el árbol:
// en cada nodo se compara y se elige UN solo lado, descartando el otro completo.
// Si el árbol está balanceado, en cada paso se descarta la mitad de los datos, por eso
// la búsqueda cuesta O(log n) (como la búsqueda binaria en un arreglo ordenado).
// Si se insertan datos ya ordenados (1,2,3,4...) el árbol degenera en una "lista"
// torcida hacia la derecha y la búsqueda vuelve a ser O(n).
//
// Diferencia con el Paso 1: allá insertábamos por niveles (sin orden). Acá la posición
// de cada nuevo valor la decide la comparación con los nodos existentes.
// =====================================================================================

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda {

    private Nodo raiz;

    // Mismo nodo que en el Paso 1: un dato y dos referencias a los hijos.
    private static class Nodo {
        int dato;
        Nodo izquierdo, derecho;
        Nodo(int dato) { this.dato = dato; }
    }

    // -------------------------------------------------------------------------------
    // INSERTAR (recursivo)
    // -------------------------------------------------------------------------------
    // La versión pública hace "raiz = insertar(raiz, valor)". ¿Por qué asignar?
    // Porque el método privado DEVUELVE la raíz del subárbol ya modificado. Si el árbol
    // estaba vacío, devuelve el nodo nuevo, y así la raíz deja de ser null.
    //
    // Lógica del método privado:
    //   - CASO BASE: si n == null encontramos el hueco donde corresponde el valor,
    //     así que se crea el nodo y se lo devuelve para que el padre lo "enganche".
    //   - Si el valor es MENOR que el nodo actual -> tiene que ir a la izquierda.
    //     Se inserta recursivamente en el subárbol izquierdo y el resultado se vuelve a
    //     asignar a n.izquierdo (si ya existía, se reasigna el mismo nodo; si era null,
    //     ahora apunta al nodo nuevo).
    //   - Si es MAYOR -> mismo razonamiento por la derecha.
    //   - Si es IGUAL -> no entra en ningún if: el ABB NO admite duplicados, se ignora.
    //   - Al final se devuelve n (el nodo actual sin cambiar), para no romper el enlace
    //     con el padre.
    public void insertar(int valor) { raiz = insertar(raiz, valor); }
    private Nodo insertar(Nodo n, int valor) {
        if (n == null) return new Nodo(valor);
        if (valor < n.dato) n.izquierdo = insertar(n.izquierdo, valor);
        else if (valor > n.dato) n.derecho = insertar(n.derecho, valor);
        return n;
    }

    // -------------------------------------------------------------------------------
    // BUSCAR (recursivo)
    // -------------------------------------------------------------------------------
    // Dos casos base:
    //   - n == null       -> bajamos hasta un hueco sin encontrarlo: NO está (false).
    //   - valor == n.dato -> lo encontramos (true).
    // Caso recursivo: gracias a la regla del ABB sabemos de qué lado DEBERÍA estar,
    // así que se busca solo en ese lado. El operador ternario (cond ? a : b) elige
    // entre buscar a la izquierda (si es menor) o a la derecha (si es mayor).
    public boolean buscar(int valor) { return buscar(raiz, valor); }
    private boolean buscar(Nodo n, int valor) {
        if (n == null) return false;
        if (valor == n.dato) return true;
        // Se descarta la mitad del árbol en cada paso: por eso la búsqueda es O(log n) si está balanceado
        return valor < n.dato ? buscar(n.izquierdo, valor) : buscar(n.derecho, valor);
    }

    // -------------------------------------------------------------------------------
    // IN-ORDEN -> imprime los datos ORDENADOS
    // -------------------------------------------------------------------------------
    // Es exactamente el mismo in-orden del Paso 1. La "magia" es que, como primero se
    // visita todo lo de la izquierda (menores), después el nodo, y después todo lo de la
    // derecha (mayores), el resultado sale siempre de menor a mayor, sin importar en qué
    // orden se hayan insertado los valores.
    public void inOrden() { inOrden(raiz); System.out.println(); }
    private void inOrden(Nodo n) {
        if (n == null) return;
        inOrden(n.izquierdo);
        System.out.print(n.dato + " ");
        inOrden(n.derecho);
    }

    // -------------------------------------------------------------------------------
    // MEJORA SUGERIDA POR LA GUÍA (Cierre de la Unidad 4): inOrden que DEVUELVE una lista
    // -------------------------------------------------------------------------------
    // El inOrden() de arriba IMPRIME directamente, entonces solo sirve para mostrar por
    // consola. Si quisiéramos guardar los datos en un archivo (Paso 9) habría que copiar
    // toda la lógica del recorrido. Para no duplicar código, esta versión hace el mismo
    // recorrido pero AGREGA cada dato a una List<Integer> que se pasa por parámetro
    // (la misma lista viaja por todas las llamadas recursivas y se va llenando).
    // Después, quien la recibe decide qué hacer: imprimirla, guardarla, sumarla, etc.
    // -> Separación de responsabilidades: el árbol RECORRE, otro decide cómo MOSTRAR.
    public List<Integer> inOrdenLista() {
        List<Integer> resultado = new ArrayList<>();
        inOrdenLista(raiz, resultado);
        return resultado;
    }
    private void inOrdenLista(Nodo n, List<Integer> resultado) {
        if (n == null) return;
        inOrdenLista(n.izquierdo, resultado);
        resultado.add(n.dato);                 // en lugar de imprimir, se acumula
        inOrdenLista(n.derecho, resultado);
    }

    // -------------------------------------------------------------------------------
    // PRUEBA
    // -------------------------------------------------------------------------------
    // Insertando 50, 30, 70, 20, 40, 60, 80 el árbol queda:
    //
    // Búsqueda de 45: 50 (45<50, voy a la izq) -> 30 (45>30, voy a la der) -> 40
    // (45>40, voy a la der) -> null -> false. Solo se miraron 3 nodos de 7.
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) abb.insertar(v);
        abb.inOrden(); // 20 30 40 50 60 70 80 - siempre queda ordenado
        System.out.println("¿Contiene 40? " + abb.buscar(40)); // true
        System.out.println("¿Contiene 45? " + abb.buscar(45)); // false
        System.out.println("Como lista: " + abb.inOrdenLista()); // [20, 30, 40, 50, 60, 70, 80]
    }
}
