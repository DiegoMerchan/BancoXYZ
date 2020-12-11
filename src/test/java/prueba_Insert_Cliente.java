
import Client.Cliente;
import Connection.ClienteBanco;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class prueba_Insert_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Cliente cli = new Cliente();
        
        int idCliente = 123453;
        String nombre = "Diego";
        String apellido = "Merchan";
        String fecha_nacimiento = "1992-08-10";
        String genero = "M";
        String direccion = "Calle 120c # 120 - 20 bis";
        int telefono = 32125164;
        int ciudad = 1; 
       
        
        ClienteBanco clienteNuevo = new ClienteBanco(idCliente, nombre, apellido, fecha_nacimiento, genero, direccion, telefono, ciudad);
        
        System.out.println("Iniciando cliente\n");
        cli.NuevoCliente(clienteNuevo);//Se inicia el cliente
        
    }
    
}
