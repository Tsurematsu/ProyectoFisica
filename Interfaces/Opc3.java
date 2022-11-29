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
            Integer valc= msg_Option("¿Que tipo de datos ingresó (ΔV)/(D)?", new String[]{"Voltios/Metro","Voltios/Centimetro","Voltios/Millas","Voltios/milimetros","Voltios/kilometros","Voltios/pulgada","Voltios/decimetro",
            "Nanovoltios/Metro","Nanovoltios/Centimetro","Nanovoltios/Millas","Nanovoltios/milimetros","Nanovoltios/kilometro","Nanovoltios/pulgada",
            "Microvoltios/Metro","Microvoltios/Centimetro","Microvoltios/Millas","Microvoltios/milimetros","Microvoltios/kilometro","Microvoltios/pulgada","Microvoltios/decimetro",
            "Kilvoltios/Metros","Kilvoltios/Centimetros","Kilvoltios/Millas","Kilvoltios/decimetro","Kilvoltios/milimetros","Kilvoltios/kilometro","Kilvoltios/pulgada",
            "Megavoltios/Metros","Megavoltios/Centimetros","Megavoltios/Millas", "Megavoltios/decimetro","Megavoltios/milimetros","Megavoltios/kilometro","Megavoltios/pulgada",
            "Gigavoltios/Metros","Gigavoltios/Centimetros","Gigavoltios/Millas","Gigavoltios/decimetro","Gigavoltios/milimetros","Gigavoltios/kilometro", "Gigavoltios/pulgada"});
            
            double valordistancia= 0;
            double resultado;
            double centimetro=0.01;
            double millas=1609.34;
            double milimetro =0.001;
            double kilometro=1000;
            double pulgada= 0.0254;
            double decimetro=0.1;
            double nanovoltios=Math.pow(10, -9);
            double microvoltios=Math.pow(10, -6);
            double milivoltios=Math.pow(10, -3);
            double kilvoltios=1000;
            double megavoltios=1000000;
            double gigavoltios=1000000000;


             switch(valc){

                //"Voltios/Metro"

                 case 0:
                 double formula0 = cap / dist;
                 String result = "El resultado es " + formula0 + " Voltios por metro";
                 panel1.$_Retorno_Formula= result;
                 break;
                
                //  "Voltios/Centimetro"
                 case 1:
                 valordistancia = dist * centimetro;
                 double formula1 = cap / valordistancia;
                 String result1 = "El resultado es " + formula1 + " Voltios por metro";
                  panel1.$_Retorno_Formula= result1;
                  break;

                //   "Voltios/Millas"                
                 case 2:
                 valordistancia = dist * millas;
                 double formula2 = cap / valordistancia;
                 String result2 = "El resultado es " + formula2 + " Voltios por metro";
                  panel1.$_Retorno_Formula= result2;
                  break;

                //   "Voltios/milimetros"
                case 3:
                valordistancia = dist * milimetro;
                 double formula3 = cap / valordistancia;
                 String result3 = "El resultado es " + formula3 + " Voltios por metro";
                  panel1.$_Retorno_Formula= result3;
                  break;

                //   "Voltios/kilometros"
                case 4:
                valordistancia = dist * kilometro;
                 double formula4 = cap / valordistancia;
                 String result4 = "El resultado es " + formula4 + " Voltios por metro";
                  panel1.$_Retorno_Formula= result4;
                  break;

                //   "Voltios/pulgada"
                case 5:
                valordistancia = dist * pulgada;
                 double formula5 = cap / valordistancia;
                 String result5 = "El resultado es " + formula5 + " Voltios por metro";
                  panel1.$_Retorno_Formula= result5;
                  break;

                //   "Voltios/decimetro"
                case 6:
                valordistancia = dist * decimetro;
                 double formula6 = cap / valordistancia;
                 String result6 = "El resultado es " + formula6 + " Voltios por metro";
                  panel1.$_Retorno_Formula= result6;
                  break;
                  
                                                  // "Nanovoltios/Metro"                
                                                case 7:
                                                double formula7 = (cap * nanovoltios) / dist;
                                                resultado = formula7;
                                                String res7 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res7;
                                                break;
                                                            
                                                //  "Nanovoltios/Centimetro"
                                                case 8:
                                                double formula8 = (cap * nanovoltios) / (dist*centimetro);
                                                resultado = formula8;
                                                String res8 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res8;
                                                break;
                                                            
                                                //  "Nanovoltios/Millas"
                                                case 9:
                                                double formula9 = (cap * nanovoltios) / (dist*millas);
                                                resultado = formula9;
                                                String res9 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res9;
                                                break;

                                                //   "Nanovoltios/milimetros" 
                                                case 10:
                                                double formula10 = (cap * nanovoltios) / (dist*milimetro);
                                                resultado = formula10;
                                                String res6 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res6;

                                                //   "Nanovoltios/kilometro" 
                                                case 11:
                                                double formula11 = (cap * nanovoltios) / (dist*kilometro);
                                                resultado = formula11;
                                                String res11 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res11;
                                                
                                                //   "Nanovoltios/pulgada"
                                                case 12:
                                                double formula12 = (cap * nanovoltios) / (dist*pulgada);
                                                resultado = formula12;
                                                String res12 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res12;

                //  "Microvoltios/Metro"
                 case 13:
                 double formula13 = (cap * microvoltios) / dist;
                 resultado = formula13;
                 String res13 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res13;
                 break;

                //  "Microvoltios/Centimetros"
                 case 14:
                 double formula14 = (cap * microvoltios) / (dist*centimetro);
                 resultado = formula14;
                 String res14= "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res14;
                 break;

                //  "Microvoltios/Millas"
                 case 15:

                 double formula15 = (cap * microvoltios) / (dist*millas);
                 resultado = formula15;
                 String res15 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res15;
                 break;

                 //   "Microvoltios/milimetros" 
                 case 16:
                 double formula16 = (cap * microvoltios) / (dist*milimetro);
                 resultado = formula16;
                 String res16 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res16;
                 break;
                 //   "Microvoltios/kilometro"
                 case 17:
                 double formula17 = (cap * microvoltios) / (dist*kilometro);
                 resultado = formula17;
                 String res17 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res17;
                 break;
                 //   "Microvoltios/pulgada"
                 case 18:
                 double formula18 = (cap * microvoltios) / (dist*pulgada);
                 resultado = formula18;
                 String res18 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res18;
                 break;
                 //   "Microvoltios/decimetro"
                 case 19:
                 double formula19 = (cap * microvoltios) / (dist*decimetro);
                 resultado = formula19;
                 String res19 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res19;
                 break;


                                                //   "Kilvoltios/Metros" 
                                                case 20:
                                                double formula20 = (cap * kilvoltios) / dist;
                                                resultado = formula20;
                                                String res20 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res20;
                                                break;
                                                //   "Kilvoltios/Centimetros" 
                                                case 21:
                                                double formula21 = (cap * kilvoltios) / (dist*centimetro);
                                                resultado = formula21;
                                                String res21 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res21;
                                                break;
                                                //   "Kilvoltios/Millas"
                                                case 22:
                                                double formula22 = (cap * kilvoltios) / (dist*millas);
                                                resultado = formula22;
                                                String res22 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res22;
                                                break;
                                                //   "Kilvoltios/decimetro"
                                                case 23:
                                                double formula23 = (cap * kilvoltios) / (dist*decimetro);
                                                resultado = formula23;
                                                String res23 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res23;
                                                break;
                                                //   "Kilvoltios/milimetros" 
                                                case 24:
                                                double formula24 = (cap * kilvoltios) / (dist*milimetro);
                                                resultado = formula24;
                                                String res24 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res24;
                                                break;
                                                //   "Kilvoltios/kilometro"
                                                case 25:
                                                double formula25 = (cap * kilvoltios) / (dist*kilometro);
                                                resultado = formula25;
                                                String res25 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res25;
                                                break;
                                                //   "Kilvoltios/pulgada"
                                                case 26:
                                                double formula26 = (cap * kilvoltios) / (dist*pulgada);
                                                resultado = formula26;
                                                String res26 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res26;
                                                break;


                 //   "Megavoltios/Metros" 
                 case 27:
                double formula27 = (cap * kilvoltios) / dist;
                resultado = formula27;
                String res27 = "El resultado es " + (resultado+" Voltios por metro");
                panel1.$_Retorno_Formula= res27;
                break;
                 //   "Megavoltios/Centimetros" 
                 case 28:
                 double formula28 = (cap * kilvoltios) / (dist*centimetro);
                 resultado = formula28;
                 String res28 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res28;
                 break;
                 //   "Megavoltios/Millas"
                 case 29:
                 double formula29 = (cap * kilvoltios) / (dist*millas);
                 resultado = formula29;
                 String res29 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res29;
                 break;
                 //   "Megavoltios/decimetro"
                 case 30:
                 double formula30 = (cap * kilvoltios) / (dist*decimetro);
                 resultado = formula30;
                 String res30 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res30;
                 break;
                 //   "Megavoltios/milimetros" 
                 case 31:
                 double formula31 = (cap * kilvoltios) / (dist*milimetro);
                 resultado = formula31;
                 String res31 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res31;
                 break;
                 //   "Megavoltios/kilometro" 
                 case 32:
                 double formula32 = (cap * kilvoltios) / (dist*kilometro);
                 resultado = formula32;
                 String res32 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res32;
                 break;
                 //   "Megavoltios/pulgada"
                 case 33:
                 double formula33 = (cap * kilvoltios) / (dist*pulgada);
                 resultado = formula33;
                 String res33 = "El resultado es " + (resultado+" Voltios por metro");
                 panel1.$_Retorno_Formula= res33;
                 break;


                                                //   "Gigavoltios/Metros" 
                                                case 34:
                                                double formula34 = (cap * gigavoltios) / dist;
                                                resultado = formula34;
                                                String res34 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res34;
                                                break;

                                                //   "Gigavoltios/Centimetros" 
                                                case 35:
                                                double formula35 = (cap * gigavoltios) / (dist*centimetro);
                                                resultado = formula35;
                                                String res35 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res35;
                                                break;

                                                //   "Gigavoltios/Millas"
                                                case 36:
                                                double formula36 = (cap * gigavoltios) / (dist*millas);
                                                resultado = formula36;
                                                String res36 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res36;
                                                break;

                                                //   "Gigavoltios/decimetro"
                                                case 37:
                                                double formula37 = (cap * gigavoltios) / (dist*decimetro);
                                                resultado = formula37;
                                                String res37 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res37;
                                                break;

                                                //   "Gigavoltios/milimetros" 
                                                case 38:
                                                double formula38 = (cap * gigavoltios) / (dist*milimetro);
                                                resultado = formula38;
                                                String res38 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res38;
                                                break;

                                                //   "Gigavoltios/kilometro" 
                                                case 39:
                                                double formula39 = (cap * gigavoltios) / (dist*kilometro);
                                                resultado = formula39;
                                                String res39 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res39;
                                                break;

                                                //   "Gigavoltios/pulgada"
                                                case 40:
                                                double formula40 = (cap * gigavoltios) / (dist*pulgada);
                                                resultado = formula40;
                                                String res40 = "El resultado es " + (resultado+" Voltios por metro");
                                                panel1.$_Retorno_Formula= res40;
                                                break;
                
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