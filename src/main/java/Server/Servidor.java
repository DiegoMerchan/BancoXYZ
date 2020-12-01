
package Server;

import Connection.ClienteBanco;
import Connection.Sconnector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Servidor extends Sconnector {
    
   public Servidor() throws IOException{
       super("servidor"); // iniciamos una instancia de Socket tipo servidor
   } 
   
  public void startServer() throws ClassNotFoundException{ // Con este metodo iniciamos el server
      try
        {
            System.out.println("Esperando conexión en puerto " + ss.getLocalPort()); //Esperando conexión
            
            

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            
            System.out.println("Cliente en línea");      
            
            ObjectInputStream inObjeto = new ObjectInputStream(cs.getInputStream());
 
            //Se muestra por pantalla el mensaje recibido
            
            ClienteBanco nuevoCliente =  (ClienteBanco) inObjeto.readObject();
            System.out.println("Recibido en el servidor un nuevo cliente: " + nuevoCliente.getNombre());
            

            System.out.println("Fin de la conexión");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
      
  }
}
