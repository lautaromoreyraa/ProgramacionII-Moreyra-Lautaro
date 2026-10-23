package ejercicio_1.App;

import ejercicio_1.Modelo.Enviable;
import ejercicio_1.Modelo.Paquete;

import java.util.ArrayList;

public class CentroLogistico {
    private ArrayList<Enviable> inventario;

    Paquete paquete;

    CentroLogistico() {
        this.inventario = new ArrayList<>();
    }

    public ArrayList<Enviable> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Enviable> inventario) {
        this.inventario = inventario;
    }

    public void registrarPaquete(Enviable e) {
        inventario.add(e);
    }


    //Recorre el inventario de forma polimórfica imprimiendo el detalle del paquete y su costo total de envío.
    public void mostrarReporteEnvios() {
        for (Enviable e: inventario) {
            System.out.println(e instanceof Paquete ? ((Paquete) e).obtenerDetalle() : "Detalle no disponible");
            System.out.println("Costo de envío: " + e.calcularCostoEnvio());
            System.out.println("Apto para envío aéreo: " + (e.esAptoParaEnvioAereo() ? "Sí" : "No"));
            System.out.println("-----------------------------");
        }
    }

    double calcularRecaudacionTotal() {
        double total = 0;
        for (Enviable e: inventario) {
            total += e.calcularCostoEnvio();
        }
        return total;
    }

}
