package AppData;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;


import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.function.Function;

public class Methods {
    public static JPanel this_Panel;
    public static JFrame this_Window;

    static ArrayList<Object_List> list_Panels = new ArrayList<>();
    static JComponent Temp_Component2;

    public static Date FechaActual(){
        return new Date();
    };

    public static Integer DateToMinute(Date fechaActual){
        // System.out.println(fechaActual);
        
        //Formateando la fecha:
        // DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        // DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        // System.out.println("Son las: "+formatoHora.format(fechaActual)+" de fecha: "+formatoFecha.format(fechaActual));
        //Fecha actual desglosada:
        Integer retorno=0;
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);

        Integer añoMinut = año * 525600;
        Integer mesMinut = mes * 43800;
        Integer DiaMinut = dia * 1440;
        Integer HoraMinut = hora* 60;

        retorno = añoMinut + mesMinut + DiaMinut + HoraMinut + minuto;
        // System.out.println(retorno);

        // System.out.println("Fecha Actual: "+ dia + "/" + (mes) + "/" + año);
        // System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);
        // System.out.println("-------------Fecha desglosada----------------");
        // System.out.println("El año es: "+ año);
        // System.out.println("El mes es: "+ mes);
        // System.out.println("El día es: "+ dia);
        // System.out.printf("La hora es: %02d %n", hora);
        // System.out.printf("El minuto es: %02d %n", minuto);
        // System.out.printf("El segundo es: %02d %n", segundo);

