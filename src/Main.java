package src;

import usuarios.Cliente;

public class Main {
    public static void main (String [] args) {
        Cliente clientePrueba = new Cliente ("Juan", "Rivera", "4432344234");
        System.out.println(clientePrueba.toString());
    }
}
