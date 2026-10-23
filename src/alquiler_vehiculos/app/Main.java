package alquiler_vehiculos.app;

import alquiler_vehiculos.modelo.Auto;
import alquiler_vehiculos.modelo.Camioneta;

public class Main {
    public static void main(String[] args) {
        GestorFlota gestorFlota = new GestorFlota();

        Auto auto1 = new Auto("AB123CD", 2020, 30000, true);
        Auto auto2 = new Auto("AC456EF", 2018, 25000, false);
        Camioneta cam1 = new Camioneta("AA789GH", 2015, 45000, 1200, 8000);
        Camioneta cam2 = new Camioneta("XYZ987", 2008, 40000, 800, 5000);

        gestorFlota.agregar(auto1);
        gestorFlota.agregar(auto2);
        gestorFlota.agregar(cam1);
        gestorFlota.agregar(cam2);

        int dias = 3;
        gestorFlota.mostrarReporte(dias);

        System.out.println("Total: " + gestorFlota.calcularTotal(dias));
        System.out.println("Total disponibles: " + gestorFlota.calcularTotalDisponible(dias));
    }
}
