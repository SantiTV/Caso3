import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Crear un Socket para conectarse al servidor en la dirección y puerto especificados
            Socket socket = new Socket("localhost", 12345);
            
            // Aquí continuaría la lógica para interactuar con el servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

