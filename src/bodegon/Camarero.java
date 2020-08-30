package bodegon;

import java.io.Serializable;

public class Camarero extends Empleado implements Serializable
{    
   private SistemaPedido sistemaPedido = new SistemaPedido();
   
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
                        +"[2] Salir\n"
                        +"Digite una opcion: ";
           opcion = EntradaYSalida.leerEntero(mensaje);
                
           switch (opcion) 
           {
              case 1:
                      tomarPedido();
               break;
                    
              case 2:
                  EntradaYSalida.mostrarMensaje("Cerrando menu del camarero...");
                break;
           }
            
        } while(opcion != 2);
            
            return true;
    }

    private void tomarPedido()
    {
        String descripcion;
        String nombreBebida;   
        String opcion;
        int numeroMesa;
        
      do
      {       
        EntradaYSalida.mostrarMensaje("\n----Tomar Pedido----\n");
        descripcion = EntradaYSalida.leerCadena("Ingrese la preparacion: ");
        while(descripcion.isEmpty())
        {
          descripcion = EntradaYSalida.leerCadena("\nLa prepracion ingresada no es válida\n"
                                                   + "\nIngrese nuevamente: ");
        }

        nombreBebida = EntradaYSalida.leerCadena("Ingrese la bebida: "); 
        while(nombreBebida.isEmpty())
        {
          nombreBebida = EntradaYSalida.leerCadena("\nEl bebida ingresada no es válida\n"
                                                   + "\nIngrese nuevamente: ");
        }
        
//        numeroMesa = EntradaYSalida.leerEntero("Ingrese el numero de mesa: "); 
//        while(numeroMesa<=0)
//        {
//          numeroMesa = EntradaYSalida.leerEntero("\nLa mesa ingresada no es válida\n"
//                                                   + "\nIngrese nuevamente: ");
//        }
        
        sistemaPedido.setPedido(Preparacion.obtenerPreparacion(), descripcion,
                                Bebida.obtenerBebida(), nombreBebida);
                
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while( opcion.equals("s") || opcion.equals("S"));
         
                
    }
}
