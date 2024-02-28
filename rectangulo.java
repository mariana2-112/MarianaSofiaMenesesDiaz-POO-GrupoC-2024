import java.util.Scanner;

public class rectangulo {
     public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa la base");
        double base = leer.nextInt();
        if(base/2==0){
            base=(int)base;
        }
        System.out.println("Ingresa la altura");
        double altura = leer.nextInt();
        if(altura/2==0){
            altura=(int)base;
        }

        Rec rec1 = new Rec(base, altura);

        System.out.println("Área del rectángulo: " + rec1.calcularArea());
        System.out.println("Perímetro del rectángulo: " + rec1.calcularPerimetro());
        leer.close();
    }

    public static class Rec {

        double base;
        double altura;
        int base1;
        int altura1;

        public Rec(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }
        
         public Rec(int base, int altura) {
            this.base = base;
            this.altura = altura;
        }

        public double calcularArea() {
            return base * altura;
        }
       
        public double calcularPerimetro() {
            return 2 * (base + altura);
        }

    }
}
