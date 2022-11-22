package Interfaces;

import AppData.Methods;
import AppData.Plantilla;

public class Opc2 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc2(), ()->Main(),()->loop());
    static Plantilla panel1;
    static void Main(){
        panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="Encuentre el Area de la Carga electrica";
        panel1.Descripcion="Para el Desarrolo del ejercicio hay que tener en cuenta la siguiente formula: <br> <center> A = Q/E(E0) </center> <br> tener en cuenta la siguente formula 8,85x10^-12"; 
        panel1.Input1="ingresa el valor de la carga";
        panel1.Input1="";
        

        panel1.Formula = ()->{
            Integer val1 = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer val2 = Integer.valueOf(panel1.$_Intput2_Retorno);

            Integer calculo;
            calculo = val1*val2;

            // test
            String res1 = "El resultado es " + (calculo);
            panel1.$_Retorno_Formula= res1;
        };


        panel1.Cuestionario="";
        panel1.resultado=0;
        

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();
    }
    static void loop(){
        panel1.ReloadCuestions();
    }
    
}
