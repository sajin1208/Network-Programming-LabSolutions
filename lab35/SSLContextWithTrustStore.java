package lab35;

import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.*;

public class SSLContextWithTrustStore {
    public static SSLContext createSSLContext(
            String keystorePath, String keystorePassword,
            String truststorePath, String truststorePassword
    ) throws Exception {

        // Load the KeyStore (private key + cert)
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keystorePath), keystorePassword.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, keystorePassword.toCharArray());

        // Load the TrustStore (to validate peer certs)
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream(truststorePath), truststorePassword.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(trustStore);

        // Create and initialize the SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return sslContext;
    }


    public static void main(String[] args) throws Exception {
        // Replace with your actual file paths and passwords
        SSLContext sslContext = createSSLContext(
                "mykeystore.jks", "sajinman",
                "mytruststore.jks", "sajinman"
        );

        System.out.println("SSLContext initialized with Keystore and Truststore.");
    }
}