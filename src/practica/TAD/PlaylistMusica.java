package practica.TAD;

public interface PlaylistMusica<Cancion> {
    Cancion getCancionById(String id);
    void agregarCancion(String nombre);
    void eliminarCancion (String nombre);
    void editarCancion (String nombre);
}
