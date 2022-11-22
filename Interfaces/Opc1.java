package Interfaces;
import javax.swing.JPanel;

import AppData.Methods;
import AppData.Plantilla;

public class Opc1 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc1(), ()->Main(),()->loop());
    static Plantilla panel1;
    static void Main(){
        panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="Calculo de no se que";
        panel1.Descripcion="Descripcion <br> Separacion <br> dos";
        panel1.Input1="Ingresar";
        panel1.Input2="Ingresar ";

        panel1.Formula = ()->{
            Integer val1 = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer val2 = Integer.valueOf(panel1.$_Intput2_Retorno);

            double U=10;
            double elevado= Math.pow(U, -6);



            Integer calculo;
            calculo = val1*val2;


            String res1 = "El resultado es " + (calculo);
            panel1.$_Retorno_Formula= res1;
        };


        // panel1.Cuestionario="";
        panel1.resultado=0;

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();

    }
    static void loop(){
        panel1.ReloadCuestions();
    }
}
