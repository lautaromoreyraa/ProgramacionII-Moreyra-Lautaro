package practica.TAD;

public class Main {
    public static void main(String[] args) {
        PlaylistMusicaImpl playlist = new PlaylistMusicaImpl();

        playlist.agregarCancion(new Cancion("C1", "Ji ji ji", (short) 312, new String[]{"Patricio Rey y sus Redonditos de Ricota"}));
        playlist.agregarCancion(new Cancion("C2", "Seminare", (short) 245, new String[]{"Serú Girán"}));
        playlist.agregarCancion(new Cancion("C3", "Mil horas", (short) 198, new String[]{"Los Abuelos de la Nada"}));
        playlist.mostrar();

        System.out.println("Buscar C2: " + playlist.getCancionById("C2").getNombre());

        playlist.editarCancion("C3", "Mil horas (en vivo)", (short) 230);
        playlist.eliminarCancion("C1");
        System.out.println();
        playlist.mostrar();

        try {
            playlist.getCancionById("C9");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            playlist.agregarCancion(new Cancion("C2", "Repetida", (short) 100, new String[]{"Nadie"}));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