        return retorno;
    }

    public static Date MinutetoDate(Integer Minuts){
        Date retorno=null;
        // Integer MinutAño = Minuts/525600;
        // Integer MinutMes = Minuts/43800;
        // Integer MinutDia = Minuts/1440;
        // Integer MinutHora = Minuts/60;

        
        Integer Año=Minuts/525600;//-1900
        Integer Mes= (Minuts-(Año*525600))/43800;//MinutMes;
        Integer Dia=(Minuts-(Año*525600)-(Mes*43800))/1440;//MinutDia;
        Integer Hora=((Minuts-(Año*525600)-(Mes*43800) - (Dia*1440))/60);//MinutHora;
        Integer Minutos=((Minuts-(Año*525600)-(Mes*43800) - (Dia*1440) - (Hora*60)));//MinutHora;

        
        retorno = new Date(Año-1900, Mes-1, Dia, Hora, Minutos, 1);
        // System.out.println(retorno);
        
        // System.out.println(Minutos);

        return retorno;
    }

    public static JFrame New_Window(String Titulo, Runnable ejecuteClosing){
        list_Panels.clear();
        this_Window = new Object_Window(Titulo, ejecuteClosing);
        return this_Window;
    }
    public static class Object_Window extends JFrame{
        public Object_Window(String Titulo, Runnable ejecuteClosing){
            this_Window = this;
            this.setTitle(Titulo);
            this.setBackground(Color.white);
            this.setSize(700,600);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

            // this.getContentPane().setLayout(null);
            // this.setLayout(null);

            this.addWindowListener(new WindowListener(){
                @Override
                public void windowOpened(WindowEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                @Override
                public void windowClosing(WindowEvent e) {
                    // Close Window

                    ejecuteClosing.run();
                }
                @Override
                public void windowClosed(WindowEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                @Override
                public void windowIconified(WindowEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                @Override
                public void windowDeiconified(WindowEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                @Override
                public void windowActivated(WindowEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                @Override
                public void windowDeactivated(WindowEvent e) {
                    // TODO Auto-generated method stub
                    
                }
                
            });
            
        }
    }

    public static JFrame AddWindow(String Titulo){
        return AddWindow(Titulo, new JFrame());
    }
    public static JFrame AddWindow(String Titulo, JFrame standartInput){
        // JFrame standartInput=new JFrame();
        standartInput.requestFocus();
        this_Window.setEnabled(false);

        standartInput.setTitle(Titulo);
        standartInput.setLocation(10,10);
        standartInput.setSize(300,300);
        standartInput.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        standartInput.setLayout(null);
        standartInput.getContentPane().setBackground(Color.white);
        standartInput.getContentPane().setLayout(null);
        standartInput.setLocationRelativeTo(null);
        standartInput.setResizable(false);
        standartInput.setVisible(true);
        standartInput.addWindowListener(new WindowListener(){
            public void windowOpened(WindowEvent e) {}
            public void windowClosing(WindowEvent e) {
                // Close Window
                try {
                    this_Window.setEnabled(true);
                    this_Window.requestFocus();
                } catch (Exception o) {
                    // TODO: handle exception
                }
            }
            public void windowClosed(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowActivated(WindowEvent e) {}
            public void windowDeactivated(WindowEvent e) {}
        });
        return standartInput;
    }

    public static JPanel AddImage(String Ruta){
        JPanel standart = new ObjectImage(Ruta);
        standart.setLocation(10,10);
        // standart.setSize(width, height);
        standart.setLayout(null);
        return standart;
    }

    public static String charToString(int input) {
        char ch= (char) input;
        return String.valueOf(new char[] { ch });
    }

    static class ObjectImage extends JPanel{
        String ruta = "";
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen;
        public ObjectImage(String ruta) {
            this.ruta = ruta;
            imagen = t.getImage (ruta);
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(imagen, 1, 1, this.getSize().width, this.getSize().height, this);
            this.repaint();
        }

    }
   
    public static Runnable Set_Panel(Object ClaseActual, Runnable Main, Runnable Loop){
        this_Panel = new JPanel();
        this_Window.getContentPane().add(this_Panel);
        
        this_Panel.setName(ClaseActual.getClass().getName());
        this_Panel.setBackground(Color.white);
        this_Panel.setBounds(0,0,this_Window.getSize().width,this_Window.getSize().height);
        this_Panel.setLayout(null);
        this_Panel.setVisible(true);
        Main.run();
        
        list_Panels.add(new Object_List(this_Panel, this_Window.getSize().width, this_Window.getSize().height));
        this_Panel.repaint();
        Runnable Retorno=()->SelectPanel(ClaseActual, Loop);
        return Retorno;
    }
    static void SelectPanel(Object Class_Selec, Runnable Loop){
        for (Object_List ElementJPanel : list_Panels) {ElementJPanel.panel.setVisible(false);}
        for (Object_List ElementJPanel : list_Panels) {
            if (ElementJPanel.panel.getName().equals(Class_Selec.getClass().getName())) {
                ElementJPanel.panel.setVisible(true); 
                this_Window.setSize(ElementJPanel.width, ElementJPanel.height);
                this_Window.setLocationRelativeTo(null);
                this_Panel = ElementJPanel.panel;
            }}
        Loop.run();
    }

    static class Object_List {
        public JPanel panel;
        public Integer width;        
        public Integer height;
        public Object_List(JPanel panel, Integer width, Integer height) {
            this.panel = panel;
            this.width = width;
            this.height = height;
        }        
    }

    public static Object $_Return=null; 
    public static Function $_Funcion(Runnable activacion){
        Function Standart= new Function() {
            @Override
            public Object apply(Object t) {
                $_Return = t;
                activacion.run();
                return null;
            }
        };
        return Standart;
    }

    public static Integer[] $_NameToList(JButton input){
        String entrada[] = input.getName().split(",");
        return new Integer[]{Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1])};
    }

    static public JButton AddButton(String text, Runnable active){
        JButton Standart = new JButton();
        Standart.setBounds(0,0, 80,25);
        Standart.setText(text);
        Standart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                active.run();
            }
        });
        Temp_Component2 = Standart;
        return Standart;
    }

    public static class  Action_Object implements ActionListener {
        public Function Retorno;
        @Override
        public void actionPerformed(ActionEvent e) {
            Retorno.apply(e);
        }

    }

    public static class  $_Action_Object_run implements ActionListener {
        public Runnable Retorno;
        @Override
        public void actionPerformed(ActionEvent e) {
            Retorno.run();
        }

    }

    public static class panelGroup extends JPanel{
        public ArrayList<ArrayList<JButton>> ListComponent = new ArrayList<>();
        public JButton $_Return;
        public Integer $_ID;
        Integer countItem;
        public panelGroup() {
            this.setLayout(null);
        }

        public ArrayList<ArrayList<JButton>> CreateList(ArrayList<String> input, Integer width, Integer height, Runnable ActionLoad, Runnable ActionClick){
            ArrayList<ArrayList<JButton>> retorno = new ArrayList<>();

            this.removeAll();
            this.repaint();
            
            Integer sepX = 10;
            Integer sepY =10;

            
            Integer Columnas = this.getSize().width / width;
            Integer Filas = this.getSize().height / height;

            Integer inicialX=(this.getSize().width/2- ((width + sepX)*Columnas)/2) + 5;
            Integer inicialY=10;

            countItem=0;
            for (int fil = 0; fil < Filas; fil++) {
                for (int col = 0; col < Columnas; col++) {
                    if (countItem<input.size()) {
                        JButton boton = new JButton();
                        boton.setSize(width, height);
                        boton.setLayout(null);
                        boton.setLocation(inicialX + ((width + sepX)*col), inicialY + ((height + sepY)*fil));
                        boton.setText(input.get(countItem));
                        boton.setName(String.valueOf(countItem));
                        $_Return = boton;
                        ActionLoad.run();
                        boton.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                $_Return = boton;
                                $_ID=Integer.valueOf(boton.getName());
                                ActionClick.run();
                            }
                        });
                        this.add(boton);
                        this.repaint();
                        countItem++;
                    }
                }
            }
            this.repaint();
            ListComponent = retorno;
            return retorno;
        }

    }

    static public JLabel AddLabel(String text){
        JLabel Standart = new JLabel();
        Standart.setHorizontalAlignment(SwingConstants.CENTER);
        Standart.setBounds(0,0, 150,25);
        Standart.setText(text);
        Temp_Component2 = Standart;
        return Standart;
    }

    static public JTextField AddTextField(String text){
        JTextField Standart = new JTextField();
        Standart.setBounds(0,0, 150,25);
        // Standart.setText(text);
        Methods.placeholder(text, Standart);
        Temp_Component2 = Standart;
        return Standart;
    }

    static public JTextField AddTextNumer(String text){
        JTextField Standart = new JTextField();
        Standart.setBounds(0,0, 150,25);
        Standart.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                int key = e.getKeyChar();
                boolean numeros = (key >= 48 && key <= 57);
                if (!numeros)
                {
                    e.consume();
                }

                if (Standart.getText().trim().length() == 10) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        Methods.placeholder(text, Standart);
        Temp_Component2 = Standart;
        return Standart;
    }

    static public JPasswordField AddPassword(String text){
        JPasswordField Standart = new JPasswordField();
        Standart.setBounds(0,0, 150,25);
        // Standart.setText(text);
        Methods.placeholder(text, Standart);
        Temp_Component2 = Standart;
        return Standart;
    }

    static public JTextArea AddTextArea(String text){
        JTextArea Standart = new JTextArea();
        Standart.setBounds(0,0, 150,25);
        Standart.setText(text);
        Temp_Component2 = (JComponent) Standart;
        return Standart;
    }

    static public JComboBox AddCombobox(String text){
        JComboBox Standart = new JComboBox();
        Standart.setBounds(0,0, 150,25);
        Standart.addItem(text);
        Temp_Component2 = Standart;
        return Standart;
    }

    static public JPanel AddPanel(Integer x, Integer y){
        JPanel Standart = new JPanel();
        Standart.setBounds(x,y, 500,500);
        Standart.setLayout(null);
        Temp_Component2 = Standart;
        return Standart;
    }

    static public JLabel[] AddTextShow(String text, String text1, Integer x, Integer y){
        JLabel Standart[] = {
            new JLabel(text),
            new JLabel(text1),
        };
        
        Standart[0].setBounds(x,y, 160,20);
        Standart[1].setBounds(x,y, 160,20);
        Standart[0].setBackground(new Color(186, 251, 148 ));
        Standart[1].setBackground(new Color(186, 251, 148 ));
        LinearListY(Standart[0], Standart[1]);
        return Standart;
    }

    static public JComponent[] AddTextAreaShow(String text, String text1, Integer x, Integer y){
        JComponent Standart[] = {
            new JLabel(text),
            new JTextArea(text1),
            new JScrollPane(),
        };
        
        Standart[0].setBounds(x,y, 160,20);
        Standart[0].setBackground(new Color(186, 251, 148 ));
        
        Standart[2] = new JScrollPane(Standart[1]);
        Standart[2].setBounds(x,y, 160,60);
        Standart[2].setBackground(new Color(186, 251, 148 ));
        
        JTextArea a = (JTextArea) Standart[1]; 
        a.setEditable(false);

        LinearListY(Standart[0], Standart[2]);
        Standart[2].setLocation(Standart[2].getLocation().x, Standart[2].getLocation().y + 10);
        return Standart;
    }


    static public ObjetTable AddTable(String[] Columns){
        ObjetTable Standart = new ObjetTable(ToArray(Columns));
        return Standart;
    }


    // Standart.Modelo.addRow(new String[]{"dato1","dato2", "dato3"});
    // Standart.Tabla.setFont(new java.awt.Font("Tahoma", 0, 30));
    // Standart.Tabla.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 20));
    // Standart.Tabla.getTableHeader().setBackground(Color.white);
    // Standart.Tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(10, 40));
    // Standart.Tabla.getColumnModel().getColumn(0).setMaxWidth(30);
    // Standart.Tabla.setRowHeight(100);
    // Standart.Tabla.setBackground(Color.white);

    public static class  ObjetTable {
        public ArrayList<ArrayList<String>> TablaArray = new ArrayList<>();
        public DefaultTableModel Modelo = new DefaultTableModel();
        public JTable Tabla = new JTable(Modelo){public boolean isCellEditable(int rowIndex, int vColIndex) {return false;}};
        public JScrollPane Contenedor = new JScrollPane(Tabla);
        ObjetTable(ArrayList<String> Columnas){
            Contenedor.setBounds(10,10,200,200);
            Tabla.setBackground(Color.white);
            SyncColum(Columnas);
        };

        public void setLocation(Integer x, Integer y){Contenedor.setLocation(x, y);}
        public void setSize(Integer width, Integer height){Contenedor.setSize(width, height);}

        public punto getLocation(){return new punto(Contenedor.getLocation().x, Contenedor.getLocation().y);} 
        public Dimension getSize(){return Contenedor.getSize();} 

        void ResetAll(){
            JScrollPane guardado = new JScrollPane();
            guardado.setBounds(Contenedor.getBounds());
            Modelo = new DefaultTableModel();
            Tabla.setModel(Modelo);
            Contenedor.setBounds(guardado.getBounds());
        }

        void ResetConcent(){
            Modelo.getDataVector().clear();
            for (int i = 0; i < Tabla.getRowCount(); i++) {
                Modelo.removeRow(i);
            }
        }

        public void SyncColum(ArrayList<String> Columnas){
            ResetAll(); 
            for (int i = 0; i < Columnas.size(); i++) {
                Modelo.addColumn(Columnas.get(i));
            }}
        public void SyncRow(ArrayList<ArrayList<String>> Filas){
            ResetConcent();
            TablaArray=Filas;
            for (int i = 0; i < Filas.size(); i++) {
                Modelo.addRow(Filas.get(i).toArray());
            }}
    }

    public static void LinearListY(JComponent comp1, JComponent comp2){
        comp2.setLocation(comp1.getLocation().x, comp1.getLocation().y + comp1.getSize().height - 5);
    }
    public static void LinearListX(JComponent comp1, JComponent comp2){
        comp2.setLocation(comp1.getLocation().x + comp1.getSize().width - 5, comp1.getLocation().y);
    }

    public static ArrayList<String> ToArray(String[] input){
        return new ArrayList<String>(Arrays.asList(input));
    }

    public static Integer Mitad(JComponent input){
        return this_Window.getSize().width/2 - input.getSize().width/2;
    }

    public static void setMitad(JComponent input){
        input.setLocation(this_Window.getSize().width/2 - input.getSize().width/2, input.getLocation().y);
    }

    public static class Linear{

        public static class Next {
            public static Void set_x(JComponent input, Integer sep){
                Temp_Component2.setLocation(input.getSize().width + input.getLocation().x + sep, Temp_Component2.getLocation().y);
                return null;
            }
            public static Void set_y(JComponent input, Integer sep){
                Temp_Component2.setLocation(Temp_Component2.getLocation().x, input.getSize().height + input.getLocation().y + sep);
                return null;
            }
            public static Integer x(JComponent input){return x(input, 0);}
            public static Integer x(JComponent input, Integer sep){
                return input.getLocation().x + input.getSize().width + sep; 
            }
            public static Integer y(JComponent input){return y(input, 0);}
            public static Integer y(JComponent input, Integer sep){
                return input.getLocation().y + input.getSize().height + sep; 
            }
        }

        public static void X(ArrayList<JComponent> lista,Integer sep, Integer X, Integer Y){
            X(lista, sep, X, Y, null);
        }
        public static void X(ArrayList<JComponent> lista,Integer sep, Integer X, Integer Y, Integer width){
            Integer AdX = X;    
            if (!(width==null)) {
                Integer sumaW=0;
                for (int i = 0; i < lista.size(); i++) {sumaW += lista.get(i).getSize().width + sep;}
                AdX = ((width/2)-(sumaW/2)) + X;    
            }
            
            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setLocation(AdX, Y);
                AdX += lista.get(i).getSize().width + sep;
            }
        }
         public static void Y(ArrayList<JComponent> lista,Integer sep, Integer X, Integer Y){
            Y(lista, sep, X, Y, null);
        }
        public static void Y(ArrayList<JComponent> lista,Integer sep, Integer X, Integer Y, Integer height){
            Integer AdY = Y;  
            if (!(height==null)) {
                Integer sumaH=0;
                for (int i = 0; i < lista.size(); i++) {sumaH += lista.get(i).getSize().height + sep;}
                AdY = ((height/2)-(sumaH/2)) + Y;  
            }

            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setLocation(X, AdY);
                AdY += lista.get(i).getSize().height + sep;
            }
        }
        
    }

    public static void setFont(JButton label1, Integer size){
        label1.setFont(new java.awt.Font("Tahoma", 0, size));
    };

    public static void setFont(JLabel label1, Integer size){
        label1.setFont(new java.awt.Font("Tahoma", 0, size));
    };

    public static void setFont(JTextComponent label1, Integer size){
        label1.setFont(new java.awt.Font("Tahoma", 0, size));
    };

    public static void setColor(JComponent input, Integer R, Integer G, Integer B){
        input.setBackground(new Color(R, G, B));
    };

    public static class punto{
        public Integer x=0;
        public Integer y=0;
        punto(Integer x, Integer y){
            this.x=x; 
            this.y=y;
        };
    }

    public static void placeholder(String texto, JTextComponent elemento){
        TextPrompt placeholder = new TextPrompt(texto, elemento);
        
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
    }

    public static class Computer {
        public static String Ruta = "./";
        public static void Write(Object input){Write(input, Ruta);}
        public static Object Read(){return Read(Ruta);}

        public static void Delete(){
            Delete(Ruta);
        }
        public static void Delete(String ruta){
            File FILER = new File(ruta);
            FILER.delete();
        }

        public static void Write(Object input, String ruta){
            try {
                ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(ruta));
                write.writeObject(input);
                write.close();
            } catch (Exception e) {
                System.out.println("Verifique si su objeto es Serializable (  implements Serializable )");
            }
        }
        public static Object Read(String ruta){
            Object retorno = null;
            try {
                ObjectInputStream read = new ObjectInputStream(new FileInputStream(ruta));
                retorno = read.readObject();
                read.close();
            } catch (Exception e) {
                System.out.println("Verifique si su objeto es Serializable (  implements Serializable )");
            }
            return retorno;
        }
    }

    public static void println(Object input){System.out.println(input);}
    public static void print(Object input){System.out.println(input);}

    public static void msg(String text){
        msg(text, JOptionPane.ERROR_MESSAGE);
    }


    public static Integer msgOp(String text){
        return msgOp(text, "Alert");
    }

    public static boolean msgOp_yes(String text){
        return msgOp(text, "Alert")==JOptionPane.OK_OPTION;
    }

    public static Integer msgOp(String text, String title){
        return JOptionPane.showConfirmDialog(null, text, title, JOptionPane.YES_NO_OPTION);
    }

    public static boolean msgOp_yes(String text, String title){
        return JOptionPane.showConfirmDialog(null, text, title, JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION;
    }

    
    public static void msg(String text, Integer select){
        JOptionPane.showMessageDialog(null, text, "Security" ,select);
    }


        /**
     *  The TextPrompt class will display a prompt over top of a text component when
     *  the Document of the text field is empty. The Show property is used to
     *  determine the visibility of the prompt.
     *
     *  The Font and foreground Color of the prompt will default to those properties
     *  of the parent text component. You are free to change the properties after
     *  class construction.
     */
    public static class TextPrompt extends JLabel
    implements FocusListener, DocumentListener
    {
    public enum Show
    {
        ALWAYS,
        FOCUS_GAINED,
        FOCUS_LOST;
    }

    private JTextComponent component;
    private Document document;

    private Show show;
    private boolean showPromptOnce;
    private int focusLost;

    public TextPrompt(String text, JTextComponent component)
    {
        this(text, component, Show.ALWAYS);
    }

    public TextPrompt(String text, JTextComponent component, Show show)
    {
        this.component = component;
        setShow( show );
        document = component.getDocument();

        setText( text );
        setFont( component.getFont() );
        setForeground( component.getForeground() );
        setBorder( new EmptyBorder(component.getInsets()) );
        setHorizontalAlignment(JLabel.LEADING);

        component.addFocusListener( this );
        document.addDocumentListener( this );

        component.setLayout( new BorderLayout() );
        component.add( this );
        checkForPrompt();
    }

    /**
     *  Convenience method to change the alpha value of the current foreground
     *  Color to the specifice value.
     *
     *  @param alpha value in the range of 0 - 1.0.
     */
    public void changeAlpha(float alpha)
    {
        changeAlpha( (int)(alpha * 255) );
    }

    /**
     *  Convenience method to change the alpha value of the current foreground
     *  Color to the specifice value.
     *
     *  @param alpha value in the range of 0 - 255.
     */
    public void changeAlpha(int alpha)
    {
        alpha = alpha > 255 ? 255 : alpha < 0 ? 0 : alpha;

        Color foreground = getForeground();
        int red = foreground.getRed();
        int green = foreground.getGreen();
        int blue = foreground.getBlue();

        Color withAlpha = new Color(red, green, blue, alpha);
        super.setForeground( withAlpha );
    }

    /**
     *  Convenience method to change the style of the current Font. The style
     *  values are found in the Font class. Common values might be:
     *  Font.BOLD, Font.ITALIC and Font.BOLD + Font.ITALIC.
     *
     *  @param style value representing the the new style of the Font.
     */
    public void changeStyle(int style)
    {
        setFont( getFont().deriveFont( style ) );
    }

    /**
     *  Get the Show property
     *
     *  @return the Show property.
     */
    public Show getShow()
    {
        return show;
    }

    /**
     *  Set the prompt Show property to control when the promt is shown.
     *  Valid values are:
     *
     *  Show.AWLAYS (default) - always show the prompt
     *  Show.Focus_GAINED - show the prompt when the component gains focus
     *      (and hide the prompt when focus is lost)
     *  Show.Focus_LOST - show the prompt when the component loses focus
     *      (and hide the prompt when focus is gained)
     *
     *  @param show a valid Show enum
     */
    public void setShow(Show show)
    {
        this.show = show;
    }

    /**
     *  Get the showPromptOnce property
     *
     *  @return the showPromptOnce property.
     */
    public boolean getShowPromptOnce()
    {
        return showPromptOnce;
    }

    /**
     *  Show the prompt once. Once the component has gained/lost focus
     *  once, the prompt will not be shown again.
     *
     *  @param showPromptOnce  when true the prompt will only be shown once,
     *                         otherwise it will be shown repeatedly.
     */
    public void setShowPromptOnce(boolean showPromptOnce)
    {
        this.showPromptOnce = showPromptOnce;
    }

    /**
     *	Check whether the prompt should be visible or not. The visibility
    *  will change on updates to the Document and on focus changes.
    */
    private void checkForPrompt()
    {
        //  Text has been entered, remove the prompt

        if (document.getLength() > 0)
        {
            setVisible( false );
            return;
        }

        //  Prompt has already been shown once, remove it

        if (showPromptOnce && focusLost > 0)
        {
            setVisible(false);
            return;
        }

        //  Check the Show property and component focus to determine if the
        //  prompt should be displayed.

        if (component.hasFocus())
        {
            if (show == Show.ALWAYS
            ||  show ==	Show.FOCUS_GAINED)
                setVisible( true );
            else
                setVisible( false );
        }
        else
        {
            if (show == Show.ALWAYS
            ||  show ==	Show.FOCUS_LOST)
                setVisible( true );
            else
                setVisible( false );
        }
    }

    //  Implement FocusListener

    public void focusGained(FocusEvent e)
    {
        checkForPrompt();
    }

    public void focusLost(FocusEvent e)
    {
        focusLost++;
        checkForPrompt();
    }

    //  Implement DocumentListener

    public void insertUpdate(DocumentEvent e)
    {
        checkForPrompt();
    }

    public void removeUpdate(DocumentEvent e)
    {
        checkForPrompt();
    }

    public void changedUpdate(DocumentEvent e) {}
    }


}
