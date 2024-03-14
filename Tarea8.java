import java.util.ArrayList;
import java.util.Scanner;

public class Tarea8 {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Menú:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar libro");
            System.out.println("3. Rentar libro");
            System.out.println("4. Listar usuarios registrados");
            System.out.println("5. Listar libros registrados");
            System.out.println("6. Listar usuarios con libros rentados");
            System.out.println("7. Listar libros no rentados");
            System.out.println("8. Listar libros rentados");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    libreria.registrarUsuario(nombreUsuario);
                    break;
                case "2":
                    System.out.print("Ingrese el título del libro: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autorLibro = scanner.nextLine();
                    libreria.registrarLibro(tituloLibro, autorLibro);
                    break;
                case "3":
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    libreria.rentarLibro(nombre, titulo);
                    break;
                case "4":
                    libreria.listarUsuarios();
                    break;
                case "5":
                    libreria.listarLibros();
                    break;
                case "6":
                    libreria.listarUsuariosConLibros();
                    break;
                case "7":
                    libreria.listarLibrosNoRentados();
                    break;
                case "8":
                    libreria.listarLibrosRentados();
                    break;
                case "9":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Seleccione otra opcion");
            }
        }
    }
}

class Libro {
    private String titulo;
    private String autor;
    private boolean rentado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.rentado = false;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerAutor() {
        return autor;
    }

    public boolean estaRentado() {
        return rentado;
    }

    public void establecerRentado(boolean rentado) {
        this.rentado = rentado;
    }
}

class Usuario {
    private String nombre;
    private ArrayList<Libro> librosRentados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosRentados = new ArrayList<>();
    }

    public void rentarLibro(Libro libro) {
        if (!libro.estaRentado()) {
            librosRentados.add(libro);
            libro.establecerRentado(true);
            System.out.println(nombre + " ha rentado el libro: " + libro.obtenerTitulo());
        } else {
            System.out.println("El libro ya está rentado.");
        }
    }

    public String obtenerNombre() {
        return nombre;
    }

    public ArrayList<Libro> obtenerLibrosRentados() {
        return librosRentados;
    }
}

class Libreria {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;

    public Libreria() {
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
    }

    public void registrarUsuario(String nombre) {
        usuarios.add(new Usuario(nombre));
        System.out.println("Usuario " + nombre + " registrado");
    }

    public void registrarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
        System.out.println("Libro " + titulo + " registrado");
    }

    public void rentarLibro(String nombreUsuario, String tituloLibro) {
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.obtenerNombre().equals(nombreUsuario)) {
                usuario = u;
                break;
            }
        }
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        Libro libro = null;
        for (Libro l : libros) {
            if (l.obtenerTitulo().equals(tituloLibro)) {
                libro = l;
                break;
            }
        }
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }

        usuario.rentarLibro(libro);
    }

    public void listarUsuarios() {
        System.out.println("Usuarios registrados: ");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.obtenerNombre());
        }
    }

    public void listarLibros() {
        System.out.println("Libros registrados: ");
        for (Libro libro : libros) {
            System.out.println("Título: " + libro.obtenerTitulo() + ", Autor: " + libro.obtenerAutor());
        }
    }

    public void listarUsuariosConLibros() {
        System.out.println("Usuarios que han rentado al menos un libro:");
        for (Usuario usuario : usuarios) {
            if (!usuario.obtenerLibrosRentados().isEmpty()) {
                System.out.println(usuario.obtenerNombre());
            }
        }
    }

    public void listarLibrosNoRentados() {
        System.out.println("Libros que no han sido rentados:");
        for (Libro libro : libros) {
            if (!libro.estaRentado()) {
                System.out.println("Título: " + libro.obtenerTitulo() + ", Autor: " + libro.obtenerAutor());
            }
        }
    }

    public void listarLibrosRentados() {
        System.out.println("Libros que han sido rentados:");
        for (Libro libro : libros) {
            if (libro.estaRentado()) {
                System.out.println("Título: " + libro.obtenerTitulo() + ", Autor: " + libro.obtenerAutor());
            }
        }
    }
}
