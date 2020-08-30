package bodegon;

import java.io.*;

public class Sistema  implements Serializable
{
    private SistemaEmpleado sistemaEmpleado;
    private SistemaPedido sistemaPedido;
 
    public Sistema()
    {
        sistemaEmpleado = new SistemaEmpleado();
        sistemaPedido = new SistemaPedido();
    }

    public SistemaEmpleado getSistemaEmpleado()
    {
        return sistemaEmpleado;
    }

    public void setSistemaEmpleado(SistemaEmpleado sistemaEmpleado) 
    {
        this.sistemaEmpleado = sistemaEmpleado;
    }
    
    public SistemaPedido getSistemaPedido() 
    {
        return sistemaPedido;
    }

    public void setSistemaPedido(SistemaPedido sistemaPedido) 
    {
        this.sistemaPedido = sistemaPedido;
    }

    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException
    {
        Sistema sistema;
        try (FileInputStream f = new FileInputStream(a); 
            ObjectInputStream o = new ObjectInputStream(f)) 
            {
                sistema = (Sistema) o.readObject();
               o.close();
               f.close();
            }
        
        return sistema;
    }

    public void serializar(String a) throws IOException
    {
        try (FileOutputStream f = new FileOutputStream(a, true); 
             ObjectOutputStream o = new ObjectOutputStream(f)) 
            {
                o.writeObject(this);
                o.close();
                f.close();
            }
    }


}
