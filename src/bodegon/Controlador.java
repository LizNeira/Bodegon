
package bodegon;


public class Controlador
{
    public void ejecutar() {

        Sistema sistema = new Sistema();
        String usuario,contrasenia;
        int codigo;
        boolean seguir;

        try 
        {
             sistema = sistema.deSerializar("sistema.txt");
             seguir = EntradaYSalida.leerBoolean("SISTEMA BODEGÓN \nDesea ingresar? responda si o no");
        } 
        catch (Exception e)
        {
            usuario = EntradaYSalida.leerCadena("Arranque inicial del sistema.\n"
                    + "Nuevo Administrador, Ingrese su nombre: ");
            while (usuario.isEmpty())
            {
                usuario = EntradaYSalida.leerCadena("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
            }
            
            codigo = EntradaYSalida.leerEntero("Ingrese su código de acceso único: ");
            while (Integer.toString(codigo).isEmpty())
            {
                codigo = EntradaYSalida.leerEntero("ERROR: El código no puede ser nulo"
                        + "+Ingrese su código:");
            }
            
            contrasenia = EntradaYSalida.leerCadena("Ingrese su contraseña: ");
            while (contrasenia.isEmpty())
            {
                contrasenia = EntradaYSalida.leerCadena("ERROR: La contraseña no puede ser nula"
                        + "+Ingrese su contraseña:");
            }
            
            sistema.getUsuarios().add(new Administrador(usuario, codigo, contrasenia));
            sistema.serializar("sistema.txt");
            EntradaYSalida.mostrarMensaje("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            
            seguir = false;
            EntradaYSalida.mostrarMensaje(e.getMessage());

        }
         while (seguir)
         {
            codigo = EntradaYSalida.leerEntero("¡¡BIENVENIDO!!"
                    + "Ingrese su código de acceso único:");
            while (Integer.toString(codigo).isEmpty())
            {
                EntradaYSalida.leerEntero("ERROR: El código no puede ser nulo"
                        + "Ingrese su código:");
            }

            Empleado empleado = sistema.getSistemaEmpleado().buscarEmpleado(codigo);

            if (empleado.equals(empleado))
            {
                seguir = empleado.ejecutarSistema(sistema);
            } 
            else
            {
             EntradaYSalida.mostrarMensaje("ERROR: El código de acceso único ingresado no es valido.");
            }
        }

    }

}
