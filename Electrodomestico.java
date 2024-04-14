public class Electrodomestico extends Producto {
    private String voltaje;

    public Electrodomestico(String nombre, double precio, String fechaImportacion, int stock,
            String voltaje) {
        super(nombre, precio, fechaImportacion, stock);
        this.voltaje = voltaje;
    }

    public String obtenerInformacionConVoltaje() {
        return super.obtenerInformacion() + " Voltaje: " + voltaje;
    }
}
