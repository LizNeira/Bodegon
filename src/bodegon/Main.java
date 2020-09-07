
package bodegon;

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
