package CLASE_6;

// Subclase
public class Circulo extends Figura {
    private final double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public int compareTo(Figura o) {
        return 0;
    }
}
