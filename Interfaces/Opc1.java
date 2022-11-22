package Interfaces;
import javax.swing.JPanel;

import AppData.Methods;
import AppData.Plantilla;

public class Opc1 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc1(), ()->Main(),()->loop());
    static Plantilla panel1;
    static void Main(){
        this_Window.setSize(500,500);
        
        panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="HALLAR LA CARGA DE UN CONDENSADOR"; 
        panel1.Descripcion="Para la resolución del ejercicio hay que tener en cuenta la siguiente formula: <br> <center> Q=CV </center>";
        panel1.Input1="Ingrese el valor de capacitor (C)";
        panel1.Input2="Ingrese el valor de la diferencia potencial (V)";

        panel1.Formula = ()->{
            Integer cap = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer poten = Integer.valueOf(panel1.$_Intput2_Retorno);
            
        
            Integer res= msg_Option("¿El dato ingresado en el capacitor es en microFaradios o nanoFaradios?", new String[]{"Nanofaradios","Microfaradios"});
            
            System.out.println(res);

            if(res==0){
            double elevado= Math.pow(10, -9);
            double numpt;
            numpt=cap*elevado;

            double result= numpt*poten;
            String res1 = "El resultado es " + (result+" C");
            panel1.$_Retorno_Formula= res1;

            }else{
                double elevado= Math.pow(10 , -6);
            double numpt;
            numpt=cap*elevado;

            double result= numpt*poten;
            String res1 = "El resultado es " + (result+" C");
            panel1.$_Retorno_Formula= res1;
            }
                            
            
        };


        panel1.Cuestionario="";
        panel1.resultado=0;
        panel1.$$_Numer_Button_Option=3;

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();

    }
    static void loop(){
        panel1.ReloadCuestions();
    }
}
