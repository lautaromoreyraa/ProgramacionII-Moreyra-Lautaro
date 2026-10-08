package ejercicio_1.Modelo;

public class PaqueteFragil extends Paquete{
    private String nivelProteccion;

    public PaqueteFragil(String codigoTrack, double peso, String destino, String nivelProteccion) {
        super(codigoTrack, peso, destino);
        if (nivelProteccion.equalsIgnoreCase("Bajo")
                || nivelProteccion.equalsIgnoreCase("Medio")
                || nivelProteccion.equalsIgnoreCase("Alto")) {
            this.nivelProteccion = nivelProteccion;
        } else {
            throw new IllegalArgumentException("Nivel de protección inválido. Debe ser 'Bajo', 'Medio' o 'Alto'.");
        }
    }

    public String getNivelProteccion() {
        return nivelProteccion;
    }

    public void setNivelProteccion(String nivelProteccion) {
        if (nivelProteccion.equalsIgnoreCase("Bajo")
                || nivelProteccion.equalsIgnoreCase("Medio")
                || nivelProteccion.equalsIgnoreCase("Alto")) {
            this.nivelProteccion = nivelProteccion;
        } else {
            throw new IllegalArgumentException("Nivel de protección inválido. Debe ser 'Bajo', 'Medio' o 'Alto'.");
        }
    }

    @Override
    public double calcularCostoEnvio() {
        double costoFinal = 0;
        if (nivelProteccion.equalsIgnoreCase("Medio")) {
            costoFinal = (15 * COSTO_ENVIO_POR_KG / 100) * getPeso();
        } else if (nivelProteccion.equalsIgnoreCase("Alto")) {
            costoFinal = (30 * COSTO_ENVIO_POR_KG / 100) * getPeso();
        }
        return costoFinal;
    }

    @Override
    public boolean esAptoParaEnvioAereo() {
        return false;
    }

    @Override
    public String obtenerDetalle() {
        String detalle = "Paquete Fragil: " + getCodigoTrack()
                + ", Peso: " + getPeso() + "kg" +
                ", Destino: " + getDestino()
                + ", Nivel de protección: " + nivelProteccion;
        return detalle;
    }




}
