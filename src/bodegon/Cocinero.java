
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
                         +"[1] Ver pedidos para cocinar\n"
                         +"[2] Salir\n"
                         +"Digite una opcion: ";
                opcion = EntradaYSalida.leerEntero(mensaje);
                
                switch (opcion) 
                {
                    case 1:
                        
                       break;
                    
                    case 2:
                        EntradaYSalida.mostrarMensaje("Cerrando menu del cocinero");
                      break;
                }
            
           } while(opcion != 2);
            
            return true;
     }


}
