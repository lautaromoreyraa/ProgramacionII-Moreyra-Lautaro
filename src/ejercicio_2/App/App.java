package ejercicio_2.App;

import ejercicio_2.Modelo.EscritorioIndividual;
import ejercicio_2.Modelo.EspacioWorkImpl;
import ejercicio_2.Modelo.SalaDeReunion;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEspacioWork gestor = new GestorEspacioWork();

        EspacioWorkImpl reunion1 = new SalaDeReunion("1", "Sala de Reunión", 10, 50.0, true, true,  false);
        gestor.agregarEspacio(reunion1);

        EspacioWorkImpl reunion2 = new SalaDeReunion("2", "Sala de Reunión", 8, 40.0, true, false,  true);
        gestor.agregarEspacio(reunion2);

        EspacioWorkImpl escritorio1 = new EscritorioIndividual("3", "Escritorio Individual", 1, 30.0, true, false, true);
        gestor.agregarEspacio(escritorio1);

        EspacioWorkImpl escritorio2 = new EscritorioIndividual("4", "Escritorio Individual", 1, 25.0, true, true, false);
        gestor.agregarEspacio(escritorio2);


        for (EspacioWorkImpl espacio : gestor.getEspacios()) {
            gestor.getEspacioInfo(espacio.getId());
        }

        System.out.println("\nIngrese la cantidad de horas para calcular el costo total de todos los espacios: ");
        int horas = scanner.nextInt();
        System.out.println("\nCosto total de todos los espacios: " + gestor.calcularCostoTotal(horas) + "\n");
    }

}
