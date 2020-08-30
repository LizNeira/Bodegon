
package bodegon;

import java.io.Serializable;

public class Cocinero extends Empleado implements Serializable
{
    
     public Cocinero(String usuario, String contrasenia, String codigo)
     {
       super(usuario, contrasenia, codigo);
     }   

     @Override
     public boolean menuPrincipal(Sistema sistema) 
     {
           int opcion;
           String mensaje;
            
           do 
           {
                mensaje = "\n-----Menu Cocinero-----\n"
                         +"[1] Mostrar pedidos por cocinar\n"
                         +"[2] Salir\n"
                         +"Digite una opcion: ";
                opcion = EntradaYSalida.leerEntero(mensaje);
                
                switch (opcion) 
                {
                    case 1:
                            mostrarPedidoCocinar();
                        
                       break;
                    
                    case 2:
                        EntradaYSalida.mostrarMensaje("Cerrando menu del cocinero...");
                      break;
                }
            
           } while(opcion != 2);
            
            return true;
     }

    private void mostrarPedidoCocinar()
    {
        //muestra la lista,
       EntradaYSalida.mostrarMensaje("\n----Lista de pedidos por cocinar----");
       // lista de pedidos
       EntradaYSalida.mostrarMensaje("\n----Lista de pedidos por cocinar----");

    }


}
