package AppData;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

import Main.Menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plantilla extends JPanel{

    public Runnable Formula=()->{};
    public String $_Retorno_Formula="";
    public String $_Intput1_Retorno="";
    public String $_Intput2_Retorno="";

    public String Titulo="Este es un titulo"; 
    public String Cuestionario="Descripción del cuestionario";
    public String Descripcion="Descripción del problema"; 
    public String Input1=""; 
    public String Input2="";
    public Integer resultado=-1;
    public Runnable AlFinalizar = ()->{};

    
    SubPanel1 Sub1; 
    SubPanel2 Sub2; 

    Boolean panelSelect = true;
    public String Input0;

    public Plantilla() {this.repaint();}

    public void ReloadCuestions(){
        Sub2.AddSelectButtons();
    }

    public void Aply(){
        
        this.setLayout(null);

        JButton Home = Methods.AddButton("Home", ()->{panelSelect=true; Restard(); Menu.Open.run();});
        Home.setFocusable(true);
        Home.requestFocus();
        this.add(Home);

        Sub1 = new SubPanel1();
        this.add(Sub1);
        Sub1.setBounds(this.getBounds());
        Sub1.setLayout(null);
        Sub1.Aply();


        Sub2 = new SubPanel2();
        this.add(Sub2);
        Sub2.setBounds(this.getBounds());
        Sub2.setLayout(null);
        Sub2.Aply();

        Restard();

        
    }

    void Restard(){
        Sub1.setVisible(panelSelect);
        Sub2.setVisible(!panelSelect);
    }


    public class SubPanel1 extends JPanel{
        ArrayList<JComponent> Elementos = new ArrayList<>();
        
        
        public SubPanel1() {}

    
        public void Aply(){
            this.setLocation(0,0);
    
            this.setLayout(null);
            // Bloque 1 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            Elementos.add(Methods.AddLabel("<html>" + Titulo + "</html>"));
            
            Elementos.add(Methods.AddLabel("<html>" + Descripcion + "</html>"));

            Elementos.add(Methods.AddTextNumer(String.valueOf(Input1)));   
            Elementos.add(Methods.AddTextNumer(String.valueOf(Input2)));

            Elementos.add(Methods.AddButton("Calcular", ()->{
                $_Intput1_Retorno=((JTextField)Elementos.get(2)).getText(); 
                $_Intput2_Retorno=((JTextField)Elementos.get(3)).getText();; 
                Formula.run(); 
                ((JLabel) Elementos.get(5)).setText("<html>" + $_Retorno_Formula + "</html>");}));
            Elementos.add(Methods.AddLabel("Resultado"));

            Elementos.add(Methods.AddButton("Siguiente", ()->{
                panelSelect=false;
                Restard();
                // Sub2.Aply();
            }));

            
            for (JComponent jComponent : Elementos) {
                this.add(jComponent);
                jComponent.setSize(400, 30);
                jComponent.setBackground(Color.white);
                try {Methods.setFont((JLabel)jComponent, 15);} catch (Exception e) {}
                try {Methods.setFont((JTextField)jComponent, 20);} catch (Exception e) {}
            }

            Methods.setFont((JLabel) Elementos.get(0), 20);
            ((JLabel) Elementos.get(1)).setSize(((JLabel) Elementos.get(1)).getSize().width, 90);

            Methods.Linear.Y(Elementos, 10, this.getSize().width / 2 - Elementos.get(0).getSize().width / 2, 100);        
            // Bloque 1 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    
            
            this.repaint();
        }


    }
    

    
    public class SubPanel2 extends JPanel{
        ArrayList<JComponent> Elementos = new ArrayList<>();
        ArrayList<JComponent> Botones = new ArrayList<>();
        
        Integer botonSelInteger =-1;
        
        public SubPanel2() {
        }
        
        public void AddSelectButtons(){
            for (Component jComponent : this.getComponents()) {
                try {
                    for (JComponent jComponent1 : Botones) {
                        if (jComponent.equals(jComponent1)) {
                            this.remove(jComponent);
                        }
                    }
                } catch (Exception e) {}
            }
            try {
                for (JComponent jComponent : Botones) {
                    this.remove(jComponent);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            Botones.clear();

            Integer numero=3;
            ArrayList<Integer> botones = new ArrayList<>();
            for (int i = 0; i < numero; i++) {botones.add((int) (Math.random() * 100));}
            botones.add(resultado);
            ArrayList<Integer> numAl = aleatorio(numero + 1);
            // Bloque 2 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            for (int i = 0; i < botones.size(); i++) {
                JButton botonStandar = new JButton();
                botonStandar.setName(String.valueOf(i));
                botonStandar.setText(String.valueOf(botones.get(numAl.get(i))));
                botonStandar.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        selective(Integer.valueOf(botonStandar.getName()));
                    }
                    
                });
                Botones.add(botonStandar);
            }

            for (JComponent jComponent : Botones) {
                this.add(jComponent);
                jComponent.setBackground(Color.WHITE);
                jComponent.setSize(120, 30);
            }

            Methods.Linear.X(Botones, 10, 0, Elementos.get(Elementos.size()-1).getLocation().y + Elementos.get(Elementos.size()-1).getSize().height + 20, this.getSize().width);
        }

        public void Aply(){
            Elementos.add(Methods.AddLabel("<html>" + Titulo + "</html>"));            
            Elementos.add(Methods.AddLabel("<html>" + Cuestionario + "</html>"));

            for (JComponent jComponent : Elementos) {
                this.add(jComponent);
                jComponent.setSize(400, 30);
                jComponent.setBackground(Color.white);
                try {Methods.setFont((JLabel)jComponent, 15);} catch (Exception e) {}
                try {Methods.setFont((JTextField)jComponent, 20);} catch (Exception e) {}
            }
            Methods.setFont((JLabel) Elementos.get(0), 20);
            ((JLabel) Elementos.get(1)).setSize(((JLabel) Elementos.get(1)).getSize().width, 90);
            Methods.Linear.Y(Elementos, 10, this.getSize().width / 2 - Elementos.get(0).getSize().width / 2, 100);        
            // Bloque 2 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

            // AddSelectButtons();
        }

        void selective(Integer select1){
            JButton select = (JButton) Botones.get(select1);
            if (Integer.valueOf(select.getText())==resultado) {
                Methods.msg("correcto", JOptionPane.INFORMATION_MESSAGE);
            }
        }


        ArrayList<Integer> aleatorio(Integer numero){
            ArrayList<Integer> retorno = new ArrayList<>();
            int pos;
            int nCartas = numero;
            Stack < Integer > pCartas = new Stack < Integer > ();
            for (int i = 0; i < nCartas ; i++) {
            pos = (int) Math.floor(Math.random() * nCartas );
            while (pCartas.contains(pos)) {
                pos = (int) Math.floor(Math.random() * nCartas );
            }
            pCartas.push(pos);
            }

            for (int i = 0; i < pCartas.size(); i++) {
                retorno.add(pCartas.get(i));
            }
            return retorno;
        }
    }
}
    
