
package ejemplo;
import java.util.Scanner;
public class Ejemplo {

    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("ingresa tu nombre");
        System.out.println("ingresa tu edad");
        String nombre = sc.nextLine();
        System.out.println(" hola "+ nombre);
        String edad = sc.nextLine();
        System.out.println("tu edad es "+ edad);
        
    }
    
}
