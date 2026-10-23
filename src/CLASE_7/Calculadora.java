package CLASE_7;

public class Calculadora {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static int sumar (int[] valores) {
        int suma = 0;
        for (int valor : valores) {
            suma += valor;
        }
        return suma;
    }

    // Las 3 firmas se resuelve en tiempo de compilación, ya que el compilador determina qué método llamar según los tipos de datos de los argumentos proporcionados.


}
