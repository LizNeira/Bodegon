
package bodegon;

/**
 * @author Alberto Arcentales
 * @author Liz Neira
 * @author Ariel Sandrigo
 */

public class Main {
    
    public static void main(String[] args) 
    {
       
        Controlador controlador  = Controlador.getInstancia();
       
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
