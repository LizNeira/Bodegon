package bodegon;

import java.io.Serializable;

public class Sistema  implements Serializable
{
    private final SistemaEmpleado sistemaEmpleado;
    private final SistemaPedido sistemaPedido;

    public Sistema()
    {
        sistemaEmpleado = new SistemaEmpleado();
        sistemaPedido = new SistemaPedido();
    }

    public SistemaEmpleado getSistemaEmpleado()
    {
        return sistemaEmpleado;
    }
    
    public SistemaPedido getSistemaPedido() 
    {
        return sistemaPedido;
    }

}
