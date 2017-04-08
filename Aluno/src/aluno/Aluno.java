package aluno;

import java.io.DataOutputStream;
import static java.lang.Math.random;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author murilo.erhardt
 */
public class Aluno {

    public static void main(String[] args) {
        String group = "228.5.6.7";
        Random random = new Random();
        int userId = random.nextInt(10000);

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
                int porta = Integer.parseInt(data);
                Socket clientSocket = new Socket("localhost", porta);
                String msgIDUsuario = Integer.toString(userId);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                outToServer.writeUTF(msgIDUsuario);

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

}
