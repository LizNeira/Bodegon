package bodegon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Resumen implements Serializable
{
    private static ArrayList<String> listaBebida;
    private static ArrayList<String> listaPreparacion;
    private static ArrayList<String> listaCodigoCamarero;
    private static ArrayList<Double> listaPrecioPedido;
    private static Resumen instancia;

    private Resumen()
    {}
    
    public static Resumen getInstancia()
    {
      if(null == instancia)
      {
        instancia = new Resumen();
        listaBebida = new ArrayList<>();
        listaPreparacion = new ArrayList<>();
        listaCodigoCamarero = new ArrayList<>();
        listaPrecioPedido = new ArrayList<>();
      }
        
        return instancia; 
    }
   

    public String getBebidaMasVendida() 
    {
        HashMap<String, Integer> mapa = new HashMap<>();
        String bebidaMasVendida = ""; 
        Integer mayor = 0;
        
        for (int i = 0; i < listaBebida.size(); i++)
        {
            String nombreBebida = listaBebida.get(i);        
            
            if (mapa.containsKey(nombreBebida)) 
                mapa.put(nombreBebida, mapa.get(nombreBebida) + 1);
            
            else 
             mapa.put(nombreBebida, 1);
        }
        
        for (HashMap.Entry<String, Integer> entry : mapa.entrySet()) 
        {
            if (entry.getValue() > mayor) 
            {
              mayor = entry.getValue();
              bebidaMasVendida = entry.getKey();
            }
        }
     
         return bebidaMasVendida;
    }

    public void setNombreBebida(String nombreBebida)
    {
        listaBebida.add(nombreBebida);
    }

    public String getPreparacionMasVendida() 
    {
        HashMap<String, Integer> mapa = new HashMap<>();
        String prepracionMasVendida = ""; 
        Integer mayor = 0;
        
        for (int i = 0; i < listaPreparacion.size(); i++)
        {
            String nombrePrepracion = listaPreparacion.get(i);
        
            if (mapa.containsKey(nombrePrepracion)) 
                mapa.put(nombrePrepracion, mapa.get(nombrePrepracion) + 1);
            
            else 
             mapa.put(nombrePrepracion, 1);
        }
              
        for (HashMap.Entry<String, Integer> entry : mapa.entrySet()) 
        {
            if (entry.getValue() > mayor) 
            {
              mayor = entry.getValue();
              prepracionMasVendida = entry.getKey();
            }
        }

        return prepracionMasVendida;
    }

    public void setNombrePreparacion(String nombrePreparacion)
    {
        listaPreparacion.add(nombrePreparacion);
    }

    public String getCamareroConMasPedido() 
    {
        HashMap<String, Integer> mapa = new HashMap<>();
        String codigoMasRepetido = ""; 
        Integer mayor = 0;
        
        for (int i = 0; i < listaCodigoCamarero.size(); i++)
        {
            String codigo = listaCodigoCamarero.get(i);
        
            if (mapa.containsKey(codigo)) 
                mapa.put(codigo, mapa.get(codigo) + 1);
            
            else 
             mapa.put(codigo, 1);
        }
              
        for (HashMap.Entry<String, Integer> entry : mapa.entrySet()) 
        {
            if (entry.getValue() > mayor) 
            {
              mayor = entry.getValue();
              codigoMasRepetido = entry.getKey();
            }
        }

        return codigoMasRepetido;
    }

    public void setCodigoCamarero(String codigoCamarero) 
    {
        listaCodigoCamarero.add(codigoCamarero);
    }

    // <editor-fold defaultstate="collapsed" desc="Your Fold Comment">
    public Double getPrecioTotal() 
    {
        Double precioTotal = 0.0;
        
        precioTotal = listaPrecioPedido.stream().map((d) -> d).reduce(
                    precioTotal, (accumulator, _item) -> accumulator + _item);
        
        return precioTotal;
    }
    // </editor-fold>
    public void setPrecioTotal(Double precioPedido)
    {
        this.listaPrecioPedido.add(precioPedido);
    }
    
}
