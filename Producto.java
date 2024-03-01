
public class Producto {
    
    public static void main(String[] args) {

    Producto producto1 = new Producto("Camisa", 25.99, 50);
    System.out.println("Nombre: " + producto1.getNombre());
    System.out.println("Precio: " + producto1.getPrecio());
    System.out.println("Stock: " + producto1.getStock());

    Producto producto2 = new Producto("Pantalón", 39.99);
    System.out.println("Nombre: " + producto2.getNombre());
    System.out.println("Precio: " + producto2.getPrecio());
    System.out.println("Stock: " + producto2.getStock());

    producto2.aumentarStock(20);
    System.out.println("Nuevo stock del producto 2: " + producto2.getStock());

    producto1.reducirStock(10);
    System.out.println("Nuevo stock del producto 1: " + producto1.getStock());
}

private String nombre;
private double precio;
private int stock;

public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
}

public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = 0;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    if (nombre != null) {
        this.nombre = nombre;
    } else {
        System.out.println("El nombre no puede ser nulo");
    }
}

public double getPrecio() {
    return precio;
}

public void setPrecio(double precio) {
    if (precio >= 0) {
        this.precio = precio;
    } else {
        System.out.println("El precio no puede ser negativo");
    }
}

public int getStock() {
    return stock;
}

public void setStock(int stock) {
    if (stock >= 0) {
        this.stock = stock;
    } else {
        System.out.println("El stock no puede ser negativo");
    }
}

public void aumentarStock(int cantidad) {
    if (cantidad > 0) {
        this.stock += cantidad;
    } else {
        System.out.println("La cantidad a aumentar debe ser mayor que cero");
    }
}

public void reducirStock(int cantidad) {
    if (cantidad > 0 && cantidad <= this.stock) {
        this.stock -= cantidad;
    } else {
        System.out.println("La cantidad a reducir debe ser mayor que cero y menor o igual al stock actual");
    }
}

}