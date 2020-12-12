
import Client.Cliente;
import Connection.Movimiento;
import java.io.IOException;


public class prueba_Insert_Consignacion {

    public static void main(String[] args) throws IOException {
        Cliente cli = new Cliente();
        
        
        String fecha = "2020-12-01";
        String concepto ="test consignacion";
        double valor = 300;
        int tipo = 1;
        int cuenta = 900;
        int idCliente = 123456;
        Movimiento m = new Movimiento(fecha, concepto, valor, tipo, cuenta, idCliente);
        System.out.println("Haciendo consignacion...\n");
        cli.Consignacion(m);//Se inicia el cliente
        
    }
    
}
