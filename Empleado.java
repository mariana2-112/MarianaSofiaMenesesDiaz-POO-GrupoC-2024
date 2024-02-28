import java.util.Scanner;

public class Empleado {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el sueldo base:");
        int sueldoBase = leer.nextInt();

        System.out.println("¿Desea ingresar bonificación? (S/N)");
        String respuestaBonificacion = leer.next().toUpperCase();
        int bonificacion = 0;
        if (respuestaBonificacion.equals("S")) {
            System.out.println("Ingrese la bonificación:");
            bonificacion = leer.nextInt();
        }

        System.out.println("¿Desea ingresar horas extras? (S/N)");
        String respuestaHorasExtras = leer.next().toUpperCase();
        int horasExtras = 0;
        if (respuestaHorasExtras.equals("S")) {
            System.out.println("Ingrese las horas extras:");
            horasExtras = leer.nextInt();
        }

        Empleado empleado1;
        if (respuestaHorasExtras.equals("S")) {
            empleado1 = new Empleado(sueldoBase, bonificacion, horasExtras);
            System.out.println("Salario con bonificación y horas extras: " + empleado1.calcularSalario(bonificacion, horasExtras));
        } else if (respuestaBonificacion.equals("S")) {
            empleado1 = new Empleado(sueldoBase, bonificacion);
            System.out.println("Salario con bonificación: " + empleado1.calcularSalario(bonificacion));
        } else {
            empleado1 = new Empleado(sueldoBase);
            System.out.println("Salario sin bonificación ni horas extras: " + empleado1.calcularSalario());
        }

        leer.close();
    }

    int sueldoBase;
    int bonificacion;
    int horasExtras;

    public Empleado(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public Empleado(int sueldoBase, int bonificacion) {
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
    }

    public Empleado(int sueldoBase, int bonificacion, int horasExtras) {
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
        this.horasExtras = horasExtras;
    }

    public int calcularSalario() {
        return sueldoBase;
    }

    public int calcularSalario(int bonificacion) {
        return sueldoBase + bonificacion;
    }

    public int calcularSalario(int bonificacion, int horasExtras) {
        return sueldoBase + bonificacion + (horasExtras * 20);
    }

}
