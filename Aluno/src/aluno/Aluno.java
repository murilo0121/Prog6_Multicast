package aluno;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author murilo.erhardt
 */
public class Aluno {

    public static void main(String[] args) {
        while (true) {
            try {
                MulticastSocket mcs = new MulticastSocket(12347);
                InetAddress grp = InetAddress.getByName("239.0.0.1");
                mcs.joinGroup(grp);
                byte rec[] = new byte[256];
                DatagramPacket pkg = new DatagramPacket(rec, rec.length);
                mcs.receive(pkg);
                String data = new String(pkg.getData());
                System.out.println("Dados recebidos:" + data);
                
                
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

}
