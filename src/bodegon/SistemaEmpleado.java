package bodegon;

import java.util.ArrayList;

public class SistemaEmpleado
{
    private ArrayList<Empleado> listaEmpleado;

    public SistemaEmpleado() 
    {
        listaEmpleado = new ArrayList<>();
    }

    public void setlistaEmpleado(ArrayList<Empleado> listaEmpleado)
    {
        this.listaEmpleado = listaEmpleado;
    }

    public ArrayList<Empleado> getlistaEmpleado() 
    {
        return listaEmpleado;
    }
    
    public Empleado buscarEmpleado(String datos) 
    {
        int i = 0;
        boolean encontrado = false;
        Empleado empleado = null;

        while (i < listaEmpleado.size() && !encontrado) 
        {
            empleado = listaEmpleado.get(i);
            
            if (datos.equals(empleado.getUsuario() + ":" + empleado.getContrasenia())) 
            {
                encontrado = true;
            } 
            else 
            {
                i++;
            }
        }
        
        if (!encontrado)
        {
            return null;
        } 
        else 
        {
           return empleado;
        }
    }


}
