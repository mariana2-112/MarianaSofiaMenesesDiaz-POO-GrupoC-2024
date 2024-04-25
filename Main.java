public class Main {
    public static void main(String[] args) {
        Rombo rombo1 = new Rombo();
        Trapecio trapecio1 = new Trapecio();
        Cuadrado cuadrado1 = new Cuadrado();


        System.out.println("ROMBO");
        System.out.println("Area");

        rombo1.calcularArea();;

        System.out.println("Perimetro");
        rombo1.calcularPerimetro();

        System.out.println("TRAPECIO");
        System.out.println("Area");
        trapecio1.calcularArea();

        System.out.println("Perimetro");
        trapecio1.calcularPerimetro();
        
        System.out.println("CUADRADO");
        System.out.println("Area");
        cuadrado1.calcularArea();
        
        System.out.println("Perimetro");
        cuadrado1.calcularPerimetro();

    }
}
