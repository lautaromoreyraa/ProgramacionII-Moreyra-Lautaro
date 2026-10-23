package CLASE_6;

public class Triangulo extends Figura {
    private final double lado1;
    private final double lado2;
    private final double lado3;

    public Triangulo (double lado1, double lado2, double lado3) {
        super("Triángulo");
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        if (!esDesigual()) {
            throw new IllegalArgumentException("Los lados no cumplen con un triangulo.");
        }
    }

    public boolean esDesigual() {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public int compareTo(Figura o) {
        return 0;
    }
}
