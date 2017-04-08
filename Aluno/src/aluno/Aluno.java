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
        String group = "228.5.6.7";
        System.out.println("Conectou ao grupo: " + group);
        System.setProperty("java.net.preferIPv4Stack", "true");    
        while (true) {
            try {
                MulticastSocket mcs = new MulticastSocket(5865);
                InetAddress grp = InetAddress.getByName("228.5.6.7");
                mcs.joinGroup(grp);
                byte rec[] = new byte[256];
                DatagramPacket pkg = new DatagramPacket(rec, rec.length);
                mcs.receive(pkg);
                String data = new String(pkg.getData()).trim();
                System.out.println("Dados recebidos:" + data);
                
                
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

}
