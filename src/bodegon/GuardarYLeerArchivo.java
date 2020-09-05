package bodegon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GuardarYLeerArchivo implements Serializable
{
    private final String nombreArchivo;
    
    public GuardarYLeerArchivo()
    {
        this.nombreArchivo = "sistema.txt";
    }
    
    public Sistema deSerializar() throws IOException, ClassNotFoundException 
    {
        Sistema sistema;
        
        try (FileInputStream f = new FileInputStream(this.nombreArchivo); 
                                 ObjectInputStream o = new ObjectInputStream(f))
        {
            sistema = (Sistema) o.readObject();
        }
        return sistema;
     }

    public void serializar(Sistema sistema) throws IOException 
    {
        try (FileOutputStream f = new FileOutputStream(this.nombreArchivo); 
                                  ObjectOutputStream o = new ObjectOutputStream(f)) 
        {
            o.writeObject(sistema);
        }
     }
    
    public void guardarArchivo(Sistema sistema)
    {
          try 
          {
             this.serializar(sistema);
          } catch (IOException e)
            {
               e.getMessage();
            }
    }
    
}
