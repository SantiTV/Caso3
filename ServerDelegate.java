import java.io.IOException;
import java.net.Socket;

public class ServerDelegate extends Thread {
    private Socket clientSocket;

    public ServerDelegate(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            // Comunicacion con el cliente

            //Paso 2 C(K_w-, Reto)
        
        
        
        
        
        
        
        
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
