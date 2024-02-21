
public class Ejercicio1 {

    public static void main(String[] args) {
        Persona primeraPersona = new Persona("Juan", 38, false, "doctor", "Mexicano");
        Persona segundaPersona = new Persona("Andrea", 15, true, "estudiante", "Venezolana");
        Persona terceraPersona = new Persona("Daniel", 18, false, "estudiante", "Colombiano");
        Persona cuartaPersona = new Persona("Silvia", 50, true, "Maestra", "Mexicana");
        
        System.out.println(primeraPersona.personaInfo());
        System.out.println(segundaPersona.personaInfo());
        System.out.println(terceraPersona.personaInfo());
        System.out.println(cuartaPersona.personaInfo());
    }
    
    public static class Persona {
    
        String nombre;
        int edad;
        boolean esMujer;
        String ocupacion; 
        String nacionalidad;
        
        public Persona(String nombre, int edad, boolean esMujer, String ocupacion, String nacionalidad){
            this.nombre = nombre; 
            this.edad = edad; 
            this.esMujer = esMujer;
            this.ocupacion = ocupacion;
            this.nacionalidad = nacionalidad;
        }
        
        String personaInfo(){
            return "Nombre: " + this.nombre + ", Edad: " + edad + ", Es mujer: " + esMujer + ", Ocupacion: " + ocupacion + ", Nacionalidad: " + nacionalidad;
        }
    }
}