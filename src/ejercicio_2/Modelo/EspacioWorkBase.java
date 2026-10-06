package ejercicio_2.Modelo;

public abstract class EspacioWorkBase implements EspacioWorkImpl {
    private String id;
    private String tipo;
    private int capacidadMaxima;
    private double precioHora;
    private boolean disponible;

    public EspacioWorkBase(String id, String tipo, int capacidadMaxima, double precioHora, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.precioHora = precioHora;
        this.disponible = disponible;
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

    @Override
    public String toString() {
        return "EspacioWorkBase{" +
                "id='" + id + '\'' +
                "tipo='" + tipo + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precioHora=" + precioHora +
                ", disponible=" + disponible +
                '}';
    }

    @Override
    public void actualizarEspacio(String id, int capacidadMaxima) {
        if (getId().equals(id)) {
            setCapacidadMaxima(capacidadMaxima);
        }
    }

    @Override
    public void actualizarEspacio(String id, int capacidadMaxima, boolean mobiliarioAdicional) {
        actualizarEspacio(id, capacidadMaxima);
        if (mobiliarioAdicional) {
            toString().concat(" [Mobiliario adicional]");
        }
    }

    @Override
    public double calcularCostoTotal(int horas) {
        return 0;
    }
}
