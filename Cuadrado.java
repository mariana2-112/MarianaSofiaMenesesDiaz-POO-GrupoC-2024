public class Cuadrado extends Shape {
    public void calcularArea(){
        int lado = 2; 
        int area; 
        area = lado * lado * lado * lado;
        System.out.println(area);
     }

     public void calcularPerimetro(){
        int lado = 2; 
        int area; 
        area = lado * lado;
        System.out.println(area);

    }
}
