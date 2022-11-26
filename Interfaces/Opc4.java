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
            
            Integer res= msg_Option("¿El dato ingresado en la carga es en MicroCoulom o NanooCoulom?", new String[]{"MicroCoulom","NanooCoulom"});
        
            if(res==0){
            double elevado= Math.pow(10, -9);
            double numpt;
            numpt=val1*elevado;

            double result= numpt*val2;
            String res1 = "El resultado es " + (result+" C");
            panel1.$_Retorno_Formula= res1;
            }else{
            double elevado= Math.pow(10 , -6);
            double numpt;
            numpt=val1*elevado;

            Integer calculo;
            calculo = val1/val2;


            String res1 = "El resultado es " + (calculo);
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
            double numpt;
            numpt=Carga*elevado;
        panel1.Cuestionario="Por favor, realizar el sigueiente cuestionario para evidenciar los saberes obtenidos. " +
        "Recuerde que la formula es C = Q / V <br> La Carga es igual a : "+ Carga  + " mC<br>El Voljate es igual a : \n" + Voltaje +"\nNOTA: mC es igual a eleveado a la -6";
        double res = numpt/Voltaje;
        panel1.$$_Return_Msg_Correct="¡RESPUESTA CORRECTA!\n"+ res + " F";
        panel1.resultado=numpt/Voltaje;
        panel1.ReloadCuestions();
    }
    
}
