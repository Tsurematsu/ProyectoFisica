package Interfaces;

import java.util.Scanner;
import java.util.function.DoublePredicate;

import AppData.Methods;

public class Opc3 extends Methods {

    
    
    public static void main(String[] args) {
        
    
    Scanner scan = new Scanner(System.in);

    System.out.println("Seleccione 1 si maneja datos en microcoulomb y Metros.");
    System.out.println("Seleccione 2 si maneja datos en Nanocoulomb y Metros.");
    System.out.println("Seleccione 3 si maneja datos en microcoulomb y Centimetros.");
    System.out.println("Seleccione 4 si maneja datos en Nanocoulomb y Centimetros.");

    int opcion = scan.nextInt();

    switch (opcion){

        case 1:

            System.out.println("Ingrese el valor de la carga");
            double Q = scan.nextInt();
            System.out.println("Ingrese el valor de la distancia");
            double R = scan.nextInt();

            double microcoulomb = Math.pow(10 , -6);
            double distancia = Math.pow(R,2);
            double campoElectrico = (Q * microcoulomb)/distancia; 

            System.out.println(campoElectrico + " Voltios");

        break;
        
        case 2:
            
            System.out.println("Ingrese el valor de la carga");
            double QN = scan.nextInt();
            System.out.println("Ingrese el valor de la distancia");
            double RN = scan.nextInt();

            double nanocoulomb = Math.pow(10 , -9);
            double distanciaN = Math.pow(RN,2);
            double campoElectricoN = (QN * nanocoulomb)/distanciaN; 

            System.out.println(campoElectricoN + " Voltios");
            
        break;
        
        case 3:
            
            
        break;
        
        case 4:
        
        break;
    }
 
}


    static void loop(){

    }
}
