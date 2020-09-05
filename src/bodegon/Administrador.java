
package bodegon;

import java.io.Serializable;

public class Administrador extends Empleado implements Serializable
{    
    GuardarYLeerArchivo guardarYLeerArchivo =new GuardarYLeerArchivo();
    Resumen resumen = null;
    
    public Administrador(String usuario, String contrasenia, String codigo)
    {
        super(usuario, contrasenia, codigo);
        resumen = new Resumen();
    }
   
    @Override
    public boolean menuPrincipal(Sistema sistema)
    {    
        int opcion;
        String mensaje;
        boolean seguir = true;
        
       do
       { 
             mensaje="\n\n----Bienvenidos----\n"
                    +"[1] Dar de alta Cocinero\n"
                    +"[2] Dar de alta Camarero\n"
                    +"[3] Dar precios a pedidos\n"
                    +"[4] Ver resumen de pedidos\n"
                    +"[5] Salir\n"
                    +"Digite una opcion: ";
         opcion = EntradaYSalida.leerEntero(mensaje);
        
         switch (opcion)
         {
            case 1: 
                    altaCocinero(sistema);
             break;
            case 2:
                    altaCamarero(sistema);
             break;
            case 3:
                    darPrecioPedido(sistema);
             break;
            case 4:
                    mostrarResumenGeneral();
             break;
         }
       
       } while (!(opcion == 5));
       
        return seguir;

    }

    private void altaCocinero(Sistema sistema)
    {
        Empleado empleado;
        String usuario, contrasenia, codigo,opcion;
        
        do
        {
            usuario = EntradaYSalida.leerCadena("\nIngrese su nombre: ");
            while (usuario.isEmpty())
            {
                usuario = EntradaYSalida.leerCadena("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
            }

            contrasenia = EntradaYSalida.leerCadena("Ingrese su contraseña: ");
            while (contrasenia.isEmpty())
            {
                contrasenia = EntradaYSalida.leerCadena("ERROR: La contraseña no puede ser nula"
                        + "+Ingrese su contraseña:");
            }
            
            codigo = EntradaYSalida.leerCadena("Ingrese su código de acceso único: ");
            while (codigo.isEmpty())
            {
                codigo = EntradaYSalida.leerCadena("ERROR: El código no puede ser nulo"
                        + "Ingrese su usuario: ");
            }
            
            empleado = sistema.getSistemaEmpleado().buscarEmpleado(codigo);
            if (empleado != null)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El codigo ya figura en el sistema");
            } 
            else
            {
                sistema.getSistemaEmpleado().getlistaEmpleado().add(new Cocinero(usuario, contrasenia, codigo));
                guardarYLeerArchivo.guardarArchivo(sistema);
                EntradaYSalida.mostrarMensaje("\nSe ha incorporado el COCINERO al sistema\n");
            }
            
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
  }
    
    private void altaCamarero(Sistema sistema)
    {
        Empleado empleado;
        String usuario, contrasenia, codigo;
        String opcion;

        do
        {
            usuario = EntradaYSalida.leerCadena("\nIngrese su nombre: ");
            while (usuario.isEmpty())
            {
                usuario = EntradaYSalida.leerCadena("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
            }

            contrasenia = EntradaYSalida.leerCadena("Ingrese su contraseña: ");
            while (contrasenia.isEmpty())
            {
                contrasenia = EntradaYSalida.leerCadena("ERROR: La contraseña no puede ser nula"
                        + "+Ingrese su contraseña:");
            }
            
            codigo = EntradaYSalida.leerCadena("Ingrese su código de acceso único: ");
            while (codigo.isEmpty())
            {
                codigo = EntradaYSalida.leerCadena("ERROR: El códigono puede ser nulo"
                        + "Ingrese su usuario: ");
            }
            
            empleado = sistema.getSistemaEmpleado().buscarEmpleado(codigo);
            if (empleado != null)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El código ya figura en el sistema");
            } 
            else
            {
                sistema.getSistemaEmpleado().getlistaEmpleado().add(new Camarero(usuario, contrasenia, codigo));
                guardarYLeerArchivo.guardarArchivo(sistema);
                EntradaYSalida.mostrarMensaje("\nSe ha incorporado el CAMARERO al sistema\n");
            }
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
  }

    private void darPrecioPedido(Sistema sistema)
    {
        Double precio = 0.0;
        String opcion;
        int indicePedido;
        
        do
        {
               EntradaYSalida.mostrarMensaje("\n----Lista de pedidos----");
               sistema.getSistemaPedido().mostrarListaPedidoCocinar();
               indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
                
                while (indicePedido < 0 || indicePedido > sistema.getSistemaPedido().getListaPedidoCocinar().size())
                {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
                }
                sistema.getSistemaPedido().precioPedido(indicePedido);
                
                precio = EntradaYSalida.leerDouble("\nIngrese el precio: ");
                while (precio <= 0.0)
                {
                precio = EntradaYSalida.leerDouble("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
                }
                
               sistema.getSistemaPedido().getListaPedidoCocinar().get(indicePedido).setPrecio(precio);
               resumen.setPrecioTotal(precio);
               EntradaYSalida.mostrarMensaje("Precio a pagar" + precio);
     
               opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
    }

    private void mostrarResumenGeneral()
    {
        String mensaje;
        int opcion;
        
       do
       { 
             mensaje="\n\n----Resumen General----\n"
                    +"[1] Recaudacion total\n"
                    +"[2] Preparacion mas pedida\n"
                    +"[3] Bebida mas pedida\n"
                    +"[4] Camarero que atendio mas pedido\n"
                    +"[5] Salir\n"
                    +"Digite una opcion: ";
         opcion = EntradaYSalida.leerEntero(mensaje);
        
         switch (opcion)
         {
            case 1: 
                EntradaYSalida.mostrarMensaje("Recaudacion total: " 
                        + resumen.getPrecioTotal());
             break;
            case 2:
                 EntradaYSalida.mostrarMensaje("Preparacion mas pedida: " + 
                         resumen.getPreparacionMasVendida());   
             break;
            case 3:
                 EntradaYSalida.mostrarMensaje("Bebida mas pedida: " + 
                         resumen.getBebidaMasVendida());
             break;
            case 4:
                 EntradaYSalida.mostrarMensaje("Camarero que atendio mas pedido: " + 
                         resumen.getCamareroConMasPedido());
             break;
         }
       
       } while(!(opcion == 5));
       
   } 
  

 }
    

   

