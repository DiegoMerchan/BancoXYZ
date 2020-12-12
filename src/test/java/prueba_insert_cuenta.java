
import Client.Cliente;
import Connection.CuentaBanco;
import java.io.IOException;


public class prueba_insert_cuenta {

  
    public static void main(String[] args) throws IOException {
 
        Cliente cli = new Cliente();    
        int num = 900;
        double saldo = 100;
        int idCliente = 123456;
        String contra = "abcd";
        CuentaBanco c = new CuentaBanco(num,saldo,idCliente,contra);
        System.out.println("Creando cuenta..\n");
        cli.NuevaCuenta(c);//Se inicia el cliente

    }
    
}
