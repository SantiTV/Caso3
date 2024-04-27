import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MainServer {
    public static void main(String[] args) {
        try {
            // Crear un ServerSocket que escuche en un puerto específico
            ServerSocket serverSocket = new ServerSocket(12345);
            
            System.out.println("Servidor esperando conexiones...");
            
            while (true) {
                // Esperar a que un cliente se conecte
                Socket clientSocket = serverSocket.accept();
                
                // Crear un nuevo delegado del servidor para manejar la conexión con este cliente
                ServerDelegate delegate = new ServerDelegate(clientSocket);
                delegate.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
