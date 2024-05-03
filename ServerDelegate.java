import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class ServerDelegate extends Thread {
    private Socket clientSocket;

    private static final String PADDING = "AES/ECB/PKCS5Padding";

    public ServerDelegate(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            // Traer mensaje 

            
            //Traer clave simetrica

            Simetrica simetrica = new Simetrica();

            System.out.println("Se genero las llaves");
            
            //String cifrado =  simetrica.getClaveCifrado();
            //String autentica = simetrica.getClaveAutenticacion();

         
            

            
            //Traer mensaje
            


            
            // Comunicacion con el cliente


            //Paso 2 C(K_w-, Reto   )
          //  cifrar (claveCifrado, "holaa");


                            
        
        
        
        
        
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


    	public static byte[] cifrar(SecretKey llave, String texto) {
		byte[] textoCifrado;
		
		try {
			Cipher cifrador = Cipher.getInstance(PADDING);
			byte[] textoClaro = texto.getBytes();
			
			cifrador.init(Cipher.ENCRYPT_MODE, llave);
			textoCifrado = cifrador.doFinal(textoClaro);
			
			return textoCifrado;
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}
}
