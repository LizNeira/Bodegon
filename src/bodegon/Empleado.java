package bodegon;

import java.io.Serializable;

public abstract class Empleado implements Serializable
{
    private String usuario;
    private String contrasenia;
    private String codigo;

    public String getContrasenia() 
    {
        return contrasenia;
    }

    public void setContrasenia(String password)
    {
        this.contrasenia = password;
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    //TODO: Leave comments temporarily, to avoid errors in other classes. Thanks!!
    //public abstract boolean ejecutarSistema(Sistema sistemaBurger);
 
}
