package ejercicio_2.Modelo;

public class SalaDeReunion extends EspacioWorkBase {
    private final double costoAdicionalLimpieza;
    private final boolean tieneProyector;

    public SalaDeReunion(String id, String tipo, int capacidadMaxima, double precioHora, boolean disponible, double costoAdicionalLimpieza, boolean tieneProyector) {
        super(id, tipo, capacidadMaxima, precioHora, disponible);
        this.costoAdicionalLimpieza = costoAdicionalLimpieza;
        this.tieneProyector = tieneProyector;
    }

    @Override
    public double calcularCostoTotal(int horas) {
        double precioTotal = getPrecioHora() * horas + costoAdicionalLimpieza;
        if (tieneProyector && costoAdicionalLimpieza == 0) {
            try {
                throw new Exception("No se puede calcular el costo total: la sala tiene proyector pero no se ha especificado un costo adicional de limpieza.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return precioTotal;
    }
}
