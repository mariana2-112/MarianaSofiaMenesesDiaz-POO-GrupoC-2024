
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea7 {
    static Banco banco = new Banco();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("----- Menú -----");
            System.out.println("1. Crear cuenta para un empleado");
            System.out.println("2. Acceder a la cuenta de un empleado");
            System.out.println("3. Mostrar información de todos los usuarios");
            System.out.println("4. Mostrar información de un usuario en específico");
            System.out.println("5. Mostrar todas las cuentas del banco");
            System.out.println("6. Mostrar información de una cuenta en específico");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    crearCuentaParaEmpleado();
                    break;
                case 2:
                    accederCuentaEmpleado();
                    break;
                case 3:
                    mostrarInformacionTodosUsuarios();
                    break;
                case 4:
                    mostrarInformacionUsuarioEspecifico();
                    break;
                case 5:
                    banco.mostrarTodasLasCuentas();
                    break;
                case 6:
                    mostrarInformacionCuentaEspecifica();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Seleccione una opción válida.");
            }
        } while (opcion != 7);

        leer.close();
    }

    public static void crearCuentaParaEmpleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = leer.nextLine();

        Empleado empleado = banco.buscarEmpleado(nombre);
        if (empleado == null) {
            empleado = new Empleado(nombre);
            banco.agregarEmpleado(empleado);
        }

        System.out.print("Ingrese el tipo de cuenta (A, B o C): ");
        char tipoCuenta;
        do {
            tipoCuenta = leer.nextLine().toUpperCase().charAt(0);
            if (tipoCuenta != 'A' && tipoCuenta != 'B' && tipoCuenta != 'C')
                System.out.print("Ingrese A, B o C: ");
        } while (tipoCuenta != 'A' && tipoCuenta != 'B' && tipoCuenta != 'C');

        System.out.print("Ingrese el número de cuenta: ");
        long numeroCuenta = leer.nextLong();
        leer.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, tipoCuenta);
        empleado.agregarCuenta(cuenta);

        System.out.println("Cuenta creada para el empleado " + nombre);
    }

    public static void accederCuentaEmpleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombreEmpleado = leer.nextLine();

        Empleado empleado = banco.buscarEmpleado(nombreEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese nombre.");
            return;
        }

        int opcion;
        do {
            System.out.println("----- Menú de Cuenta -----");
            System.out.println("1. Agregar dinero a una cuenta");
            System.out.println("2. Retirar dinero de una cuenta");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    agregarDinero(empleado);
                    break;
                case 2:
                    retirarDinero(empleado);
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }

    public static void agregarDinero(Empleado empleado) {
        System.out.print("Ingrese el número de cuenta: ");
        long numeroCuenta = leer.nextLong();
        leer.nextLine();

        CuentaBancaria cuenta = empleado.buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("No se encontró ninguna cuenta con ese número.");
            return;
        }

        System.out.print("Ingrese la cantidad a depositar (positiva): ");
        double cantidad = leer.nextDouble();
        leer.nextLine();

        cuenta.depositar(cantidad);
    }

    public static void retirarDinero(Empleado empleado) {
        System.out.print("Ingrese el número de cuenta: ");
        long numeroCuenta = leer.nextLong();
        leer.nextLine();

        CuentaBancaria cuenta = empleado.buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("No se encontró ninguna cuenta con ese número.");
            return;
        }

        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = leer.nextDouble();
        leer.nextLine();

        cuenta.retirar(cantidad);
    }

    public static void mostrarInformacionTodosUsuarios() {
        banco.mostrarInformacionTodosEmpleados();
    }

    public static void mostrarInformacionUsuarioEspecifico() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombreEmpleado = leer.nextLine();

        Empleado empleado = banco.buscarEmpleado(nombreEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese nombre.");
        } else {
            empleado.mostrarInformacion();
        }
    }

    public static void mostrarInformacionCuentaEspecifica() {
        System.out.print("Ingrese el número de cuenta: ");
        long numeroCuenta = leer.nextLong();
        leer.nextLine();

        CuentaBancaria cuenta = banco.buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("No hay cuenta con ese numero");
        } else {
            cuenta.mostrarInformacion();
        }
    }

    public static class Empleado {
        private String nombre;
        private ArrayList<CuentaBancaria> cuentas;

        public Empleado(String nombre) {
            this.nombre = nombre;
            this.cuentas = new ArrayList<>();
        }

        public void agregarCuenta(CuentaBancaria cuenta) {
            cuentas.add(cuenta);
        }

        public String getNombre() {
            return nombre;
        }

        public CuentaBancaria buscarCuenta(long numeroCuenta) {
            for (CuentaBancaria cuenta : cuentas) {
                if (cuenta.getNumeroCuenta() == numeroCuenta) {
                    return cuenta;
                }
            }
            return null;
        }

        public void mostrarInformacion() {
            System.out.println("Nombre del empleado: " + nombre);
            System.out.println("Cuentas:");
            for (CuentaBancaria cuenta : cuentas) {
                cuenta.mostrarInformacion();
            }
        }
    }

    public static class CuentaBancaria {
        private long numeroCuenta;
        private char tipoCuenta;
        private double cantidad;

        public CuentaBancaria(long numeroCuenta, char tipoCuenta) {
            this.numeroCuenta = numeroCuenta;
            this.tipoCuenta = tipoCuenta;
            this.cantidad = 0; 
        }

        public long getNumeroCuenta() {
            return numeroCuenta;
        }

        public double getCantidad() {
            return cantidad;
        }

        public void setCantidad(double cantidad) {
            this.cantidad = cantidad;
        }

        public char getTipoCuenta() {
            return tipoCuenta;
        }

        public void depositar(double cantidad) {
            this.cantidad += cantidad;
            System.out.println("Se realizo el deposito. Nuevo saldo: " + this.cantidad);
        }

        public void retirar(double cantidad) {
            if (this.cantidad - cantidad >= obtenerSaldoMinimo()) {
                this.cantidad -= cantidad;
                System.out.println("Se realizo el retiro Nuevo saldo: " + this.cantidad);
            } else {
                System.out.println("Saldo insuficiente");
            }
        }

        private double obtenerSaldoMinimo() {
            switch (tipoCuenta) {
                case 'A':
                    return 1000;
                case 'B':
                    return 5000;
                case 'C':
                    return 10000;
                default:
                    return 0;
            }
        }

        public void mostrarInformacion() {
            System.out.println("Número de cuenta: " + numeroCuenta);
            System.out.println("Tipo de cuenta: " + tipoCuenta);
            System.out.println("Saldo: " + cantidad);
        }
    }

    public static class Banco {
        private ArrayList<Empleado> empleados;

        public Banco() {
            this.empleados = new ArrayList<>();
        }

        public void agregarEmpleado(Empleado empleado) {
            empleados.add(empleado);
        }

        public Empleado buscarEmpleado(String nombre) {
            for (Empleado empleado : empleados) {
                if (empleado.getNombre().equals(nombre)) {
                    return empleado;
                }
            }
            return null;
        }

        public CuentaBancaria buscarCuenta(long numeroCuenta) {
            for (Empleado empleado : empleados) {
                CuentaBancaria cuenta = empleado.buscarCuenta(numeroCuenta);
                if (cuenta != null) {
                    return cuenta;
                }
            }
            return null;
        }

        public void mostrarInformacionTodosEmpleados() {
            for (Empleado empleado : empleados) {
                empleado.mostrarInformacion();
                System.out.println();
            }
        }

        public void mostrarTodasLasCuentas() {
            for (Empleado empleado : empleados) {
                for (CuentaBancaria cuenta : empleado.cuentas) {
                    cuenta.mostrarInformacion();
                }
            }
        }
    }
}
