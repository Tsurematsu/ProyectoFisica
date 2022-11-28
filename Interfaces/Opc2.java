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
        panel1.Descripcion="Introduzca el valor de la carga(Q) y el valor del campo(E) para calcular el area <br> Para el desarrollo del ejercicio hay que tener en cuenta lo siguiente: <br> <center> A = Q/E(E0) </center><br>se tiene en cuenta que (E0= 8,85x10^-12) "; 
        panel1.Input1="ingresa el valor de la carga (Q)";
        panel1.Input2="Ingresa el valor del campo (E)= N/C";
        

        panel1.Formula = ()->{
            Integer carga = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer campo = Integer.valueOf(panel1.$_Intput2_Retorno);
            Double pers= 8.85;

            Integer res= msg_Option("¿El dato ingresado en la carga es en microCoulom o nanoCoulom?", new String[]{"MicroCoulom","NanoCoulom"});

            if (res==1){
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
                double respuesta= Methods.RoundNum(resultado, 5);
                String res1 = "El resultado es " + (respuesta+" m²");
                
                panel1.$_Retorno_Formula= res1;
            }else{
                 // POTENCIA DE LA CARGA
                 double elevado= Math.pow(10, -6);
                 // CARGA* SU POTENCIA
                 double numpt= carga*elevado;
 
                 // POTENCIA DE LA PERMISIVIDAD
                 double elevado2= Math.pow(10, -12);
                 // PERMISIVIDAD * SU POTENCIA
                 double permsfin= pers*elevado2;
                 
                //  OPERACION
                 double arriba= numpt;
                 double abajo = campo*permsfin;
                 double resultado= arriba/abajo;

                 double respuesta= Methods.RoundNum(resultado, 5);
                 String res1 = "El resultado es " + (respuesta+" m²");
                 panel1.$_Retorno_Formula= res1;
            }
        };


        
        panel1.resultado=0.0;
        

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();
    }
    static void loop(){

        Double carga= Methods.Random_Num(1.0, 20.0);
        Double campo= Methods.Random_Num(200.0, 3000.0);
        Integer camporedon= (int) Methods.RoundNum(campo, 1);
        Integer cargaredon= (int) Methods.RoundNum(carga, 1);
        panel1.Cuestionario="<center> EJERCICIO DE PRACTICA</center><br> Entre las placas de un condensador hay una carga de: "+cargaredon+" nC. ¿cual será el area de la carga si hay un campo de: "+camporedon+"N/C?<br> NOTA: A= Q/E(E0)<br> E0= 8,85x10^-12";

        // CARGA
        double elevation= Math.pow(10, -9);
        double numerador= cargaredon*elevation;
        
        // PERMISIVIDAD
        double elevationper= Math.pow(10, -12);
        double permisiv= 8.85;
        double permisivtol= permisiv*elevationper;
        double denominador= camporedon*permisivtol;

        // TEST

        double result= numerador/denominador;
        double resp= Methods.RoundNum(result, 3);

        panel1.$_RedondeoButtons=6;
        panel1.resultado=resp;
        panel1.$$_Return_Msg_Correct="Correcto!\n"+"El valor del area: "+resp+" m²";
        panel1.$$_Return_Msg_Error="RESPUESTA INCORRECTA!.\n LA RESPUESTA ES: "+resp+" m²";
        panel1.$_Relevar_Respuestas=true;
        panel1.$_JopcionMessage_Incorrect=true;
        // panel1.resultado= Random_Num(10.0, 20.0);
        panel1.$$_Numer_Button_Option=3;





        panel1.ReloadCuestions();
    }
    
}
