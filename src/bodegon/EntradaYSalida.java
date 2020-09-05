package bodegon;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

public class EntradaYSalida
{
   private static Scanner entrada = null;  

   private EntradaYSalida()
   {
       entrada = new Scanner(System.in);
   }

   public static void mostrarMensaje(String s)
   {
       System.out.print(s);
   }

   public static String leerCadena(String mensaje)
   {
       System.out.print(mensaje);
       String entrada= new Scanner(System.in).nextLine();
       return (entrada == null ? "" : entrada);
   }
   
   public static int leerEntero(String mensaje)
   {
        System.out.print(mensaje);
        return entrada.nextInt();
    }   
   
   public static Double leerDouble(String mensaje) 
   {
        System.out.print(mensaje);
        return (Double) entrada.nextDouble();
    }
   
   public static boolean leerBoolean(String texto)
   {
        System.out.print(texto);
        String entrada = new Scanner(System.in).nextLine();

       return toUpperCase(entrada.charAt(0)) == 'S';
    }

}
