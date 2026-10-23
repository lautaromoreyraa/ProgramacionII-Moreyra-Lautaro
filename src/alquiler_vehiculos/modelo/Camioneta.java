package alquiler_vehiculos.modelo;

import java.time.Clock;
import java.time.LocalDate;

public class Camioneta extends Vehiculo {
    private double capacidadCargaKg;
    private double seguroPorAlquiler;

    public static LocalDate year = LocalDate.now(Clock.systemDefaultZone());

    public Camioneta(String patente, int anioFabricacion, double precioBaseDiario, double capacidadCargaKg, double seguroPorAlquiler) {
        super(patente, anioFabricacion, precioBaseDiario);
        this.capacidadCargaKg = capacidadCargaKg;
        this.seguroPorAlquiler = seguroPorAlquiler;
    }

    @Override
    public double calcularCosto(int dias) {
        double costoTotal = getPrecioBaseDiario() * dias;
        if (capacidadCargaKg > 1000){
            costoTotal *= 1.20;
        }
        return costoTotal + seguroPorAlquiler;
    }

    @Override
    public boolean estaDisponible() {
        if (year.getYear() - getAnioFabricacion() > 15){
            return false;
        }
        return true;
    }
}
