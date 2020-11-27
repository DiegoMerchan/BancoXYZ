
import Client.Cliente;
import Client.ClienteBanco;
import java.io.IOException;


public class pruebasSockets {

    
    public static void main(String[] args) throws IOException {
        
    int transaccion = 1; // identifica el tipo de transaccion a realizar 1 = nuevo cliente
    int idCliente = 123456;
    String nombre = "Diego";
    String apellido = "Merchan";
    String fecha_nacimiento = "10-10-1990";
    String genero = "M";
    String direccion = "Calle 123 # 05-50";
    int telefono = 123456;
    int ciudad = 1; 
        
        ClienteBanco clientePrueba = new ClienteBanco(idCliente, nombre, apellido, fecha_nacimiento, genero, direccion, telefono, ciudad);
        
        Cliente cli = new Cliente(); //Se crea socket el cliente
        System.out.println("Iniciando cliente\n");
        cli.startCliente(); //Se inicia el cliente  
       
     
    }
    
}
