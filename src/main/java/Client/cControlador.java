
package Client;

import Connection.ClienteBanco;
import java.io.IOException;
import java.util.Scanner;

public class cControlador {
    
     static Scanner entrada = new Scanner(System.in);
     private static int n;

   
    public static void main(String[] args) throws IOException {
        
        // Desplegar menu para el usuario
        
        do{

            cControlador.menu();
            System.out.println("");
            n = cControlador.entrada.nextInt();
    
    
            switch(n){
                case 1:
                    cControlador.crearCliente();
                    break;
                case 2:

                    break; 
                 case 3:

                    break; 
                 case 4: 
                    break;
                 case 5:

            }       
       
        }while(n<6);
        
               
        
    }
    
       // metodo para desplegar menu
       public static void menu(){
       System.out.println("BIENVENIDO BANCO XYZ\n");
       System.out.println("1. Crear cliente.");
       System.out.println("2. Actualizar datos.");
       System.out.println("3. Abrir cuenta.");
       System.out.println("4. Cerrar cuenta.");
       System.out.println("5. Hacer consignacion.");
       System.out.println("6. Hacer retiro");
       System.out.println("7.Salir \n");
      
   }
       
       // Metodo para crear un nuevo cliente
       
       public static void crearCliente() throws IOException{
           
            //Cliente de prueba

        int idCliente = 123456;
        String nombre = "Diego";
        String apellido = "Merchan";
        String fecha_nacimiento = "10-10-1990";
        String genero = "M";
        String direccion = "Calle 123 # 05-50";
        int telefono = 123456;
        int ciudad = 1;   
        ClienteBanco clientePrueba = new ClienteBanco(idCliente, nombre, apellido, fecha_nacimiento, genero, direccion, telefono, ciudad);
        
        
         
        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        cli.NuevoCliente(clientePrueba);//Se inicia el cliente 
           
       }
    
}
