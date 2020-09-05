
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
        Sistema sistema=null;
        String opcion;
        int indicePedido;
   
    do
      {       
        EntradaYSalida.mostrarMensaje("\n---Lista de pedidos por cocinar---n");
        // muestro el listado de pedidos+precio
        indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
                
         while (indicePedido < 0 || indicePedido > sistema.getSistemaPedido().getListaPedidoCocinar().size())
                {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
                }

        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while( opcion.equals("s") || opcion.equals("S"));
    
    }


}
