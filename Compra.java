import java.util.ArrayList;

public class Compra {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private double total;

    public Compra(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
        total += producto.getPrecio() * cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void mostrarDetalleCompra() {
        System.out.println("Cliente: " + cliente.getNombre());
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("Producto: " + productos.get(i).getNombre() + ", Cantidad: " + cantidades.get(i));
        }
        System.out.println("Total: $" + total);
    }
}
