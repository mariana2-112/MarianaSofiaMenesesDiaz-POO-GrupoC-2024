public class Cliente {
    private int id;

    private String nombre;

    private String direccion;

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public String obtenerInformacion(){
        return String.format("Id: %d Nombre: %s y direccion: %s", id, nombre, direccion);
    }
    public boolean esNombreIgual(String nombre) {
        return this.nombre.equalsIgnoreCase(nombre);
    }

}
