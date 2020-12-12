                                                              package Server;

import Connection.ClienteBanco;
import Connection.Sconnector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Servidor extends Sconnector {

    ClienteBanco nuevoCliente;
    String tipo;

    public Servidor() throws IOException {
        super("servidor"); // iniciamos una instancia de Socket tipo servidor
    }

    public void startServer() throws ClassNotFoundException { // Con este metodo iniciamos el server
        try {
            System.out.println("Esperando conexión en puerto " + ss.getLocalPort()); //Esperando conexión
            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            entradaCliente = new ObjectInputStream(cs.getInputStream()); // inicializamos socket
            salidaCliente = new ObjectOutputStream(cs.getOutputStream());
            System.out.println("Cliente en línea");
            tipo = (String) entradaCliente.readObject();
            if ("crearCliente".equals(tipo)) {
                System.out.println("Ejecutando crear cliente...\n");
                crearCliente();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void crearCliente() throws ClassNotFoundException {

        try {

            nuevoCliente = (ClienteBanco) entradaCliente.readObject();
            System.out.println("Recibido en el servidor un nuevo cliente: " + nuevoCliente.getNombre());
            OperacionesBD.InsertarCliente(nuevoCliente,salidaCliente);
           // salidaCliente.writeObject("msn desde el servidor: Cliente creado con exito");
            close();
            System.out.println("Fin de la conexión");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void close() {

        try {
            ss.close();//Se finaliza la conexión con el cliente
            entradaCliente.close();
            cs.close();
            salidaCliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
