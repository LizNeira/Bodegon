
package bodegon;

import java.io.Serializable;


public class Bebida implements Serializable
{
  private String descripcion;
  private Double precio;


    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio)
    {
        this.precio = precio;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public Double getPrecio()
    {
        return precio;
    }
    
    public static Bebida obtenerBebida()
    {
        return new Bebida();
    }
    
}
