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
                          Bebida bebida, String nombreBebida, int numeroMesa)
    {
        preparacion.setDescripcion(descripcion);
        bebida.setDescripcion(nombreBebida);
        this.listaPedidoCocinar.add(new Pedido(preparacion, bebida,numeroMesa));
    }
   
    public void mostrarListaPedidoCocinar()
    {
        for (int i = 0; i < listaPedidoCocinar.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(+i+1)+"] "
                    +"||Preparaciones: "+listaPedidoCocinar.get(i).getPreparacion().getDescripcion()
                    +"||Bebida: "+listaPedidoCocinar.get(i).getBebida().getDescripcion()
                    +"||Numero de mesa: "+listaPedidoCocinar.get(i).getNumeroMesa());
        }
        
    }
    
    public void mostrarListaPedidoEntregado()
    {
        int i=0;
        for( Pedido pedido: listaPedidoEntregado)
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(+i+1)+"] "
                                  +"||precio: " +pedido.getPreparacion().getDescripcion()
                                  +"||Bebida: " + pedido.getBebida().getDescripcion()
                                  +"||Numero de mesa: "+listaPedidoCocinar.get(i).getNumeroMesa());
            i++;
        }
            
    }
    public void precioPedido(int indiceProducto) 
    {
        
      this.listaPedidoCocinar.get(indiceProducto -1);
          
    }

}
