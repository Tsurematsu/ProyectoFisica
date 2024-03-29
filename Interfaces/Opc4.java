package Interfaces;

import AppData.Methods;
import AppData.Plantilla;

public class Opc4 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc4(), ()->Main(),()->loop());
    static Plantilla panel1;
    static void Main(){
        panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="HALLAR LA CAPACITANCIA";
        panel1.Descripcion="Para poder hallar la CAPACITANCIA, utilizaremos la sigiente formula C = Q / V. <br>Por favor ingrese los siguientes datos:";
        panel1.Input1="Ingrese el valor de la carga";
        panel1.Input2="Ingrese el valor del voltaje";

        panel1.Formula = ()->{
            Integer val1 = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer val2 = Integer.valueOf(panel1.$_Intput2_Retorno);
            
            Integer res= msg_Option("¿El dato ingresado en la carga es en microCoulom o nanoCoulom?", new String[]{"MicroCoulom","NanoCoulom"});
        
            if(res==0){
            double elevado= Math.pow(10, -9);
            double numpt;
            numpt=val1*elevado;

            double result= numpt*val2;
            String res1 = "El resultado es " + (result+" F");
            panel1.$_Retorno_Formula= res1;
            }else{
            double elevado= Math.pow(10 , -6);
            double numpt;
            numpt=val1*elevado;

            Double calculo;
            calculo = numpt/val2;


            String res1 = "El valor de la capacitancia es: " + (calculo+" F");
            panel1.$_Retorno_Formula= res1;
            }
        };

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();
    }
    static void loop(){
        double Carga = Methods.Random_Num(10.0, 100.0);
        double Voltaje = Methods.Random_Num(50.0, 200.0);
        double elevado= Math.pow(10, -6);
        double numpt = Carga *elevado;
        panel1.Cuestionario="Por favor, realizar el sigueiente cuestionario para evidenciar los saberes obtenidos. " +
        "Recuerde que la formula es C = Q / V <br> La Carga es igual a : "+ Methods.RoundNum(Carga, 3)  + " mC<br>El Voljate es igual a : \n" + Methods.RoundNum(Voltaje, 3) +"<br>NOTA: mC= *10^-6";
        double res = numpt/Voltaje;

        panel1.$_RedondeoButtons=4;
        panel1.$$_Return_Msg_Correct="¡RESPUESTA CORRECTA!\n"+ res + " F";
        panel1.resultado=numpt/Voltaje;
        panel1.$$_Return_Msg_Error="¡RESPUESTA INCORRECTA!.\n LA RESPUESTA ES: " + res + " F";
        panel1.$$_Numer_Button_Option=3;
        panel1.$_Relevar_Respuestas = true;
        panel1.$_JopcionMessage_Incorrect =true;

        panel1.ReloadCuestions();
    }
    
}
