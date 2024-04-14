public class Limpieza extends Producto {
    private String marca;

    public Limpieza(String nombre, double precio, String fechaImportacion, int stock, String marca) {
        super(nombre, precio, fechaImportacion, stock);
        this.marca = marca;

    }

    public String obtenerInformacionConMarca() {
        return super.obtenerInformacion() + " Marca: " + marca;
    }

    public void añadirStock(int cantidad) {
        super.agregarStock(cantidad); 
    }

    public String getNombreProducto() {
        return super.getNombre();  
    }
    

    
}