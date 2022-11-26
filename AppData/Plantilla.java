package AppData;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

import Inicio.Menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plantilla extends JPanel{

    public Runnable Formula=()->{};
    public String $_Retorno_Formula="";
    public String $_Intput1_Retorno="";
    public String $_Intput2_Retorno="";
    public Integer $_RedondeoButtons=0;
    public Boolean $_Relevar_Respuestas = false;
    public Boolean $_JopcionMessage_Incorrect = false;

    
    public String Titulo="Este es un titulo"; 
    public String Descripcion="Descripción del problema"; 

    public String Input1=""; 
    public String Input2="";
    
    public String Cuestionario="Descripción del cuestionario";
    public Double resultado;
    public Integer $$_Numer_Button_Option=3;
    public String  $$_Return_Msg_Correct="Correcto";
    public String  $$_Return_Msg_Error="Error opción no correcta";

    public Runnable AlFinalizar = ()->{};

    
    SubPanel1 Sub1; 
    SubPanel2 Sub2; 

    Boolean panelSelect = true;
    public String Input0;

    public Plantilla() {
        Methods.this_Window.setSize(600,450);
        this.repaint();}

    public void ReloadCuestions(){
        Sub2.AddSelectButtons();
    }

    void atrás(){
        JTextField input1 = (JTextField) Sub1.ElementosGroup1.get(2);
        JTextField input2 = (JTextField) Sub1.ElementosGroup1.get(3);
        input1.setText("");
        input2.setText("");
        Sub2.msgError.setText("");
        panelSelect=true; 
        Restard(); 
        Menu.Open.run();
    }

    public void Aply(){
        
        this.setLayout(null);

        JButton Home = Methods.AddButton("Home", ()->{atrás();});
        Home.setFocusable(true);
        Home.requestFocus();
        this.add(Home);
        Home.setBackground(Color.white);

        Sub1 = new SubPanel1();
        this.add(Sub1);
        Sub1.setBounds(this.getBounds());
        Sub1.setLayout(null);
        Sub1.setBackground(Color.white);
        Sub1.Aply();
        
        
        Sub2 = new SubPanel2();
        this.add(Sub2);
        Sub2.setBounds(this.getBounds());
        Sub2.setLayout(null);
        Sub2.setBackground(Color.white);
        Sub2.Aply();

        Restard();

        
    }

    void Restard(){
        Sub1.setVisible(panelSelect);
        Sub2.setVisible(!panelSelect);
    }

    public class SubPanel1 extends JPanel{
        public ArrayList<JComponent> ElementosGroup1 = new ArrayList<>();    
        public SubPanel1() {}
        public void Aply(){
            this.setLocation(0,0);
            this.setLayout(null);
            // Bloque 1 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            ElementosGroup1.add(Methods.AddLabel("<html>" + Titulo + "</html>"));
            
            ElementosGroup1.add(Methods.AddLabel("<html>" + Descripcion + "</html>"));
            JLabel select = (JLabel) ElementosGroup1.get(ElementosGroup1.size()-1);
            select.setHorizontalAlignment(SwingConstants.LEFT);
            select.setVerticalAlignment(SwingConstants.TOP);

            ElementosGroup1.add(Methods.AddTextNumer(String.valueOf(Input1)));   
            ElementosGroup1.add(Methods.AddTextNumer(String.valueOf(Input2)));

            ElementosGroup1.add(Methods.AddButton("Calcular", ()->{
                JTextField input1 = (JTextField) ElementosGroup1.get(2);
                JTextField input2 = (JTextField) ElementosGroup1.get(3);
                if (input1.getText().length()>0 && input2.getText().length()>0) {
                    $_Intput1_Retorno=input1.getText(); 
                    $_Intput2_Retorno=input2.getText(); 
                    Formula.run(); 
                    ((JLabel) ElementosGroup1.get(5)).setText("<html>" + $_Retorno_Formula + "</html>");
                }else{
                    Methods.msg("Hay campos vacíos");
                }
            }));
            ElementosGroup1.add(Methods.AddLabel("Resultado"));

            ElementosGroup1.add(Methods.AddButton("Siguiente", ()->{
                JTextField input1 = (JTextField) ElementosGroup1.get(2);
                JTextField input2 = (JTextField) ElementosGroup1.get(3);
                input1.setText("");
                input2.setText("");
                panelSelect=false;
                Restard();
                // Sub2.Aply();
            }));

            
            for (JComponent jComponent : ElementosGroup1) {
                this.add(jComponent);
                jComponent.setSize(400, 30);
                jComponent.setBackground(Color.white);
                try {Methods.setFont((JLabel)jComponent, 15);} catch (Exception e) {}
                try {Methods.setFont((JTextField)jComponent, 20);} catch (Exception e) {}
            }

            Methods.setFont((JLabel) ElementosGroup1.get(0), 20);
            ((JLabel) ElementosGroup1.get(1)).setSize(((JLabel) ElementosGroup1.get(1)).getSize().width, 120);

            Methods.Linear.Y(ElementosGroup1, 10, this.getSize().width / 2 - ElementosGroup1.get(0).getSize().width / 2, 30);        
            // Bloque 1 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    
            
            this.repaint();
        }


    }
    
    public class SubPanel2 extends JPanel{
        ArrayList<JComponent> Elementos = new ArrayList<>();
        ArrayList<JComponent> Botones = new ArrayList<>();
        Integer botonSelInteger =-1;
        JLabel msgError;
        public SubPanel2() {}
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

            JLabel select;
            select = (JLabel) Elementos.get(1);
            select.setText("<html><CENTER>" + Cuestionario + "</CENTER></html>");

            Integer numero=$$_Numer_Button_Option;
            ArrayList<Double> botones = new ArrayList<>();
            for (int i = 0; i < numero; i++) {botones.add((Double) (Math.random() * 100));}
            botones.add(resultado);
            ArrayList<Integer> numAl = aleatorio(numero + 1);

            
            // Bloque 2 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            for (int i = 0; i < botones.size(); i++) {
                JButton botonStandar = new JButton();
                botonStandar.setName(String.valueOf(i));
                //Valor
                if ($_Relevar_Respuestas) {botonStandar.setBackground(Color.GRAY);}
                // botonStandar.setText(String.valueOf(Methods.RoundNum(botones.get(numAl.get(i)), $_RedondeoButtons)));
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

            if ($_Relevar_Respuestas) {
                for (JComponent integer : Botones) {
                    JButton RT = (JButton) integer;
                    if (RT.getText().equals(String.valueOf(resultado))) {
                        RT.setBackground(Color.green);
                    }
                }
            }

            for (JComponent jComponent : Botones) {
                this.add(jComponent);
                jComponent.setBackground(Color.WHITE);
                Integer largoBtn = (Elementos.get(1).getSize().width - (10*numero))/ (numero + 1);//120
                jComponent.setSize(largoBtn, 30);
            }

            Methods.Linear.X(Botones, 10, 0, Elementos.get(Elementos.size()-1).getLocation().y + Elementos.get(Elementos.size()-1).getSize().height + 20, this.getSize().width);
        }

        public void Aply(){

            JLabel select;

            Elementos.add(Methods.AddLabel("<html><CENTER>" + Titulo + "</CENTER></html>"));    
            select = (JLabel) Elementos.get(Elementos.size()-1);


            Elementos.add(Methods.AddLabel("<html>" + Cuestionario + "</html>"));
            select = (JLabel) Elementos.get(Elementos.size()-1);
            select.setHorizontalAlignment(SwingConstants.CENTER);
            select.setVerticalAlignment(SwingConstants.TOP);

            for (JComponent jComponent : Elementos) {
                this.add(jComponent);
                jComponent.setSize(this.getSize().width -180, 60);
                jComponent.setBackground(Color.white);
                try {Methods.setFont((JLabel)jComponent, 15);} catch (Exception e) {}
                try {Methods.setFont((JTextField)jComponent, 20);} catch (Exception e) {}
            }
            
            JLabel selectSS =  (JLabel) Elementos.get(0);
            Methods.setFont(selectSS, 20);
            
            selectSS =  (JLabel) Elementos.get(1);
            selectSS.setSize(selectSS.getSize().width, 150);
            
            selectSS =  (JLabel) Elementos.get(0);
            Methods.Linear.Y(Elementos, 10, this.getSize().width / 2 - selectSS.getSize().width / 2, 30);        
            
            selectSS =  (JLabel) Elementos.get(1);
            selectSS.setLocation(selectSS.getLocation().x, selectSS.getLocation().y + 10);

            msgError = Methods.AddLabel("<html><b></b></html>");
            msgError.setHorizontalAlignment(SwingConstants.LEFT);
            msgError.setVerticalAlignment(SwingConstants.TOP);
            msgError.setSize(selectSS.getSize().width, 80);
            msgError.setLocation(selectSS.getLocation().x, selectSS.getSize().height + selectSS.getLocation().y + 80);
            this.add(msgError);



            // Bloque 2 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

            // AddSelectButtons();
        }

        void selective(Integer select1){
            JButton select = (JButton) Botones.get(select1);

            if (select.getText().equals(String.valueOf(resultado))) {
                select.setBackground(Color.green);
                Methods.msg($$_Return_Msg_Correct, JOptionPane.INFORMATION_MESSAGE);
                atrás();
            }else{
                select.setBackground(Color.red);
                msgError.setText($$_Return_Msg_Error);
                for (JComponent jComponent : Botones) {
                    jComponent.setEnabled(false);
                }
                if ($_JopcionMessage_Incorrect) {
                    Methods.msg($$_Return_Msg_Error, JOptionPane.INFORMATION_MESSAGE);
                }
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
    
