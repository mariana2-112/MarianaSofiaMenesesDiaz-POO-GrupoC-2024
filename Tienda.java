import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Maquillaje> productosMaquillaje = new ArrayList<>();
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<>();
    private ArrayList<Electrodomestico> productosElectrodomestico = new ArrayList<>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void registrarCliente() {
        int id = validarIdCliente();
        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa la direccion: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, direccion);
        clientes.add(cliente);

        System.out.println("¡Cliente registrado con éxito!");
    }

    public void consultarClientes() {
        System.out.println("*** CLIENTES ***");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.obtenerInformacion());
        }
    }

    public int validarIdCliente() {
        boolean idValido;
        int id;
        do {
            idValido = true;
            id = random.nextInt(1000) + 1;
            for (Cliente cliente : clientes) {
                if (id == cliente.getId()) {
                    idValido = false;
                    break;
                }
            }
        } while (!idValido);
        return id;
    }

    public ArrayList<String> registrarDatosComun() {
        ArrayList<String> datos = new ArrayList<>();
        System.out.print("Ingresa un nombre: ");
        String nombre = scanner.nextLine();
        datos.add(nombre);

        System.out.print("Ingresa el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        datos.add(String.valueOf(precio));

        System.out.print("Ingresa la fecha de importacion: ");
        String fecha = scanner.nextLine();
        datos.add(fecha);

        System.out.print("Ingresa el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        datos.add(String.valueOf(stock));

        return datos;
    }

    public void registrarProductoLimpieza() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria limpieza ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        System.out.print("Ingresa la marca: ");
        String marca = scanner.nextLine();

        Limpieza limpieza = new Limpieza(nombre, precio, fecha, stock, marca);
        productosLimpieza.add(limpieza);
    }

    public void consultarProductosLimpieza() {
        System.out.println("*** PRODUCTOS LIMPIEZA***");
        for (Limpieza producto : productosLimpieza) {
            System.out.println(producto.obtenerInformacionConMarca());
        }
    }

    public void añadirStockLimpieza() {
        consultarProductosLimpieza();
        System.out.print("Ingresa el nombre del producto de limpieza al que deseas añadir stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas añadir: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Limpieza producto : productosLimpieza) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.agregarStock(cantidad);
                System.out.println("Stock añadido");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void disminuirStockLimpieza() {
        consultarProductosLimpieza();
        System.out.print("Ingresa el nombre del producto de limpieza al que deseas eliminar stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas eliminar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Limpieza producto : productosLimpieza) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.eliminarStock(cantidad);
                System.out.println("Stock eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void registrarProductoElectrodomestico() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Electrodomestico ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        System.out.print("Ingresa el voltaje: ");
        String voltaje = scanner.nextLine();

        Electrodomestico electrodomestico = new Electrodomestico(nombre, precio, fecha, stock, voltaje);
        productosElectrodomestico.add(electrodomestico);
    }

    public void consultarProductosElectrodomestico() {
        System.out.println("*** PRODUCTOS ELECTRODOMESTICO***");
        for (Electrodomestico producto : productosElectrodomestico) {
            System.out.println(producto.obtenerInformacionConVoltaje());
        }
    }

    public void añadirStockElectrodomestico() {
        consultarProductosElectrodomestico();
        System.out.print("Ingresa el nombre del electrodomestico al que deseas añadir stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas añadir: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Electrodomestico producto : productosElectrodomestico) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.agregarStock(cantidad);
                System.out.println("Stock añadido");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void disminuirStockElectrodomestico() {
        consultarProductosElectrodomestico();
        System.out.print("Ingresa el nombre del electrodomestico al que deseas eliminar stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas eliminar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Electrodomestico producto : productosElectrodomestico) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.eliminarStock(cantidad);
                System.out.println("Stock eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void registrarProductosAlimento() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Alimento ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        System.out.print("Ingresa la caducidad: ");
        String caducidad = scanner.nextLine();

        Alimento alimento = new Alimento(nombre, precio, fecha, stock, caducidad);
        productosAlimento.add(alimento);
    }

    public void consultarProductosCaducidad() {
        System.out.println("*** PRODUCTOS ALIMENTOS***");
        for (Alimento producto : productosAlimento) {
            System.out.println(producto.obtenerInformacionConCaducidad());
        }
    }

    public void añadirStockAlimento() {
        consultarProductosCaducidad();
        System.out.print("Ingresa el nombre del alimento al que deseas añadir stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas añadir: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Alimento producto : productosAlimento) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.agregarStock(cantidad);
                System.out.println("Stock añadido");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void disminuirStockAlimento() {
        consultarProductosCaducidad();
        System.out.print("Ingresa el nombre del alimento al que deseas eliminar stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas eliminar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Alimento producto : productosAlimento) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.eliminarStock(cantidad);
                System.out.println("Stock eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void registrarProductosMaquillaje() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria maquillaje ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        System.out.print("Ingresa el color: ");
        String color = scanner.nextLine();

        Maquillaje maquillaje = new Maquillaje(nombre, precio, fecha, stock, color);
        productosMaquillaje.add(maquillaje);
    }

    public void consultarProductosMaquillaje() {
        System.out.println("*** PRODUCTOS MAQUILLAJE***");
        for (Maquillaje producto : productosMaquillaje) {
            System.out.println(producto.obtenerInformacionConColor());
        }
    }

    public void añadirStockMaquillaje() {
        consultarProductosMaquillaje();
        System.out.print("Ingresa el nombre del maquillaje al que deseas añadir stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas añadir: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Maquillaje producto : productosMaquillaje) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.agregarStock(cantidad);
                System.out.println("Stock añadido");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void disminuirStockMaquillaje() {
        consultarProductosMaquillaje();
        System.out.print("Ingresa el nombre del maquillaje al que deseas eliminar stock: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingresa la cantidad de stock que deseas eliminar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (Maquillaje producto : productosMaquillaje) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.eliminarStock(cantidad);
                System.out.println("Stock eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void consultarProductos() {
        consultarProductosLimpieza();
        consultarProductosElectrodomestico();
        consultarProductosCaducidad();
        consultarProductosMaquillaje();
    }

    private Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.esNombreIgual(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public void realizarCompra() {
        System.out.println("Ingresa el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
    
        Cliente cliente = buscarClientePorNombre(nombreCliente);
        if (cliente == null) {
            System.out.println("Cliente no registrado. Debes registrarte antes de realizar una compra.");
            return;
        }
    
        consultarProductos();
    
        System.out.println("Ingresa el nombre del producto que deseas comprar: ");
        String nombreProducto = scanner.nextLine();
    
        Producto producto = buscarProductoPorNombre(nombreProducto);
    
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
    
        System.out.println("Ingresa la cantidad que deseas comprar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
    
        if (producto.getStock() < cantidad) {
            System.out.println("No hay suficiente stock disponible.");
            return;
        }
    
        Compra compra = new Compra(cliente);
        compra.agregarProducto(producto, cantidad);
        producto.eliminarStock(cantidad);
    
        System.out.println("Compra realizada con éxito:");
        compra.mostrarDetalleCompra();
    }
    
    private Producto buscarProductoPorNombre(String nombre) {
        Producto producto = buscarProductoPorNombreLimpieza(nombre);
        if (producto != null) return producto;
    
        producto = buscarProductoPorNombreElectrodomestico(nombre);
        if (producto != null) return producto;
    
        producto = buscarProductoPorNombreAlimento(nombre);
        if (producto != null) return producto;
    
        producto = buscarProductoPorNombreMaquillaje(nombre);
        return producto;
    }
    
    private Limpieza buscarProductoPorNombreLimpieza(String nombre) {
        for (Limpieza producto : productosLimpieza) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    private Electrodomestico buscarProductoPorNombreElectrodomestico(String nombre) {
        for (Electrodomestico producto : productosElectrodomestico) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    private Alimento buscarProductoPorNombreAlimento(String nombre) {
        for (Alimento producto : productosAlimento) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    private Maquillaje buscarProductoPorNombreMaquillaje(String nombre) {
        for (Maquillaje producto : productosMaquillaje) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
