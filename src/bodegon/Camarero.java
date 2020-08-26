
package bodegon;

public class Camarero extends Empleado
{
 
   public Camarero(String usuario, String contrasenia, String codigo)
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
           mensaje = "\n-----Menu Camarero-----\n"
                        +"[1] Tomar pedido\n"
                        +"[2] Salir\n";
           opcion = EntradaYSalida.leerEntero(mensaje);
                
           switch (opcion) 
           {
              case 1:
                     
               break;
                    
              case 2:
                  EntradaYSalida.mostrarMensaje("Cerrando menu del camarero");
                break;
           }
            
        } while(opcion != 2);
            
            return true;
    }
}
