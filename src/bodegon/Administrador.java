
package bodegon;

import java.io.Serializable;

public class Administrador extends Empleado implements Serializable
{    
    private SistemaPedido sistemaPedido = null;

    public Administrador(String usuario, String contrasenia, String codigo)
    {
        super(usuario, contrasenia, codigo);
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
                    darPrecioPedido();
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
                EntradaYSalida.mostrarMensaje("\nSe ha incorporado el CAMARERO al sistema\n");
            }
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
  }

    private void darPrecioPedido()
    {
        double precio = 0.0;
        String opcion;
        int indicePedido;
        
        do{
        
               EntradaYSalida.mostrarMensaje("\n----Lista de pedidos----");
       //         sistemaPedido.mostrarListaPedidoCocinar();
                indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
                
                while (indicePedido < 0 || indicePedido > sistemaPedido.getListaPedidoCocinar().size())
                {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
                }
                
                precio = EntradaYSalida.leerDouble("\nIngrese el precio: ");
                while (precio<=0)
                {
                precio = EntradaYSalida.leerDouble("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
                }
 
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
    }

    private void mostrarResumenGeneral()
    {
        
    EntradaYSalida.mostrarMensaje("\n----Resumen General----");
    }
    
      
    
}
    

   

