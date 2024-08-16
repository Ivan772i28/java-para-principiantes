/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrao;

/**
 *
 * @author 52449
 */
public class Cuadrao {
    

    public static void main(String[] args) {
        // TODO code application logic here
        scanner teclado=new scanner(System.in);
        int num,cuadrado;
        System.out.print("introduce el numero:");
        num=teclado.netxInt();
        while(num>=0){
            cuadrado = num*num;
            System.out.println(num+"es igual"+cuadrado);
            System.out.println("introduce otro numero");
            num=teclado.netInt();
        }
        System.out.print("Fin...");
    }
    
}
