public class Producto {
    public static int CANTIDAD_PRODUCTOS = 0;

    private String nombre;
    private double precio;
    private String fechaImportacion;
    private int numeroSerie;
    private int stock;

    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.numeroSerie = CANTIDAD_PRODUCTOS += 1;
        CANTIDAD_PRODUCTOS = CANTIDAD_PRODUCTOS += 1;
    }

    public void agregarStock(int cantidad) {
        stock += cantidad;
    }

    public void eliminarStock(int cantidad) {
        if (validarStock()) {
            System.out.println("");
        } else {
            stock -= cantidad;
        }
    }

    private boolean validarStock() {
        return stock == 0;
    }

    public String obtenerInformacion() {
        return String.format("Nombre: %s, precio: %f, fecha importacion: %s, stock: %d, numero de serie: %d", nombre, precio, fechaImportacion, stock, numeroSerie);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return this.stock; // Asumiendo que 'stock' es el atributo que almacena la cantidad de stock.
    }
}
