package bodegon;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaPedido implements Serializable
{
    private ArrayList<Pedido> listaPedidoCocinar;
    private ArrayList<Pedido> listaPedidoEntregado;
    
    public SistemaPedido()
    {
       listaPedidoCocinar = new ArrayList<>();
       listaPedidoEntregado = new ArrayList<>();
    }

    public void setListaPedidoCocinar(ArrayList<Pedido> listaPedidoCocinar) 
    {
        this.listaPedidoCocinar = listaPedidoCocinar;
    }

    public ArrayList<Pedido> getListaPedidoCocinar() 
    {
        return this.listaPedidoCocinar;
    }

    public ArrayList<Pedido> getListaPedidoEntregado()
    {
        return listaPedidoEntregado;
    }

    public void setListaPedidoEntregado(ArrayList<Pedido> listaPedidoEntregado)
    {
        this.listaPedidoEntregado = listaPedidoEntregado;
    }
    
    

    public void setPedido(Preparacion preparacion, String descripcion,
                          Bebida bebida, String nombreBebida)
    {
        preparacion.setDescripcion(descripcion);
        bebida.setDescripcion(descripcion);
        this.listaPedidoCocinar.add(new Pedido(preparacion, bebida));
    }
   
    public void mostrarListaPedidoCocinar()
    {
        for (int i = 0; i < listaPedidoCocinar.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(+i+1)+"] "
                    +"||Preparaciones: "+listaPedidoCocinar.get(i).getPreparacion().getDescripcion()/*+" "+p.getNumeroMesa()*/
                    +"||Bebida: "+listaPedidoCocinar.get(i).getBebida().getDescripcion());
        }
        
    }
    
    public void precioPedido(int indiceProducto) 
    {
        
      this.listaPedidoCocinar.get(indiceProducto);
          
    }

}
