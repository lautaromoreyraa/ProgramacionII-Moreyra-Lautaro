package ejercicio_1.Modelo;

public abstract class Paquete implements Enviable {
    private String codigoTrack;
    private double peso;
    private String destino;

    public static final double COSTO_ENVIO_POR_KG = 1000;

    Paquete(String codigoTrack, double peso, String destino) {
        if (codigoTrack == null || codigoTrack.isEmpty()) {
            throw new IllegalArgumentException("El código de tracking no puede ser nulo.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Error: El peso debe ser mayor a 0 ");
        }
        this.codigoTrack = codigoTrack;
        this.peso = peso;
        this.destino = destino;
    }

    public String getCodigoTrack() {
        return codigoTrack;
    }

    public void setCodigoTrack(String codigoTrack) {
        if (codigoTrack == null || codigoTrack.isEmpty()) {
            throw new IllegalArgumentException("El código de tracking no puede ser nulo.");
        }
        this.codigoTrack = codigoTrack;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Error: El peso debe ser mayor a 0 ");
        }
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        if (destino == null || destino.isEmpty()) {
            throw new IllegalArgumentException("El destino no puede ser nulo.");
        }
        this.destino = destino;
    }

    public void actualizarDestino(String nuevoDestino) {
        if (nuevoDestino == null || nuevoDestino.isEmpty()) {
            throw new IllegalArgumentException("El destino no puede ser nulo.");
        }
        this.destino = nuevoDestino;
    }

    public void actualizarDestino (String nuevoDestino, boolean express){
        if (nuevoDestino == null || nuevoDestino.isEmpty()) {
            throw new IllegalArgumentException("El destino no puede ser nulo.");
        }
        if (express) {
            nuevoDestino += "  [PRIORITARRIO]";
        }
        this.destino = nuevoDestino;
    }

    public abstract String obtenerDetalle();
}
