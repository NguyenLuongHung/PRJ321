/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpsdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

/**
 *
 * @author Admin
 */
public class JSK {

    public static void main(String[] agrs) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, null);

            keyStore.store(new FileOutputStream("test.jks"), "passphrase".toCharArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("test.jks"), "passphrase".toCharArray());

            CertAndKeyGen gen = new CertAndKeyGen("RSA", "SHA1WithRSA");
            gen.generate(1024);

            Key key = gen.getPrivateKey();
            X509Certificate cert = gen.getSelfCertificate(new X500Name("CN=ROOT"), (long) 365 * 24 * 3600);

            X509Certificate[] chain = new X509Certificate[1];
            chain[0] = cert;

            keyStore.setKeyEntry("mykey", key, "passphrase".toCharArray(), chain);

            keyStore.store(new FileOutputStream("test.jks"), "passphrase".toCharArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("test.jks"), "passphrase".toCharArray());

            CertAndKeyGen gen = new CertAndKeyGen("RSA", "SHA1WithRSA");
            gen.generate(1024);

            X509Certificate cert = gen.getSelfCertificate(new X500Name("CN=SINGLE_CERTIFICATE"), (long) 365 * 24 * 3600);

            keyStore.setCertificateEntry("single_cert", cert);

            keyStore.store(new FileOutputStream("test.jks"), "passphrase".toCharArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
