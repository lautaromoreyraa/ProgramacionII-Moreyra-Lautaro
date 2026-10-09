package alquiler_vehiculos.app;

import alquiler_vehiculos.modelo.Alquilable;
import alquiler_vehiculos.modelo.Vehiculo;

import java.util.ArrayList;


public class GestorFlota {
    ArrayList <Alquilable> flota = new ArrayList<>();

    public void agregar(Vehiculo vehiculo){
        flota.add(vehiculo);
    }

    public void mostrarReporte (int dias){
        for (Alquilable vehiculo : flota){
            String info = vehiculo.toString();
            System.out.println(info);
        }
    }

    public double calcularTotal (int dias){
        double precioTotal = 0;
        for (Alquilable e : flota){
            double valorAuto = e.calcularCosto(dias);
            precioTotal += valorAuto;
        }
        return precioTotal;
    }

    public double calcularTotalDisponible (int dias){
        double precioTotal = 0;
        for (Alquilable e : flota){
            if (e.estaDisponible()){
                double valorAuto = e.calcularCosto(dias);
                precioTotal += valorAuto;
            }
        }
        return precioTotal;
    }
}
