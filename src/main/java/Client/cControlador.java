package Client;

import Connection.ClienteBanco;
import java.io.IOException;
import java.util.Scanner;

public class cControlador {

    static Scanner entrada = new Scanner(System.in);
    private static int n;

    public static void main(String[] args) throws IOException {

        // Desplegar menu para el usuario
        do {

            cControlador.menu();
            System.out.println("");
            n = cControlador.entrada.nextInt();

            switch (n) {
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

        } while (n < 6);

    }

    // metodo para desplegar menu
    public static void menu() {
        System.out.println("BIENVENIDO BANCO XYZ\n");
        System.out.println("1. Crear cliente.");
        System.out.println("2. Actualizar datos.");
        System.out.println("3. Abrir cuenta.");
        System.out.println("4. Cerrar cuenta.");
        System.out.println("5. Hacer consignacion.");
        System.out.println("6. Hacer retiro");
        System.out.println("7. Salir \n");

    }

    // Metodo para crear un nuevo cliente
    public static void crearCliente() throws IOException {

        Cliente cli = new Cliente(); //Se crea el Socket cliente

        // pedimos por consola los datos del nuevo cliente
        System.out.println("Por favor digite el ID del cliente:\n");
        int idCliente = entrada.nextInt();
        System.out.println("Por favor digite el Nombre del cliente:\n");
        String nombre = entrada.next();
        System.out.println("Por favor digite el Apellido del cliente:\n");
        String apellido = entrada.next();
        System.out.println("Por favor digite la fecha de nacimiento del cliente:\n");
        String fecha_nacimiento = entrada.next();
        System.out.println("Por favor digite el género:\n");
        String genero = entrada.next();
        System.out.println("Por favor digite la direccion del clinte:\n");
        String direccion = entrada.nextLine();
        System.out.println("Por favor digite numero de telefono del cliente:\n");
        int telefono = entrada.nextInt();
        System.out.println("Por favor digite la ciudad del cliente:\n");
        int ciudad = entrada.nextInt();
        System.out.println("Por favor digite la contraseña a asignar:\n");
        String password = entrada.next();

        // Se crea una nueva instancia de cliente del banco 
        ClienteBanco clienteNuevo = new ClienteBanco(idCliente, nombre, apellido, fecha_nacimiento, genero, direccion, telefono, ciudad, password);

        System.out.println("Iniciando cliente\n");
        cli.NuevoCliente(clienteNuevo);//Se inicia el cliente

    }

}
