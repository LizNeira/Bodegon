
package bodegon;

import java.io.IOException;
import java.io.Serializable;

public class Controlador implements Serializable
{
    Sistema sistema = null;
    GuardarYLeerArchivo guardarYLeerArchivo = null;
    private String usuario = "";
    private String contrasenia = "";
    private String codigo = "";
    
    public void ejecutar() throws IOException  {

       sistema = new Sistema();
       guardarYLeerArchivo =new GuardarYLeerArchivo();
       boolean seguir;

        try 
        {
           sistema = guardarYLeerArchivo.deSerializar();
           seguir = EntradaYSalida.leerBoolean("SISTEMA BODEGÓN \nDesea ingresar [s/n]: ");
        } 
        catch (IOException | ClassNotFoundException e)
        {
            usuario = EntradaYSalida.leerCadena("Arranque inicial del sistema.\n"
                    + "Nuevo Administrador, Ingrese su nombre: ");
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
                        + "+Ingrese su código:");
            }
            
            sistema.getSistemaEmpleado().getlistaEmpleado().add(new Administrador(usuario, contrasenia, codigo));
            guardarYLeerArchivo.guardarArchivo(sistema);
            EntradaYSalida.mostrarMensaje("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            seguir = false;     
        }
        
        while (seguir)
        {
            codigo = EntradaYSalida.leerCadena("\n¡¡BIENVENIDO!!\n"
                    + "Ingrese su código de acceso único: ");
            
            while (codigo.isEmpty())
            {
                EntradaYSalida.leerCadena("ERROR: El código no puede ser nulo"
                        + "Ingrese su código: ");
            }

            Empleado empleado = sistema.getSistemaEmpleado().buscarEmpleado(codigo);

            if (null == empleado)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El código de acceso único ingresado no es valido.");    
            } 
            else
            {
               seguir = empleado.menuPrincipal(sistema);
            }
        }

    }
    
    public String getCodigo()
    {
        return codigo;
    }

}
