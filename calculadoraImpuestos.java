
import java.util.Scanner;

public class calculadoraImpuestos {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el tipo de cálculo (1 para ingresos, 2 para ventas, 3 para dividendos):");
        int tipoCalculo = leer.nextInt();

        double resultado = 0;

        switch (tipoCalculo) {
            case 1:
                System.out.println("Ingrese el monto de ingresos:");
                int ingresos = leer.nextInt();
                resultado = calcularImpuestos(ingresos);
                break;
            case 2:
                System.out.println("Ingrese el monto de ventas:");
                double ventas = leer.nextDouble();
                System.out.println("Ingrese el porcentaje de impuestos:");
                double porcentajeImpuestos = leer.nextDouble();
                resultado = calcularImpuestos(ventas, porcentajeImpuestos);
                break;
            case 3:
                System.out.println("Ingrese el monto de dividendos:");
                double dividendos = leer.nextDouble();
                System.out.println("Ingrese el porcentaje de impuestos:");
                porcentajeImpuestos = leer.nextDouble();
                System.out.println("Ingrese el monto de exención:");
                double exencion = leer.nextDouble();
                resultado = calcularImpuestos(dividendos, porcentajeImpuestos, exencion);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        System.out.println("El resultado es: " + resultado);

        leer.close();
    }
    
    public static double calcularImpuestos(int ingresos) {
        return ingresos + 0.15;
    }

    public static double calcularImpuestos(double ventas, double porcentajeImpuestos) {
        return ventas * (porcentajeImpuestos / 100);
    }

    public static double calcularImpuestos(double dividendos, double porcentajeImpuestos, double exencion) {
        double impuestos = dividendos * (porcentajeImpuestos / 100);
        if (impuestos > exencion) {
            return impuestos - exencion;
        } else {
            return 0;
        }
    }

    public static double calcularImpuestos(int ingresos, double porcentajeImpuestos, double dividendos, double exencion) {
        double impuestos = 0;

        if (ingresos != 0) {
            impuestos = ingresos + (ingresos * (porcentajeImpuestos / 100));
        } else if (dividendos != 0) {
            impuestos = dividendos * (porcentajeImpuestos / 100);
            if (impuestos > exencion) {
                impuestos -= exencion;
            } else {
                impuestos = 0;
            }
        }
        return impuestos;
    }

    
}