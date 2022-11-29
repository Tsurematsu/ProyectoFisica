package Inicio;

import java.awt.Color;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AppData.Methods;
import Interfaces.Opc1;
import Interfaces.Opc2;
import Interfaces.Opc3;
import Interfaces.Opc4;

public class Menu extends Methods{
    public static Runnable Open = Methods.Set_Panel(new Menu(), ()->Main(),()->loop());
    
    static void Main(){
        this_Window.setSize(400,300);


        JLabel input1 = AddLabel("<html>Seleccione alguna de las siguentes opciones a calcular</html");
        input1.setSize(this_Window.getSize().width, 30);
        setFont(input1, 15);
        input1.setLocation(0,20);
        this_Panel.add(input1);


        ArrayList<JComponent> botones = new ArrayList<>();
        botones.add(AddButton("Calcular Carga", ()->{ Opc1.Open.run();}));
        botones.add(AddButton("Hallar Area de la Carga", ()->{Opc2.Open.run();}));
        botones.add(AddButton("Hallar el campo", ()->{Opc3.Open.run();}));
        botones.add(AddButton("Hallar la capacitancia", ()->{ Opc4.Open.run();}));

        for (JComponent jComponent : botones) {
            this_Panel.add(jComponent);
            jComponent.setSize(200, 30);
            jComponent.setBackground(new Color(239, 194, 231 ));
        }

        Linear.Y(botones, 10, Mitad(botones.get(0)), 80);


        this_Panel.repaint();
    }
    static void loop(){

    }
    
}
