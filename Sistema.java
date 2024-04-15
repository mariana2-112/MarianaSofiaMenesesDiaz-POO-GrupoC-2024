
import java.util.Scanner;

public class Sistema {
    private final String CONTRASEÑA = "123";
    private Scanner scanner = new Scanner(System.in);
    private Tienda tienda = new Tienda();

    public void ejecutarPrograma() {
        boolean contraseñaValida = false;

        do {
            System.out.println("*** BIENVENIDO ***");
            System.out.print("INGRESA LA CONTRASEÑA PARA PODER ACCEDER AL SISTEMA: ");

            String contraseña = scanner.nextLine();

            if (validarContraseña(contraseña)) {
                contraseñaValida = true;
                mostrarMenuSistema();
            } else {
                System.out.println("Contraseña invalida intenta de nuevo.\n");
            }
        } while (!contraseñaValida);
    }

    private boolean validarContraseña(String contraseña) {
        return contraseña.equals(CONTRASEÑA);

    }

    private void mostrarMenuSistema() {

        int opcion = 0;
        

        do {
            System.out.println("ELIGE UNA OPCION PARA CONTINUAR");
            System.out.println("*** BIENVENIDOS ***");
            System.out.println("1.- Agregar cliente");
            System.out.println("2.- Agregar producto");
            System.out.println("3.- Añadir a stock");
            System.out.println("4.- Disminuir Stock");
            System.out.println("5.- Listar clientes");
            System.out.println("6.- Consultar productos por categoria");
            System.out.println("7.- Listar Productos");
            System.out.println("8.- Comprar");
            System.out.println("9.- Consultar compras");
            System.out.println("10.- Eliminar productos y clientes");
            System.out.println("11. Salir");

            System.out.print("Ingresa la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Agregar cliente
                    tienda.registrarCliente();

                    break;
                case 2: // Agregar producto
                    System.out.println("Ingresa el tipo de producto que deseas agregar: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    int opcionProducto = scanner.nextInt();

                    switch (opcionProducto) {
                        case 1:
                            tienda.registrarProductoLimpieza();

                            break;
                        case 2:
                            tienda.registrarProductoElectrodomestico();
                            break;

                        case 3:
                            tienda.registrarProductosAlimento();
                            break;

                        case 4:
                            tienda.registrarProductosMaquillaje();
                            break;

                        default:
                            break;
                    }

                    break;

                case 3: // Añadir a stock
                    System.out.println("Ingresa el tipo de producto al que le deseas añadir stock: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    int opcionProductoAñadirStock = scanner.nextInt();

                    switch (opcionProductoAñadirStock) {
                        case 1:
                            tienda.añadirStockLimpieza();
                            break;
                        case 2:
                            tienda.añadirStockElectrodomestico();
                            break;
                        case 3:
                            tienda.añadirStockAlimento();
                            break;
                        case 4:
                            tienda.añadirStockMaquillaje();
                            break;

                    }

                    break;
                case 4: // Disminuir Stock
                    System.out.println("Ingresa el tipo de producto al que le deseas eliminar stock: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    int opcionProductoEliminarStock = scanner.nextInt();

                    switch (opcionProductoEliminarStock) {
                        case 1:
                            tienda.disminuirStockLimpieza();
                            break;
                        case 2:
                            tienda.disminuirStockElectrodomestico();
                            break;
                        case 3:
                            tienda.disminuirStockAlimento();
                            break;
                        case 4:
                            tienda.disminuirStockMaquillaje();
                            break;
                    }

                case 5: // Listar clientes
                    tienda.consultarClientes();
                    break;
                case 6:

                    System.out.println("Ingresa el tipo de producto que deseas consultar");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos ");
                    System.out.println("3.- Alimento ");
                    System.out.println("4.- Maquillaje");

                    int opcionProductoConsulta = scanner.nextInt();

                    switch (opcionProductoConsulta) {
                        case 1:
                            tienda.consultarProductosLimpieza();
                            break;
                        case 2:
                            tienda.consultarProductosElectrodomestico();
                            break;
                        case 3:
                            tienda.consultarProductosCaducidad();
                            break;
                        case 4:
                            tienda.consultarProductosMaquillaje();
                            break;

                    }

                    break;
                case 7:
                    tienda.consultarProductos();
                    break;
                case 8: // Comprar
                    tienda.realizarCompra();
                    break;
                case 9: // Consultar compras
                    tienda.consultarCompras();
                    break;
                case 10: // Eliminar productos y clientes
                    System.out.println("ELIMINAR OPCIONES");
                    System.out.println("1.- Eliminar cliente");
                    System.out.println("2.- Eliminar producto");
                    System.out.println("3.- Regresar al menú principal");
                    int opcionEliminar = scanner.nextInt();

                    switch (opcionEliminar) {
                        case 1:
                            tienda.eliminarCliente();
                            break;
                        case 2:
                            tienda.eliminarProducto();
                            break;
                        case 3:
                            break;
                    }
                    mostrarMenuSistema();
                    return;
                case 11:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("INGRESE UNA OPCIÓN VALIDA");

            }

        } while (opcion != 11);
    }
}
