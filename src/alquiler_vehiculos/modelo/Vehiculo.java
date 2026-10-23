package alquiler_vehiculos.modelo;

import java.awt.event.WindowStateListener;

public abstract class Vehiculo implements Alquilable {
    private String patente;
    private int anioFabricacion;
    private double precioBaseDiario;

    public Vehiculo(String patente, int anioFabricacion, double precioBaseDiario) {
        this.patente = patente;
        this.anioFabricacion = anioFabricacion;
        this.precioBaseDiario = precioBaseDiario;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion >= 1990 && anioFabricacion <= 2026){
        this.anioFabricacion = anioFabricacion;
        } else {
            throw new IllegalArgumentException("El año de fabricacion debe ser entre 1990 y 2026");
        }
    }

    public double getPrecioBaseDiario() {
        return precioBaseDiario;
    }

    public double setPrecioBaseDiario(double precioBaseDiario){
        if (precioBaseDiario <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        return precioBaseDiario;
    }


    void setPatenteValidacion (String patente){
        if (patente == null || patente.isEmpty()){
            throw new IllegalArgumentException("La patente no puede ser vacia o nula");
        }
        setPatente(patente);
    }

    public double actualizarPrecio (double nuevoPrecio){
        return setPrecioBaseDiario(nuevoPrecio);
    }

    public double actualizarPrecio (double nuevoPrecio, boolean temporadaAlta){
        double precio = setPrecioBaseDiario(nuevoPrecio);
        if (temporadaAlta) {
            precio *= 1.10;
            this.patente = this.patente + " [Temporada Alta]";
        }
        return precio;
    }

    public String getTipoVehiculo(Vehiculo vehiculo){
        String resultado = " ";
        if (vehiculo instanceof Auto){
            resultado = " Auto";
        }else if (vehiculo instanceof Camioneta){
            resultado = " Camioneta";
        }
        return resultado;
    }

    @Override
    public String toString (){
        return "Patente: " + getPatente() + "\n" +
                "Tipo: " +  getTipoVehiculo(this) + "\n" +
                "Año de fabricación: " + getAnioFabricacion() + "\n" +
                "Precio por Hora: " + getPrecioBaseDiario();
    }
    
}
