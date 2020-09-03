
package bodegon;

import java.io.Serializable;


public class Bebida implements Serializable
{
  private String descripcion;


    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public static Bebida obtenerBebida()
    {
        return new Bebida();
    }
    
}
