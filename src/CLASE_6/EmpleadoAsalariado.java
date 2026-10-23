package CLASE_6;

import CLASE_5.Empleado;

public class EmpleadoAsalariado extends Empleado {
    double sueldoBasico;
    double bono;

    public EmpleadoAsalariado(String nombre, int legajo) {
        super(nombre, legajo);
        this.sueldoBasico = 0.0;
        this.bono = 0.0;
    } // Se resuelve en compilación, ya que el constructor de la clase padre se llama automáticamente si no se especifica.

    public EmpleadoAsalariado(String nombre, int legajo, double sueldoBasico, double bono) {
        super(nombre, legajo);
        this.sueldoBasico = sueldoBasico;
        this.bono = bono;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    @Override
    public double calcularSueldo() {
        double total = sueldoBasico + bono;
        return super.calcularSueldo() + total;
    } // Se resuelve en tiempo de ejecución, ya que el método calcularSueldo() se llama desde un objeto de la clase hija, y se ejecuta la versión sobreescrita del método.
      // Cuando se ejecuta el programa la JVM determina en tiempo de ejecución que el objeto es de tipo EmpleadoAsalariado y llama al método calcularSueldo() de esa clase,
      // en lugar del método calcularSueldo() de la clase padre Empleado.
}
