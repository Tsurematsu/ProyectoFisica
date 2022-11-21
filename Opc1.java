package Interfaces;
import AppData.Methods;
import java.util.Scanner;


public class Opc1 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc1(), ()->Main(),()->loop());

    
    
    static void Main(){

        Scanner entrada= new Scanner (System.in);

        System.out.println("HALLAR LA CARGA DE UN CONDENSADOR");
        System.out.println("----------------------------------------------------------");
        System.out.print("Ingrese el valor de capacitor (C):");
        int capacitor= entrada.nextInt();
        System.out.print("Ingrese el valor de la diferencia potencial (V):");
        int potencial= entrada.nextInt();
        System.out.println("Para la resolución del ejercicio hay que tener en cuenta la siguiente formula Q=CV");
        
        System.out.println("Por lo que se procede a reemplazar los valores en la formula:");

        System.out.println("C= "+capacitor+" uF");

        double U= 10;
        double elevado= Math.pow(U, -6);

        System.out.println("V= "+potencial+" Voltios");

        System.out.println("Hay que tener en cuenta que uF significa x10^-6 F");

        double capacitor2= capacitor*elevado;

        System.out.println("Por lo que el valor del capacitor al multiplicarlo por ese numero queda como:"+ capacitor2+"F");

        double resultado= capacitor2*potencial;
        System.out.println("El resultado es = "+resultado+"C");
        

    }
    static void loop(){

    }
}
