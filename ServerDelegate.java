import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;


public class ServerDelegate extends Thread {
    private Socket clientSocket;

    public ServerDelegate(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            //Traer clave simetrica

            Simetrica simetrica = new Simetrica();
            simetrica.generarClaves();
            
            BigInteger cifrado =  simetrica.getClaveCifrado();
            BigInteger autentica = simetrica.getClaveAutenticacion();
            
            // Comunicacion con el cliente


            //Paso 2 C(K_w-, Reto   )
        
                
        
        
        
        
        
        
        
        
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
