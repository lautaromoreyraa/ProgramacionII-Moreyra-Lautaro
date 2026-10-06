package ejercicio_2.Modelo;

public class EscritorioIndividual extends EspacioWorkBase {
    private final boolean tieneMonitorExtra;

    public EscritorioIndividual(String id, String tipo, int capacidadMaxima, double precioHora, boolean disponible, boolean tieneMonitorExtra) {
        super(id, tipo, capacidadMaxima, precioHora, disponible);
        this.tieneMonitorExtra = tieneMonitorExtra;
    }

    @Override
    public double calcularCostoTotal(int horas) {
        double precioTotal = getPrecioHora() * horas;
        if (tieneMonitorExtra) {
            precioTotal *= 1.15;
        }
        return precioTotal;
    }

}
