
package Client;

import java.io.IOException;

public class cControlador {

   
    public static void main(String[] args) throws IOException {
         
        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        cli.startCliente(); //Se inicia el cliente        
    }
    
}
