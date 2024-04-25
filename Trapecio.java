public class Trapecio extends Shape {
    public void calcularArea(){
        double radio = 2; 
        radio = radio*radio;
        double area; 
        double pi = 3.1416;
        area = radio * pi;
        System.out.println(area);
     }

     public void calcularPerimetro(){
        double diametro = 3; 
        double pi = 3.1416;
        double perimetro; 
        perimetro = pi * diametro;
        System.out.println(perimetro);

    }
}
