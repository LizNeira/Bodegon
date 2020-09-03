
package bodegon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
       
        
       Controlador controlador = new Controlador();
        try
        {
            controlador.ejecutar();
        } 
        catch (NullPointerException e)
        {
            EntradaYSalida.mostrarMensaje(e.getMessage());
        }

    }
}
