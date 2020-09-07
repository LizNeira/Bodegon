
package bodegon;

import java.io.Serializable;

public class Cocinero extends Empleado implements Serializable
{
    
     private Sistema sistema;
     private GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
    
     public Cocinero(String usuario, String contrasenia, String codigo)
     {
       super(usuario, contrasenia, codigo);
     }   

     @Override
     public boolean menuPrincipal(Sistema sistema) 
     {
           int opcion;
           String mensaje;
           
           this.sistema = sistema;
            
           do 
           {
                mensaje = "\n-----Menu Cocinero-----\n"
                         +"[1] Mostrar pedidos por cocinar\n"
                         +"[2] Mostrar pedidos entregados\n"
                         +"[3] Salir\n"
                         +"Digite una opcion: ";
                opcion = EntradaYSalida.leerEntero(mensaje);
                
                switch (opcion) 
                {
                    case 1:
                            mostrarPedidoCocinarConPrecio();
                       break;
                    case 2:
                            mostrarPedidoEntregados();
                        break;
                    case 3:
                        EntradaYSalida.mostrarMensaje("Cerrando menu del cocinero...");
                      break;
                }
            
           } while(opcion != 3);
            
            return true;
     }

    private void mostrarPedidoEntregados()
    {
        int i = 1;
        
        for  (Pedido pedido :  this.sistema.getSistemaPedido().getListaPedidoEntregado())
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i)+"]"
                                          +"||Preparaciones: " + pedido.getPreparacion().getDescripcion()
                                          +"||Bebida: "+pedido.getBebida().getDescripcion());
            i++;
        }
        EntradaYSalida.leerCadena("\nPresione cualquier tecla para salir ");
        guardarYLeerArchivo.guardarArchivo(sistema);

    }

    private void mostrarPedidoCocinarConPrecio()
     {
       // Sistema sistema=null;
        String opcion;
        int indicePedido;
        int i=1;
   if(!this.sistema.getSistemaPedido().getListaPedidoCocinar().isEmpty())
   {
    do
      {       
        EntradaYSalida.mostrarMensaje("\n---Lista de pedidos por cocinar---\n");
        
        for  (Pedido pedido :  this.sistema.getSistemaPedido().getListaPedidoCocinar())
        {
            if ( pedido.getPrecio() > 0.0)
            {
                EntradaYSalida.mostrarMensaje("\n"+"["+(i)+"] " 
                                                  +"||Preparaciones: "  + pedido.getPreparacion().getDescripcion()
                                                  +"||Bebida: " + pedido.getBebida().getDescripcion() );
            }
          
         i++;
        }
        
        i = 1;
        indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
                
        while(indicePedido < 0 || indicePedido > this.sistema.getSistemaPedido().getListaPedidoCocinar().size())
        {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }
        
        Pedido pedidoSelecionado = this.sistema.getSistemaPedido().getListaPedidoCocinar().get(indicePedido - 1);
        this.sistema.getSistemaPedido().getListaPedidoEntregado().add(pedidoSelecionado);
        this.sistema.getSistemaPedido().getListaPedidoCocinar().remove(indicePedido -1);
        guardarYLeerArchivo.guardarArchivo(sistema);
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
      
        } while( opcion.equals("s") || opcion.equals("S"));
   }
   else
   {
   EntradaYSalida.leerCadena("\nNo hay pedidos por cocinar!\n\nPresione una tecla para salir...");
   }
  }

}
