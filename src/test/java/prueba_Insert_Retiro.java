
import Client.Cliente;
import Connection.Movimiento;
import java.io.IOException;


public class prueba_Insert_Retiro {

    public static void main(String[] args) throws IOException {
        Cliente cli = new Cliente();
        
        
        String fecha = "2020-12-01";
        String concepto ="test retiro";
        double valor = 100;
        int tipo = 2;
        int cuenta = 900;
        int idCliente = 123456;
        Movimiento m = new Movimiento(fecha, concepto, valor, tipo, cuenta, idCliente);
        System.out.println("Haciendo consignacion...\n");
        cli.Retiro(m);//Se inicia el cliente
        
    }
    
}
