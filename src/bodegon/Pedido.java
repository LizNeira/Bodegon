package bodegon;

import java.io.Serializable;

public class Pedido implements Serializable
{
    private Bebida bebida; 
    private Preparacion preparacion;
    private int numeroMesa;

    public Pedido()
    {
    }

    
    public  Pedido(Preparacion preparacion, Bebida bebida, int numeroMesa)
    {
       this.bebida = bebida;
       this.preparacion = preparacion;
       this.numeroMesa = numeroMesa;
    }

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

    public int getNumeroMesa()
    {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa)
    {
        this.numeroMesa = numeroMesa;
    }
    


}
