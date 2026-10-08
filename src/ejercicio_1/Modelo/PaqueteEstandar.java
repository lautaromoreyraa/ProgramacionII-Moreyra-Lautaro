package ejercicio_1.Modelo;

public class PaqueteEstandar extends Paquete {
    private int diasEstimados;

    public PaqueteEstandar(String codigoTrack, double peso, String destino, int diasEstimados) {
        super(codigoTrack, peso, destino);
        this.diasEstimados = diasEstimados;
    }

    @Override
    public double calcularCostoEnvio() {
        return COSTO_ENVIO_POR_KG * getPeso();
    }

    @Override
    public String obtenerDetalle() {
        String detalle = "Paquete Estandar: " + getCodigoTrack() + ", Peso: " + getPeso() + "kg, Destino: " + getDestino() + ", Dias estimados: " + diasEstimados;
        return detalle;
    }

    @Override
    public boolean esAptoParaEnvioAereo() {
        if (getPeso() <= 15) {
            return true;
        }
        return false;
    }


}
