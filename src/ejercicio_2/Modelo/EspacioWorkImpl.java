package ejercicio_2.Modelo;

public interface EspacioWorkImpl {
    void actualizarEspacio(String id, int capacidadMaxima);
    void actualizarEspacio(String id, int capacidadMaxima, boolean mobiliarioAdicional);
    double calcularCostoTotal(int horas);
}
