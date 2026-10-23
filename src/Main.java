import CLASE_5.*;
import CLASE_6.*;

import java.util.Arrays;

import static CLASE_6.Figura.imprimirColeccion;

public static void main(String[] args) {

    //Tema 1: Clases, objetos y constructores

    Persona persona1 = new Persona("Juan", 12345678, 30);
    Persona persona2 = new Persona("Maria", 87654321, 25);
    Persona persona3 = new Persona("Pedro", 11223344, 40);
    persona1.toString();
    persona2.toString();
    persona3.toString();

    Empleado empleado1 = new Empleado("Juan", 1001);
    Empleado empleado2 = new Empleado("Maria", 1002);
    Empleado empleado3 = new Empleado("Pedro", 1003);
    Empleado empleado4 = new Empleado("Ana", 1004);

    empleado1.empleados[0] = empleado1;
    empleado1.empleados[1] = empleado2;
    empleado1.empleados[2] = empleado3;
    empleado1.empleados[3] = empleado4;

    System.out.println("Legajo menor: " + empleado1.calcularLegajoMenor());
    System.out.println("Legajo mayor: " + empleado1.calcularLegajoMayor());


    //Tema 2: Encapsulamiento y validación en setters

    CuentaBancaria cuenta1 = new CuentaBancaria("Juan", 123456, 1000.0);
    System.out.println("Titular: " + cuenta1.getTitular());
    System.out.println("Número de cuenta: " + cuenta1.getNumeroCuenta());
    System.out.println("Saldo: " + cuenta1.getSaldo());
    cuenta1.depositar(500.0);
    System.out.println("Saldo después del depósito: " + cuenta1.getSaldo());
    cuenta1.extraer(200.0);
    System.out.println("Saldo después de la extracción: " + cuenta1.getSaldo());
        /*/ dispara exception
        cuenta1.extraer(10000);
        dispara exception
        cuenta1.depositar(-1); /*/

    // Tema 3: Sobrecarga de constructores y composición de objetos
    // Ejercicio 1
    CuentaBancaria cuenta2 = new CuentaBancaria("Maria", 654321);
    System.out.println("Titular: " + cuenta2.getTitular());
    System.out.println("Número de cuenta: " + cuenta2.getNumeroCuenta());
    System.out.println("Saldo: " + cuenta2.getSaldo()); //saldo en $0

    Vehiculo vehiculo1 = new Vehiculo("Toyota", "Corolla", 20000.0);
    Vehiculo vehiculo2 = new Vehiculo("Honda", "Civic", 220);
    Vehiculo vehiculo3 = new Vehiculo("Ford", "Focus", 18000.0);


    Vehiculo[] vehiculos = new Vehiculo[3];
    vehiculos[0] = vehiculo1;
    vehiculos[1] = vehiculo2;
    vehiculos[2] = vehiculo3;

    // Ejercicio 2
    Concesionaria concesionaria = new Concesionaria("Allen Motors", vehiculos);
    concesionaria.agregarVehiculo(vehiculo1);
    concesionaria.agregarVehiculo(vehiculo2);
    concesionaria.agregarVehiculo(vehiculo3);
    System.out.println(concesionaria.buscarPorMarca("Toyota"));
    System.out.println("Valor total del stock: $" + concesionaria.valorTotalStock());

    // CLASE 6 — PILARES DE LA POO: HERENCIA
    // Tema 2: Sobreescritura de métodos y reutilización con super
    // Ejercicio 1
    EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", 1001, 2000.0, 500.0);
    EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Maria", 1002, 40, 20.0);

    System.out.println("Sueldo del empleado asalariado: $" + empleadoAsalariado.calcularSueldo());
    System.out.println("Sueldo del empleado por horas: $" + empleadoPorHoras.calcularSueldo());

    // Ejercicio 2
    Auto auto1 = new Auto("Toyota", "Corolla", 20000.0, 4);
    Moto moto1 = new Moto("Honda", "CBR500R", 2020, 500);

    auto1.toString();
    moto1.toString();

    //Tema 3: Arreglos polimórficos y binding dinámico
    // Ejercicio 1

    Empleado[] empleados = new Empleado[2];
    empleados[0] = empleadoAsalariado;
    empleados[1] = empleadoPorHoras;

    for (Empleado empleado : empleados) {
        if (empleado == null) {
            break;
        }
        double sueldoEmpleado = empleado.calcularSueldo();
        System.out.println("Nombre: " + empleado.getNombre() + ", Legajo: " + empleado.getLegajo() + ", Sueldo: $" + sueldoEmpleado);
    }
     /*/ El arreglo se recorre porque Empleado actua como superclase, permitiendo que se pueda almacenar
    tanto EmpleadoAsalariado como EmpleadoPorHoras en el mismo arreglo.
    El binding dinámico permite que se llame al método calcularSueldo() /*/

    // Ejercicio 2

    Figura[] figuras = new Figura[6];

    Figura circulo1 = new Circulo(5.0);
    Figura circulo2 = new Circulo(2.5);

    Figura rectangulo1 = new Rectangulo(4.0, 6.0);
    Figura rectangulo2 = new Rectangulo(5.0, 8.0);

    Figura triangulo1 = new Triangulo(3.0, 4.0, 5.0);
    Figura triangulo2 = new Triangulo(6.0, 8.0, 10.0);

    figuras[0] = circulo1;
    figuras[1] = circulo2;
    figuras[2] = rectangulo1;
    figuras[3] = rectangulo2;
    figuras[4] = triangulo1;
    figuras[5] = triangulo2;

    Figura.calcularAreaDeCadaFigura(figuras);

    System.out.println("--- COLECCIÓN ANTES DE ORDENAR ---");
    imprimirColeccion(figuras);

    // Se ordena usando el método compareTo implementado en Figura
    Arrays.sort(figuras);


    System.out.println("\n--- COLECCIÓN DESPUÉS DE ORDENAR (Por Área Menor a Mayor) ---");
    imprimirColeccion(figuras);

}