package bodegon;

import java.io.Serializable;

public abstract class Empleado implements Serializable
{
    private final String usuario;
    private final String contrasenia;
    private final String codigo;

    public Empleado(String usuario, String contrasenia, String codigo)
    {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.codigo = codigo;
    }
    
    public String getContrasenia() 
    {
       return contrasenia;
    }

    public String getUsuario() 
    {
       return usuario;
    }

    public String getCodigo() 
    {
       return codigo;
    }

    public abstract boolean menuPrincipal(Sistema sistema);
 
}
