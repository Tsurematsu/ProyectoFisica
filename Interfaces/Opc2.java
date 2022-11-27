package Interfaces;

import AppData.Methods;
import AppData.Plantilla;

public class Opc2 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc2(), ()->Main(),()->loop());
    static Plantilla panel1;
    static void Main(){
        panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="HALLAR EL AREA DE LA CARGA ELECTRICA";
        panel1.Descripcion="Introduzca el valor de la carga(Q) y el valor del campo(E) para calcular el area <br> Para el Desarrolo del ejercicio hay que tener en cuenta la siguiente formula: <br> <center> A = Q/E(E0) </center> <br> se tiene en cuenta que (E0= 8,85x10^-12) "; 
        panel1.Input1="ingresa el valor de la carga (Q)";
        panel1.Input2="Ingresa el valor del campo (E)= N/C";
        

        panel1.Formula = ()->{
            Integer carga = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer campo = Integer.valueOf(panel1.$_Intput2_Retorno);
            Double pers= 8.85;

            Integer res= msg_Option("¿El dato ingresado en la carga es en microCoulom o nanoCoulom?", new String[]{"MicroCoulom","NanoCoulom"});

            if (res==0){
                // POTENCIA DE LA CARGA
                double elevado= Math.pow(10, -9);
                // CARGA* SU POTENCIA
                double numpt= carga*elevado;

                // POTENCIA DE LA PERMISIVIDAD
                double elevado2= Math.pow(10, -12);
                // PERMISIVIDAD * SU POTENCIA
                double permsfin= pers*elevado2;

                double arriba= numpt;
                double abajo = campo*permsfin;

                double resultado= arriba/abajo;
                String res1 = "El resultado es " + (resultado+" m²");
                panel1.$_Retorno_Formula= res1;

            }

            Integer calculo;
            

            // test
           
            // panel1.$_Retorno_Formula= res1;
        };


        panel1.Cuestionario="";
        panel1.resultado=0.0;
        

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();
    }
    static void loop(){
        panel1.ReloadCuestions();
    }
    
}
