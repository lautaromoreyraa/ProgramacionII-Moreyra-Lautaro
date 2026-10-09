package alquiler_vehiculos.modelo;

public class Auto extends Vehiculo {
    private final boolean tieneGps;

    public Auto(String patente, int anioFabricacion, double precioBaseDiario ,boolean tieneGps) {
        super(patente, anioFabricacion, precioBaseDiario);
        this.tieneGps = tieneGps;
    }

    @Override
    public double calcularCosto(int dias) {
        double costoTotal = getPrecioBaseDiario() * dias;
        if (tieneGps){
            costoTotal *= 1.10;
        }
        return costoTotal;
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }
}
