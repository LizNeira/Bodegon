package bodegon;

import java.io.Serializable;

public class Pedido implements Serializable
{
    private Bebida bebida; 
    private Preparacion preparacion;
    private double precio;
    private int numeroMesa;
    
    public Pedido(Preparacion preparacion, Bebida bebida, int numeroMesa)
    {
       this.preparacion = preparacion;
       this.bebida = bebida;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    

}
