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

public class Bienvenida extends Methods{

    public static Runnable Open = Methods.Set_Panel(new Bienvenida(), ()->Main(),()->loop());
    static void Main(){
        this_Window.setSize(600,320);
        JLabel input1 = AddLabel("<html><center>BIENVENIDO A LA GUIA DE CAPACITANCIA<br>AQUI LOGRARAS DESARROLLAR CONOCIMIENTOS SOBRE CALCULAR CARGA, AREA, CAPACITANCIA <br> Y CAMPO ENTRE CONDENSADORES.</center></html>");
        input1.setSize(this_Window.getSize().width, 90);
        setFont(input1, 20);
        input1.setLocation(0,70);
        this_Panel.add(input1);

        ArrayList<JComponent> botones = new ArrayList<>();
        botones.add(AddButton("Siguiente", ()->{Menu.Open.run();}));

        for (JComponent jComponent : botones) {
            this_Panel.add(jComponent);
            jComponent.setSize(200, 30);
            jComponent.setBackground(new Color(239, 194, 231 ));
        }

        Linear.Y(botones, 10, Mitad(botones.get(0)), 200);


        this_Panel.repaint();
}
static void loop(){
}

}