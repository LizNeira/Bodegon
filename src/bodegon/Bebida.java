
package bodegon;

import java.io.Serializable;


public class Bebida implements Serializable
{
  private String descripcion;
  private double precioUnitario;


    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio)
    {
        this.precioUnitario = precio;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public double getPrecio()
    {
        return precioUnitario;
    }
    
}
