package practica.TAD;

public interface PlaylistMusica {
    Cancion getCancionById(String id);
    void agregarCancion(Cancion cancion);
    void eliminarCancion (String id);
    void editarCancion (String id, String nombre, short duracion);
}
