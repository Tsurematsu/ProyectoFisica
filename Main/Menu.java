package Main;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import AppData.Methods;

public class Menu extends Methods{
    public static Runnable Open = Methods.Set_Panel(new Menu(), ()->Main(),()->loop());
    
    static void Main(){
        this_Window.setSize(500,500);


        JTextField input1 = AddTextField("titulo");
        this_Panel.add(input1);


        ArrayList<JComponent> botones = new ArrayList<>();
        botones.add(AddButton("null", ()->{System.out.println("hola");  }));
        botones.add(AddButton("null", ()->{System.out.println("hola");  }));
        botones.add(AddButton("null", ()->{System.out.println("hola");  }));
        botones.add(AddButton("null", ()->{System.out.println("hola");  }));

        for (JComponent jComponent : botones) {
            this_Panel.add(jComponent);
        }

        Linear.X(botones, 10, 0, 100, this_Window.getSize().width);


        this_Panel.repaint();
    }
    static void loop(){

    }
    
}
