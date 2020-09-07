package bodegon;

import java.io.Serializable;

   public class Bebida implements Serializable
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

    public static Bebida obtenerBebida()
    {
        return new Bebida();
    }
}
