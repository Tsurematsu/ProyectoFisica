package Inicio;

import java.awt.Color;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AppData.Methods;

public class Integrantes extends Methods{

    public static Runnable Open = Methods.Set_Panel(new Integrantes(), ()->Main(),()->loop());
    static void Main(){
        this_Window.setSize(370,270);
        JLabel input1 = AddLabel("<html><center> " +
        "José Daniel Solano García<br>" +
        "Jorge Yecid Borrero Carrascal<br>" +
        "Roys Rafael Simarra Gomez<br>" +
        "Aldair Gutierrez Guerrero<br>" +
        "Martin Medrano<br>" +
        " </center></html>");
        input1.setSize(this_Window.getSize().width, 150);
        setFont(input1, 20);
        input1.setLocation(0,10);
        this_Panel.add(input1);

        ArrayList<JComponent> botones = new ArrayList<>();
        botones.add(AddButton("Menu", ()->{Menu.Open.run();}));

        for (JComponent jComponent : botones) {
            this_Panel.add(jComponent);
            jComponent.setSize(200, 30);
            jComponent.setBackground(new Color(239, 194, 231 ));
        }

        Linear.Y(botones, 10, Mitad(botones.get(0)), 170);


        this_Panel.repaint();
}
static void loop(){
}

}