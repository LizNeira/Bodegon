
package bodegon;

import java.io.Serializable;


public class Preparacion implements Serializable
{
   private String descripcion;
   private double precio;

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public static Preparacion obtenerPreparacion()
    {
        return new Preparacion();
    }


}
