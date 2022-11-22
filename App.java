import java.lang.reflect.Method;
import AppData.*;
import Inicio.Menu;
import Interfaces.*;

public class App extends Methods{
    public static Runnable selectOp = ()->{Menu.Open.run();};  
    public static void main(String[] args) {
        New_Window("EJERCICIO DE CAPACIATANCIA",()->{});
        selectOp.run();
        // Opc1.Open.run();
    }    
}
