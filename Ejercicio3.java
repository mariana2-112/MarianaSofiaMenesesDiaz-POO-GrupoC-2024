public class Ejercicio3 {

    public static void main(String[] args) {

        Rectangulo primerRectangulo = new Rectangulo(5, 10);
        System.out.println("Primer rectángulo:");
        System.out.println("Área: " + primerRectangulo.calcularArea());
        System.out.println("Perímetro: " + primerRectangulo.calcularPerimetro());
        
        Rectangulo segundoRectangulo = new Rectangulo(8, 6);
        System.out.println("\nSegundo rectángulo:");
        System.out.println("Área: " + segundoRectangulo.calcularArea());
        System.out.println("Perímetro: " + segundoRectangulo.calcularPerimetro());
        
        Rectangulo tercerRectangulo = new Rectangulo(3, 7);
        System.out.println("\nTercer rectángulo:");
        System.out.println("Área: " + tercerRectangulo.calcularArea());
        System.out.println("Perímetro: " + tercerRectangulo.calcularPerimetro());
        
        Rectangulo cuartoRectangulo = new Rectangulo(9, 4);
        System.out.println("\nCuarto rectángulo:");
        System.out.println("Área: " + cuartoRectangulo.calcularArea());
        System.out.println("Perímetro: " + cuartoRectangulo.calcularPerimetro());
    }
    
    public static class Rectangulo {
    
        double ancho;
        double altura;

        public Rectangulo(double ancho, double altura){
            this.ancho = ancho;
            this.altura = altura;
        }

        double calcularArea(){
            return ancho * altura;
        }

        double calcularPerimetro(){
            return 2 * (ancho + altura);
        }
    }
}
