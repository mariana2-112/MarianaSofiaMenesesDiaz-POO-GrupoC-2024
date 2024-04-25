public class Rombo extends Shape {
    public void calcularArea(){
       int base = 2; 
       int altura = 3;
       int area; 
       area = base*altura;
       System.out.println(area);
    }

    public void calcularPerimetro(){
        int base = 2; 
        int altura = 3;
        int perimetro; 
        perimetro = base + base + altura + altura;
        System.out.println(perimetro);

    }
}
