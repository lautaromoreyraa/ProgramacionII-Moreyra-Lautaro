package unidad4;

// =====================================================================================
// PASO 1 - TAD ÁRBOL: ÁRBOL BINARIO Y RECORRIDOS
// =====================================================================================
// Un árbol es una estructura de datos JERÁRQUICA (no lineal): hay un nodo especial llamado
// RAÍZ, y cada nodo puede tener "hijos". En un árbol BINARIO cada nodo tiene como máximo
// DOS hijos: el izquierdo y el derecho.
//
// Diferencia clave con una lista enlazada: en la lista cada nodo tiene UN solo "siguiente",
// entonces recorrerla es obvio (de adelante hacia atrás). En el árbol cada nodo tiene DOS
// caminos posibles, así que hay que DECIDIR en qué orden visitar raíz, subárbol izquierdo
// y subárbol derecho. De esa decisión salen los 4 recorridos clásicos:
//
//   - Pre-orden  : RAÍZ -> izquierdo -> derecho        (recursivo)
//   - In-orden   : izquierdo -> RAÍZ -> derecho        (recursivo)
//   - Post-orden : izquierdo -> derecho -> RAÍZ        (recursivo)
//   - Por niveles: nivel 0, nivel 1, nivel 2...        (iterativo, usa una COLA)
//
// Truco para recordar: el nombre (PRE / IN / POST) dice CUÁNDO se procesa la raíz:
// antes, en el medio, o después de los hijos.

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {

    // Referencia al primer nodo del árbol. Si es null, el árbol está vacío.
    // Desde la raíz se puede llegar a cualquier otro nodo bajando por izquierdo/derecho.
    private Nodo raiz;

    // -------------------------------------------------------------------------------
    // CLASE INTERNA NODO
    // -------------------------------------------------------------------------------
    // Es la misma idea que el Nodo de la lista enlazada (Unidad 3), pero en vez de tener
    // un solo puntero "siguiente" tiene DOS: izquierdo y derecho.
    // Es "private static" porque:
    //   - private: nadie fuera del árbol necesita conocer cómo está armado por dentro
    //     (encapsulamiento: el usuario del TAD solo usa insertar() y los recorridos).
    //   - static : el Nodo no necesita acceder a los atributos del ArbolBinario que lo
    //     contiene, así que no hace falta que guarde una referencia oculta al árbol.
    private static class Nodo {
        int dato;
        Nodo izquierdo, derecho;   // ambos arrancan en null = "no tiene ese hijo"

        Nodo(int dato) { this.dato = dato; }
    }

    // -------------------------------------------------------------------------------
    // INSERTAR (por niveles, sin criterio de orden)
    // -------------------------------------------------------------------------------
    // Este árbol todavía NO ordena los datos (eso lo hace el ABB del Paso 2).
    // La estrategia es llenar el árbol "de arriba hacia abajo y de izquierda a derecha",
    // es decir, poner el nuevo nodo en el PRIMER hueco libre que aparezca recorriendo
    // por niveles. Así el árbol queda lo más "completo" y equilibrado posible.
    //
    // Para encontrar ese primer hueco se usa una COLA (FIFO, Unidad 3):
    //   1. Se mete la raíz en la cola.
    //   2. Se saca el primero de la cola y se mira si le falta el hijo izquierdo:
    //      si le falta, ahí va el nuevo nodo y terminamos.
    //   3. Si no le falta, se encola ese hijo izquierdo para revisarlo más tarde,
    //      y se hace lo mismo con el derecho.
    //   4. Se repite hasta encontrar un hueco.
    // Como la cola respeta el orden de llegada, se revisan los nodos nivel por nivel.
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);

        // Caso especial: árbol vacío -> el nuevo nodo pasa a ser la raíz.
        if (raiz == null) { raiz = nuevo; return; }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();   // saca el nodo más "viejo" de la cola

            // ¿Hay lugar a la izquierda? Se inserta y se corta el método con return.
            if (actual.izquierdo == null) { actual.izquierdo = nuevo; return; }
            cola.add(actual.izquierdo);  // no había lugar: se revisará más tarde

            // Mismo razonamiento para la derecha.
            if (actual.derecho == null) { actual.derecho = nuevo; return; }
            cola.add(actual.derecho);
        }
    }

    // -------------------------------------------------------------------------------
    // PATRÓN "MÉTODO PÚBLICO + MÉTODO PRIVADO RECURSIVO"
    // -------------------------------------------------------------------------------
    // Cada recorrido tiene dos versiones con el mismo nombre (sobrecarga):
    //   - La PÚBLICA no recibe parámetros: es la que usa el programador desde afuera.
    //     Solo arranca la recursión pasando la raíz, y al final imprime un salto de línea.
    //   - La PRIVADA recibe un Nodo: es la que realmente hace el trabajo recursivo.
    // Esto es necesario porque la raíz es privada: el usuario no puede (ni debe) pasarla.
    //
    // Todos los recorridos recursivos tienen la MISMA estructura que en la Unidad 1:
    //   - CASO BASE     : if (n == null) return;  -> llegamos a un "hueco", no hay nada.
    //   - CASO RECURSIVO: se llama al mismo método sobre el hijo izquierdo y el derecho,
    //                     que son árboles más chicos (subárboles).
    // Lo ÚNICO que cambia entre pre, in y post es en qué línea se pone el print.

    // PRE-ORDEN: raíz -> izquierdo -> derecho
    // Se imprime el nodo ANTES de bajar a sus hijos. Útil para copiar un árbol
    // (primero se crea el padre y después los hijos).
    public void preOrden() { preOrden(raiz); System.out.println(); }
    private void preOrden(Nodo n) {
        if (n == null) return;                 // caso base
        System.out.print(n.dato + " ");        // 1° proceso la raíz
        preOrden(n.izquierdo);                 // 2° todo el subárbol izquierdo
        preOrden(n.derecho);                   // 3° todo el subárbol derecho
    }

    // IN-ORDEN: izquierdo -> raíz -> derecho
    // Se imprime el nodo EN EL MEDIO. En un árbol común no tiene nada especial, pero
    // en un ABB (Paso 2) este recorrido devuelve los datos ORDENADOS de menor a mayor.
    public void inOrden() { inOrden(raiz); System.out.println(); }
    private void inOrden(Nodo n) {
        if (n == null) return;
        inOrden(n.izquierdo);                  // 1° todo lo de la izquierda
        System.out.print(n.dato + " ");        // 2° la raíz
        inOrden(n.derecho);                    // 3° todo lo de la derecha
    }

    // POST-ORDEN: izquierdo -> derecho -> raíz
    // Se imprime el nodo DESPUÉS de procesar a sus dos hijos. Útil cuando el padre
    // depende del resultado de los hijos (ej.: borrar un árbol, calcular alturas,
    // evaluar una expresión matemática guardada en un árbol).
    public void postOrden() { postOrden(raiz); System.out.println(); }
    private void postOrden(Nodo n) {
        if (n == null) return;
        postOrden(n.izquierdo);                // 1° hijo izquierdo completo
        postOrden(n.derecho);                  // 2° hijo derecho completo
        System.out.print(n.dato + " ");        // 3° recién ahora la raíz
    }

    // -------------------------------------------------------------------------------
    // POR NIVELES (BFS sobre el árbol)
    // -------------------------------------------------------------------------------
    // Visita primero la raíz (nivel 0), después todos los nodos del nivel 1, después
    // los del nivel 2, etc. La recursión simple NO sirve para esto, porque la recursión
    // siempre se "hunde" por una rama hasta el fondo antes de volver.
    // Por eso se usa una COLA explícita: cada vez que se visita un nodo, se encolan sus
    // hijos. Como la cola es FIFO, los hijos se van a visitar recién DESPUÉS de todos
    // los nodos que ya estaban esperando (que son los del nivel actual).
    // Este mismo esquema se repite en el BFS de grafos (Paso 4).
    public void porNiveles() {
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.dato + " ");
            // Se encolan los hijos que existan, primero el izquierdo para respetar
            // el orden "de izquierda a derecha" dentro de cada nivel.
            if (actual.izquierdo != null) cola.add(actual.izquierdo);
            if (actual.derecho != null) cola.add(actual.derecho);
        }
        System.out.println();
    }

    // -------------------------------------------------------------------------------
    // PRUEBA
    // -------------------------------------------------------------------------------
    // Resultados esperados:
    //   Pre-orden:   1 2 4 5 3 6 7
    //   In-orden:    4 2 5 1 6 3 7
    //   Post-orden:  4 5 2 6 7 3 1
    //   Por niveles: 1 2 3 4 5 6 7
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        for (int v : new int[]{1, 2, 3, 4, 5, 6, 7}) arbol.insertar(v);
        System.out.print("Pre-orden:   "); arbol.preOrden();
        System.out.print("In-orden:    "); arbol.inOrden();
        System.out.print("Post-orden:  "); arbol.postOrden();
        System.out.print("Por niveles: "); arbol.porNiveles();
    }
}
