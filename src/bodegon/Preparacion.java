package bodegon;

import java.io.Serializable;

public class Preparacion implements Serializable
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

    public static Preparacion obtenerPreparacion()
    {
        return new Preparacion();
    }

}
