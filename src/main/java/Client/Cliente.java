
package Client;

import Connection.Sconnector;
import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Sconnector{
    
   public Cliente() throws IOException{
       super("cliente"); // iniciamos una instancia de Socket tipo cliente
   } 
   
   public void startCliente(){ // Con este metodo iniciamos el cliente
       try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
            }

            cs.close();//Fin de la conexión

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
   }
}
