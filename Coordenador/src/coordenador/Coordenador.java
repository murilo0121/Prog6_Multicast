package coordenador;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author murilo.erhardt
 */
public class Coordenador {

    public static void main(String[] args) {
        String group = "228.5.6.7";
        Integer port=5865;
        
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            byte[] b = port.toString().getBytes();
            InetAddress addr = InetAddress.getByName("228.5.6.7");
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket pkg = new DatagramPacket(b, b.length, addr, port);
            ds.send(pkg);
        } catch (Exception e) {
            System.out.println("Nao foi possivel enviar a mensagem");
        }
        while (true) {
            
        }
    }

}
