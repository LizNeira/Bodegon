
package bodegon;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controlador
{
    public void ejecutar() {

        Sistema sistema = new Sistema();
        String usuario,contrasenia, codigo;
        boolean seguir;

        try 
        {
           sistema = sistema.deSerializar("sistema.txt");
           seguir = EntradaYSalida.leerBoolean("SISTEMA BODEGÓN \nDesea ingresar [s/n]");
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
            
            try 
            {
               sistema.serializar("sistema.txt");
               EntradaYSalida.mostrarMensaje("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } 
            catch (IOException ex) 
            {
               Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            seguir = false;     
            EntradaYSalida.mostrarMensaje(e.getMessage());

        }
        
        while (seguir)
        {
            codigo = EntradaYSalida.leerCadena("¡¡BIENVENIDO!!"
                    + "Ingrese su código de acceso único:");
            while (codigo.isEmpty())
            {
                EntradaYSalida.leerCadena("ERROR: El código no puede ser nulo"
                        + "Ingrese su código:");
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

}
