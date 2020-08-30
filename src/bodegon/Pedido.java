package bodegon;

import java.io.Serializable;

public class Pedido implements Serializable
{
    private Bebida bebida; 
    private Preparacion preparacion;
    private String numeroMesa;

    public Bebida getBebida() 
    {
        return bebida;
    }

    public void setBebida(Bebida bebida)
    {
        this.bebida = bebida;
    }

    public Preparacion getPreparacion() 
    {
        return preparacion;
    }

    public void setPreparacion(Preparacion preparacion) 
    {
        this.preparacion = preparacion;
    }
    
    public String getNumeroMesa()
    {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa)
    {
        this.numeroMesa = numeroMesa;
    }

}
