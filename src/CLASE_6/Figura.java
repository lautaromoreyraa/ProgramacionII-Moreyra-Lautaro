package CLASE_6;

public abstract class Figura implements Comparable<Figura> {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public static double calcularAreaDeCadaFigura(Figura[] figuras) {
        double areaTotal = 0.0;

        for (Figura figura : figuras) {
            if (figura == null) {
                break;
            }
            areaTotal = figura.calcularArea();
            System.out.println("Área del " + figura.nombre + ": " + areaTotal);
        }
        return areaTotal;
    }

    public static void imprimirColeccion(Figura[] figuras) {
        for (Figura f : figuras) {
            if (f != null) {
                System.out.printf("%s -> Área: %.2f%n", f.getNombre(), f.calcularArea());
            }
        }
    }
}


