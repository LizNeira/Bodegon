package bodegon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Resumen implements Serializable
{
    private final  ArrayList<String> listaBebida;
    private final  ArrayList<String> listaPreparacion;
    private final  ArrayList<Integer> listaCodigoCamarero;
    private final  ArrayList<Double> listaPrecioPedido; 
    
    public Resumen()
    {
      listaBebida = new ArrayList<>();
      listaPreparacion = new ArrayList<>();
      listaCodigoCamarero = new ArrayList<>();
      listaPrecioPedido = new ArrayList<>();
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
        this.listaBebida.add(nombreBebida);
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
        this.listaPreparacion.add(nombrePreparacion);
    }

    public Integer getCamareroConMasPedido() 
    {
        HashMap<Integer, Integer> mapa = new HashMap<>();
        Integer codigoMasRepetido = 0; 
        Integer mayor = 0;
        
        for (int i = 0; i < listaCodigoCamarero.size(); i++)
        {
            int codigo = listaCodigoCamarero.get(i);
        
            if (mapa.containsKey(codigo)) 
                mapa.put(codigo, mapa.get(codigo) + 1);
            
            else 
             mapa.put(codigo, 1);
        }
              
        for (HashMap.Entry<Integer, Integer> entry : mapa.entrySet()) 
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
        this.listaCodigoCamarero.add(Integer.valueOf(codigoCamarero));
    }

    public Double getPrecioTotal() 
    {
        Double precioTotal = 0.0;
        
        precioTotal = listaPrecioPedido.stream().map((d) -> d).reduce(
                    precioTotal, (accumulator, _item) -> accumulator + _item);
        
        return precioTotal;
    }

    public void setPrecioTotal(Double precioPedido)
    {
        this.listaPrecioPedido.add(precioPedido);
    }
    
}
