package ejercicio_2.Modelo;

import ejercicio_2.App.GestorEspacioWork;

public abstract class EspacioWorkImpl implements EspacioWork {
    private String id;
    private String tipo;
    private int capacidadMaxima;
    private double precioHora;
    private boolean disponible;
    private boolean mobiliarioAdicional;

    GestorEspacioWork gestorEspacioWork;

    public EspacioWorkImpl(String id, String tipo, int capacidadMaxima, double precioHora ,boolean disponible, boolean mobiliarioAdicional) {
        setId(id);
        this.tipo = tipo;
        setCapacidadMaxima(capacidadMaxima);
        setPrecioHora(precioHora);
        setDisponible(disponible);
        this.mobiliarioAdicional = mobiliarioAdicional;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío.");
        }
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que cero.");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        if (precioHora <= 0) {
            throw new IllegalArgumentException("El precio por hora debe ser mayor que cero.");
        }
        this.precioHora = precioHora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isMobiliarioAdicional() {
        return mobiliarioAdicional;
    }

    public void setMobiliarioAdicional(boolean mobiliarioAdicional) {
        this.mobiliarioAdicional = mobiliarioAdicional;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precioHora=" + precioHora +
                ", disponible=" + disponible +
                (mobiliarioAdicional ? " [Mobiliario adicional]" : "") +
                '}';
    }

    @Override
    public void actualizarEspacio(String id, int capacidadMaxima) {
        if (id.equals(this.id)) {
        setCapacidadMaxima(capacidadMaxima);
        }
    }

    @Override
    public void actualizarEspacio(String id, int capacidadMaxima, boolean mobiliarioAdicional) {
        actualizarEspacio(id, capacidadMaxima);
        this.mobiliarioAdicional = mobiliarioAdicional;
    }

    @Override
    public abstract double calcularCostoTotal(int horas);

    public String hasMobiliarioAdicional() {
        return mobiliarioAdicional ? "Sí" : "No";
    }

}