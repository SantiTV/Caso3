import java.math.BigInteger;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;


public class Simetrica {

    private BigInteger claveCifrado;
    private BigInteger claveAutenticacion;

    public Simetrica() {
        generarClaves();
    }

    public void generarClaves() {
        try {

            BigInteger p = new BigInteger("00cdfbc25c3409dc5e2c195380628450d45e4da1fd10dde441bd475f729410c588206abb" +
        "a5aee2dbaf90436d53a76590f5ae278d19abb" +
        "c70828a90f2c18151a5b751e77358dba3b3864fed15c554db5d1bdb6ee9a82a4ed2e901388139e1f10e15491cbb40f0f135b7a22b4b011ae537c37dc2f3d59f23b32a3c57f36d223ef9a7", 16);


            BigInteger g = new BigInteger("2");


            // Calcular llave maestra con Diffie-Hellman
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
            javax.crypto.spec.DHParameterSpec dhSpec = new javax.crypto.spec.DHParameterSpec(p, g, 1024);

            keyPairGenerator.initialize(dhSpec);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Obtener la clave pública generada
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();

            // Calcular digest con SHA-512
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] masterKey = digest.digest(publicKeyBytes);

            // Dividir el digest para generar las claves de cifrado y autenticación
            byte[] encryptionKey = new byte[32];
            byte[] authenticationKey = new byte[32];
            System.arraycopy(masterKey, 0, encryptionKey, 0, 32);
            System.arraycopy(masterKey, 32, authenticationKey, 0, 32);

            // Imprimir las claves generadas

            claveCifrado = new BigInteger(bytesToHex(encryptionKey));
            claveAutenticacion = new BigInteger(bytesToHex(authenticationKey));
    
            System.out.println("Clave para cifrado: " + bytesToHex(encryptionKey));
            System.out.println("Clave para autenticación: " + bytesToHex(authenticationKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        // Método para obtener la clave de cifrado
        public BigInteger getClaveCifrado() {
            return claveCifrado;
        }
    
        // Método para obtener la clave de autenticación
        public BigInteger getClaveAutenticacion() {
            return claveAutenticacion;
        }

    // Método para convertir bytes a representación hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }


}
