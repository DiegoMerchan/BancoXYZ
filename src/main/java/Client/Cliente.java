
package Client;

import Connection.ClienteBanco;
import Connection.Sconnector;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Cliente extends Sconnector{
    
   public Cliente() throws IOException{
       super("cliente"); // iniciamos una instancia de Socket tipo cliente
   } 
   
   public void NuevoCliente(ClienteBanco cli){ // Con este metodo iniciamos el cliente
       try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new ObjectOutputStream(cs.getOutputStream());
            System.out.println("Stream de objetos creado con exito");
            
           // enviamos el objeto al servidor 
                
            salidaServidor.writeObject(cli);
            
            System.out.println("Objeto nuevo cliente enviado al servidor");                    

            cs.close();//Fin de la conexión
            
            System.out.println("Conexion cerrada");

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
   }
}
