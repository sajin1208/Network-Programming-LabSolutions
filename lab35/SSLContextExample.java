package lab35;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class SSLContextExample {public static SSLContext createSSLContext() throws Exception {
        // Load the keystore (with private key and cert)
        String keystorePath = "mykeystore.jks";
        String keystorePassword = "sajinman"; // change this

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keystorePath), keystorePassword.toCharArray());

        // Create KeyManager from the keystore
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, keystorePassword.toCharArray());

        // Initialize the SSLContext with the KeyManagers
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        return sslContext;
    }

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = createSSLContext();
        System.out.println("SSLContext created using TLS with keystore.");
    }
}