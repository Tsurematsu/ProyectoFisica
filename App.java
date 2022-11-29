import java.lang.reflect.Method;
import AppData.*;
import Inicio.Bienvenida;
import Inicio.Menu;
import Interfaces.*;

public class App extends Methods{
    public static void main(String[] args) {
        New_Window("EJERCICIO DE CAPACIATANCIA",()->{});
        Bienvenida.Open.run();
        // Opc1.Open.run();
    }    
}
