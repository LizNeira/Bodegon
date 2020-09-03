package bodegon;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaPedido implements Serializable
{
    private ArrayList<Pedido> listaPedidoCocinar;
    
    public SistemaPedido()
    {
       listaPedidoCocinar = new ArrayList<>();
    }

    public void setListaPedidoCocinar(ArrayList<Pedido> listaPedidoCocinar) 
    {
        this.listaPedidoCocinar = listaPedidoCocinar;
    }

    public ArrayList<Pedido> getListaPedidoCocinar() 
    {
        return this.listaPedidoCocinar;
    }

    public void setPedido(Preparacion preparacion, String descripcion,
                          Bebida bebida, String nombreBebida, int numeroMesa)
    {
        preparacion.setDescripcion(descripcion);
        bebida.setDescripcion(descripcion);
        this.listaPedidoCocinar.add(new Pedido(preparacion, bebida, numeroMesa));
    }
   
    public void mostrarListaPedidoCocinar()
    {
        for (int i = 0; i < listaPedidoCocinar.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje((i+1)
                    +"- "+listaPedidoCocinar.get(i).getBebida().getDescripcion()
                    +" "+listaPedidoCocinar.get(i).getPreparacion().getDescripcion()/*+" "+p.getNumeroMesa()*/);

        }
        
    }
}
