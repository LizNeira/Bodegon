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

    public void setPedidosCocinar(ArrayList<Pedido> listaPedidoCocinar) 
    {
        this.listaPedidoCocinar = listaPedidoCocinar;
    }

    public ArrayList<Pedido> getPedidosCocinar() 
    {
        return listaPedidoCocinar;
    }

   
}
