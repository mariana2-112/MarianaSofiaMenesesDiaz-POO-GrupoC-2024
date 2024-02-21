public class Ejercicio2 {

    public static void main(String[] args) {
        Libro primerLibro = new Libro();
        System.out.println("Primer libro");
        System.out.println(primerLibro.libroInfo());
  
        Libro segundoLibro = new Libro();
        segundoLibro.titulo = "El principito";
        segundoLibro.autor = "Antoine de Saint-Exupéry";
        segundoLibro.anioPublicacion = 1943;
        
        Libro tercerLibro = new Libro();
        tercerLibro.titulo = "Harry Potter y la piedra filosofal";
        tercerLibro.autor = "J.K. Rowling";
        tercerLibro.anioPublicacion = 1997;
        
        Libro cuartoLibro = new Libro();
        cuartoLibro.titulo = "Cien años de soledad";
        cuartoLibro.autor = "Gabriel García Márquez";
        cuartoLibro.anioPublicacion = 1967;

        System.out.println("\nSegundo libro");
        System.out.println(segundoLibro.libroInfo());
        
        System.out.println("\nTercer libro");
        System.out.println(tercerLibro.libroInfo());
        
        System.out.println("\nCuarto libro");
        System.out.println(cuartoLibro.libroInfo());
    }
    
    public static class Libro {
    
        String titulo;
        String autor;
        int anioPublicacion;

        String libroInfo(){
            return "Título: " + this.titulo + ", Autor: " + autor + ", Año de publicación: " + anioPublicacion;
        }
    }
}
