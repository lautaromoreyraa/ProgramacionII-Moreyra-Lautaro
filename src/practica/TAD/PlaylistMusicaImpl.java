package practica.TAD;

import java.util.LinkedList;

public class PlaylistMusicaImpl<Cancion> implements PlaylistMusica<Cancion> {

    LinkedList<Cancion> canciones;

    @Override
    public Cancion getCancionById(String id) {
        for (Cancion cancion : canciones){
            if (cancion.equals(id)){
                return cancion;
            } else throw new IllegalArgumentException("No existe esa cancion con ese ID");
        }
        return null;
    }

    @Override
    public void agregarCancion(String id) {
        Cancion cancion = getCancionById(id);
        canciones.add(cancion);
    }

    @Override
    public void eliminarCancion(String id) {
        Cancion cancion = getCancionById(id);
        canciones.remove(cancion);
    }

    @Override
    public void editarCancion(String id) {
        Cancion cancion = getCancionById(id);
        canciones.remove();
        //logica para editar la cancion
    }
}
