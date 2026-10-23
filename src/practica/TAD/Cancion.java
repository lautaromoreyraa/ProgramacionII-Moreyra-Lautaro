package practica.TAD;

public class Cancion {
    private String id;
    private String nombre;
    private short duracion;
    private String[] autor;

    public Cancion(String id, String nombre, short duracion, String[] autor) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getAutor() {
        return autor;
    }

    public void setAutor(String[] autor) {
        this.autor = autor;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }
}
