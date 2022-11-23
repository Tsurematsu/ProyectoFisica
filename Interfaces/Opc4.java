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
        panel1.Descripcion="Para poder hallar la CAPACITANCIA, utilizaremos la sigiente formula C = Q / V. Por favor ingrese los siguientes datos:";
        panel1.Input1="Ingrese el valor de la carga";
        panel1.Input2="Ingrese el valor del voltaje";

        panel1.Formula = ()->{
            Integer val1 = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer val2 = Integer.valueOf(panel1.$_Intput2_Retorno);

            Integer calculo;
            calculo = val1/val2;


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
