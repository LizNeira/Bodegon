
package bodegon;

import java.io.Serializable;


public class Preparacion implements Serializable
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
    
    public static Preparacion obtenerPreparacion()
    {
        return new Preparacion();
    }

}
