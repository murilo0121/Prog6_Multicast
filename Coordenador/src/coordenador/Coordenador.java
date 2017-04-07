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

        try {
            byte[] b = "teste".getBytes();
            InetAddress addr = InetAddress.getByName("239.0.0.1");
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket pkg = new DatagramPacket(b, b.length, addr, 12347);
            ds.send(pkg);
        } catch (Exception e) {
            System.out.println("Nao foi possivel enviar a mensagem");
        }
        while (true) {
            
        }
    }

}
