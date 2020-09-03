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

}
