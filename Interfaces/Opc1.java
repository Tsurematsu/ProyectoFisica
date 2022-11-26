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
        panel1.Descripcion="Introduzca los de datos de capacitancia y voltaje para calcular la carga de un condensador <br>Para la resolución del ejercicio hay que tener en cuenta la siguiente formula: <br> <center> Q=CV </center>";
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

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();

    }
    static void loop(){
        double condensador= Methods.Random_Num(1.0, 10.0);
        double difpotencial= Methods.Random_Num(200.0, 800.0);
        panel1.Cuestionario="<center>EJERCICIO DE PRACTICA</center><br>Entre las placas de un condensador de "+condensador+" uf hay una diferencia de potencial de "+difpotencial+" voltios<br>¿Cual será la carga en cada placa?<br> NOTA: uf=*10N^-6";
        double elevation= Math.pow(10, -6);
        double resp=condensador*elevation;
        double resp2= resp*difpotencial;
        panel1.resultado=resp2;
        panel1.$$_Return_Msg_Correct="Correcto!\n"+"El valor de la carga: "+resp2+" C";
        panel1.$$_Return_Msg_Error="Respuesta incorrecta :(";
        // panel1.resultado= Random_Num(10.0, 20.0);
        panel1.$$_Numer_Button_Option=3;


        panel1.ReloadCuestions();
    }
    }