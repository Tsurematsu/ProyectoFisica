package Interfaces;


import AppData.Methods;
import AppData.Plantilla;
import javax.swing.JPanel;

import AppData.Methods;

public class Opc3 extends Methods {
    
    public static Runnable Open = Methods.Set_Panel(new Opc3(), ()->Main(),()->loop());
    static Plantilla panel1;
    static void Main(){
        this_Window.setSize(500,500);
        
        panel1 = new Plantilla();
        panel1.setSize(this_Window.getSize().width, this_Window.getSize().height);
        
        panel1.Titulo="HALLAR EL CAMPO ELECTRICO"; 
        panel1.Descripcion="Introduzca su carga electrica y distancia.<br> Tenga en cuenta para la resolución del ejercicio que: Campo eléctrico = Diferencia de potencial eléctrico/Longitud del conductor <br> <center> Entonces la formula para el campoo electrico será:<br> E = ΔV/D </center>";
        panel1.Input1="Ingrese el valor de potencial eléctrico (ΔV)";
        panel1.Input2="Ingrese el valor de la longitud del conductor (D)";

        panel1.Formula = ()->{
            Integer cap = Integer.valueOf(panel1.$_Intput1_Retorno);
            Integer dist = Integer.valueOf(panel1.$_Intput2_Retorno);
            Integer valc= msg_Option("¿Que tipo de datos ingresó (ΔV)/(D)?", new String[]{"Voltios/Metro","Voltios/Centimetro","Voltios/Millas","Nanovoltios/Metro","Nanovoltios/Centimetro","Nanovoltios/Millas","Microvoltios/Metro","Microvoltios/Centimetro","Microvoltios/Millas"});
            
            double valordistancia=0;

            switch(valc){
                
                case 0:
                double formula0 = cap / dist;
                double resultado;
                resultado = formula0;
                String res = "El resultado es " + formula0 + " Voltios por metro";
                panel1.$_Retorno_Formula= res;
                
                case 1:
                double microvoltios = cap * Math.pow(10, -6);
                double formula1 = microvoltios / valordistancia;
                resultado = formula1;
                String res1 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res1;
                                
                case 2:
                double nanovoltios = cap * Math.pow(10, -9);
                double formula2 = nanovoltios / valordistancia;
                resultado = formula2;
                String res2 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res2;
                                
                case 3:
                double milivoltios = cap * Math.pow(10, -3);
                double formula3 = milivoltios / valordistancia;
                resultado = formula3;
                String res3 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res3;
                                
                case 4:
                double kilvoltios = cap * 1000;
                double formula4 = kilvoltios / valordistancia;
                resultado = formula4;
                String res4 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res4;
                                
                case 5:
                double megavoltios = cap * 1000000;
                double formula5 = megavoltios / valordistancia;
                resultado = formula5;
                String res5 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res5;
                                
                case 6:
                double gigavoltios = cap * 1000000000;
                double formula6 = gigavoltios / valordistancia;
                resultado = formula6;
                String res6 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res6;

                
                
            }

            
            
        };

        this_Panel.add(panel1);
        this_Panel.repaint();
        panel1.Aply();

    }
    static void loop(){
        double condensador= Methods.Random_Num(1.0, 10.0);
        double difpotencial= Methods.Random_Num(200.0, 800.0);
        panel1.Cuestionario="<center>EJERCICIO DE PRACTICA</center><br>Entre las placas de un condensador de "+Methods.RoundNum(condensador, 2)+" uf hay una diferencia de potencial de "+Methods.RoundNum(difpotencial, 2)+" voltios<br>¿Cual será la carga en cada placa?<br> NOTA: uf=*10^-6";
        double elevation= Math.pow(10, -6);
        double resp=condensador*elevation;
        double resp2= resp*difpotencial;
        double result= Methods.RoundNum(resp2, 6);
        
        panel1.$_RedondeoButtons=6;
        panel1.resultado=result;
        panel1.$$_Return_Msg_Correct="Correcto!\n"+"El valor de la carga: "+result+" C";
        panel1.$$_Return_Msg_Error="RESPUESTA INCORRECTA!.\n LA RESPUESTA ES: "+result+" C";
        panel1.$_Relevar_Respuestas=true;
        panel1.$_JopcionMessage_Incorrect=true;
        // panel1.resultado= Random_Num(10.0, 20.0);
        panel1.$$_Numer_Button_Option=3;


        panel1.ReloadCuestions();
    }
    }