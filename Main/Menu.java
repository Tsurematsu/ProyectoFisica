package Main;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import AppData.Methods;
import Interfaces.Opc1;
import Interfaces.Opc2;
import Interfaces.Opc3;
import Interfaces.Opc4;

public class Menu extends Methods{
    public static Runnable Open = Methods.Set_Panel(new Menu(), ()->Main(),()->loop());
    
    static void Main(){
        this_Window.setSize(500,500);


        JTextField input1 = AddTextField("BIENVENIDO");
        this_Panel.add(input1);


        ArrayList<JComponent> botones = new ArrayList<>();
        botones.add(AddButton("Calcular Carga", ()->{ Opc1.Open.run();}));
        botones.add(AddButton("Hallar Area de la Carga", ()->{Opc2.Open.run();}));
        botones.add(AddButton("Hallar el campo", ()->{Opc3.Open.run();}));
        botones.add(AddButton("Hallar la capacitancia", ()->{ Opc4.Open.run();}));

        for (JComponent jComponent : botones) {
            this_Panel.add(jComponent);
            jComponent.setSize(200, 30);
        }

        Linear.Y(botones, 10, 150, 100);


        this_Panel.repaint();
    }
    static void loop(){

    }
    
}
