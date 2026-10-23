package ejercicio_2.App;

import ejercicio_2.Modelo.EspacioWorkImpl;

import java.util.ArrayList;

public class GestorEspacioWork {
    private ArrayList<EspacioWorkImpl> espacios;

    public GestorEspacioWork() {
        espacios = new ArrayList<>();
    }

    EspacioWorkImpl espacio;

    public void agregarEspacio(EspacioWorkImpl espacio) {
        espacios.add(espacio);
    }

    public void eliminarEspacio(String id) {
        espacios.removeIf(espacio -> espacio.getId().equals(id));
    }
    public ArrayList<EspacioWorkImpl> getEspacios() {
        return espacios;
    }

    public EspacioWorkImpl getEspacioPorId(String id) {
        for (EspacioWorkImpl espacio : espacios) {
            if (espacio.getId().equals(id)) {
                return espacio;
            }
        }
        return null;
    }

    public double calcularCostoTotal(int horas) {
        double total = 0;
        for (EspacioWorkImpl espacio : espacios) {
            total += espacio.calcularCostoTotal(horas);
        }
        return total;
    }

    public String getEspacioInfo(String id) {
        EspacioWorkImpl espacio = getEspacioPorId(id);
        if (espacio != null) {
            String info = "ID: " + espacio.getId() + "\n" +
                    "Tipo: " + espacio.getTipo() + "\n" +
                    "Capacidad Máxima: " + espacio.getCapacidadMaxima() + "\n" +
                    "Precio por Hora: " + espacio.getPrecioHora() + "\n" +
                    "Disponible: " + espacio.isDisponible() + "\n" +
                    "Mobiliario Adicional: " + espacio.hasMobiliarioAdicional();
            System.out.println(info);
            return info;
        } else {
            System.out.println("Espacio con ID " + id + " no encontrado.");
            return null;
        }
    }

    public double calcularTotalARecaudar(int horas) {
        double total = 0;
        for (EspacioWorkImpl espacio : espacios) {
            total += espacio.calcularCostoTotal(horas);
        }
        return total;
    }
}
