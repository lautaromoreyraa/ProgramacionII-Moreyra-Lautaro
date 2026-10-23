package alquiler_vehiculos.modelo;

public interface Alquilable {
    double calcularCosto(int dias);
    boolean estaDisponible();
}
