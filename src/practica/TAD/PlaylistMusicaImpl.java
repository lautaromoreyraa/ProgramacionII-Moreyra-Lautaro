package practica.TAD;

import java.util.LinkedList;

public class PlaylistMusicaImpl implements PlaylistMusica {

    private LinkedList<Cancion> canciones = new LinkedList<>();

    @Override
    public Cancion getCancionById(String id) {
        for (Cancion cancion : canciones){
            if (cancion.getId().equals(id)){
                return cancion;
            }
        }
        throw new IllegalArgumentException("No existe una cancion con el ID " + id);
    }

    @Override
    public void agregarCancion(Cancion cancion) {
        for (Cancion c : canciones){
            if (c.getId().equals(cancion.getId())){
                throw new IllegalArgumentException("Ya existe una cancion con el ID " + cancion.getId());
            }
        }
        canciones.add(cancion);
    }

    @Override
    public void eliminarCancion(String id) {
        Cancion cancion = getCancionById(id);
        canciones.remove(cancion);
    }

    @Override
    public void editarCancion(String id, String nombre, short duracion) {
        Cancion cancion = getCancionById(id);
        cancion.setNombre(nombre);
        cancion.setDuracion(duracion);
    }

    public void mostrar() {
        for (Cancion cancion : canciones){
            System.out.println(cancion.getId() + " - " + cancion.getNombre() + " (" + cancion.getDuracion() + " seg) - " + String.join(", ", cancion.getAutor()));
        }
    }
}
