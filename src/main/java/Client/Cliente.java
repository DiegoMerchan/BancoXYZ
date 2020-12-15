package Client;

import Connection.ClienteBanco;
import Connection.CuentaBanco;
import Connection.Movimiento;
import Connection.SaldoCliente;
import Connection.Sconnector;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Sconnector {

    String msn;

    public Cliente() throws IOException {
        super("cliente"); // iniciamos una instancia de Socket tipo cliente
    }

    public void NuevoCliente(ClienteBanco cli) { // Con este metodo iniciamos el cliente
        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new ObjectOutputStream(cs.getOutputStream());
            entradaServidor = new ObjectInputStream(cs.getInputStream());
            System.out.println("Stream de objetos creado con exito");

            // enviamos el objeto al servidor 
            salidaServidor.writeObject("crearCliente");// indicamos tipo transaccion al servidor

            System.out.println("Tipo de transaccion enviada al servidor");

            salidaServidor.writeObject(cli);

            System.out.println("Nuevo cliente enviado al servidor");

            try {
                msn = (String) entradaServidor.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(msn);
            //Fin de la conexión
            salidaServidor.close();
            cs.close();

            System.out.println("Conexion cerrada");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void NuevaCuenta(CuentaBanco c) {

        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new ObjectOutputStream(cs.getOutputStream());
            entradaServidor = new ObjectInputStream(cs.getInputStream());
            System.out.println("Stream de objetos creado con exito");

            // enviamos el objeto al servidor 
            salidaServidor.writeObject("crearCuenta");// indicamos tipo transaccion al servidor

            System.out.println("Tipo de transaccion enviada al servidor");

            salidaServidor.writeObject(c);

            System.out.println("Nueva cuenta enviado al servidor");

            try {
                msn = (String) entradaServidor.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(msn);
            //Fin de la conexión
            salidaServidor.close();
            cs.close();

            System.out.println("Conexion cerrada");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void Consignacion(Movimiento m) {

        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new ObjectOutputStream(cs.getOutputStream());
            entradaServidor = new ObjectInputStream(cs.getInputStream());
            System.out.println("Stream de objetos creado con exito");

            // enviamos el objeto al servidor 
            salidaServidor.writeObject("consignar");// indicamos tipo transaccion al servidor

            System.out.println("Tipo de transaccion enviada al servidor");

            salidaServidor.writeObject(m);

            System.out.println("Consignacion enviada al servidor");

            try {
                msn = (String) entradaServidor.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(msn);
            //Fin de la conexión
            salidaServidor.close();
            cs.close();

            System.out.println("Conexion cerrada");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
        public void Retiro(Movimiento m) {

        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new ObjectOutputStream(cs.getOutputStream());
            entradaServidor = new ObjectInputStream(cs.getInputStream());
            System.out.println("Stream de objetos creado con exito");

            // enviamos el objeto al servidor 
            salidaServidor.writeObject("retirar");// indicamos tipo transaccion al servidor

            System.out.println("Tipo de transaccion enviada al servidor");

            salidaServidor.writeObject(m);

            System.out.println("Retiro enviado al servidor");

            try {
                msn = (String) entradaServidor.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(msn);
            //Fin de la conexión
            salidaServidor.close();
            cs.close();

            System.out.println("Conexion cerrada");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
        
    public void Saldo(SaldoCliente s) {

        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new ObjectOutputStream(cs.getOutputStream());
            entradaServidor = new ObjectInputStream(cs.getInputStream());
            System.out.println("Stream de objetos creado con exito");

            // enviamos el objeto al servidor 
            salidaServidor.writeObject("saldo");// indicamos tipo transaccion al servidor

            System.out.println("Tipo de transaccion enviada al servidor");

            salidaServidor.writeObject(s);

            System.out.println("Consulta de saldo enviada al cliente");

            try {
                msn = (String) entradaServidor.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(msn);
            //Fin de la conexión
            salidaServidor.close();
            cs.close();

            System.out.println("Conexion cerrada");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
