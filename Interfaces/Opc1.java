package Interfaces;
import javax.swing.JPanel;

import AppData.Methods;
import AppData.Plantilla;

public class Opc1 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc1(), ()->Main(),()->loop());
    
    static void Main(){
        Plantilla panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="Calculo del area de un condensador";
        panel1.Descripcion="Para la solución del ejercicio hay que tener en cuenta la siguiente formula <br><center> Q=C.V</center>";
        panel1.Input0="Ingrese el valor de capacitor (C):";
        panel1.Input1="Ingrese el valor de la diferencia potencial (V):";

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


        panel1.botones = new String[][]{
            {"Opcion1", "mensage", "mensage"}, 
            {"Opcion2", "mensage", "mensage"},
            {"Opcion3", "mensage", "mensage"},
        };
        panel1.resultado=0;

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();

    }
    static void loop(){

    }
}
