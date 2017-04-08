package coordenador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 *
 * @author murilo.erhardt
 */
public class Coordenador {

    public static void main(String[] args) throws IOException {
        String group = "228.5.6.7";
        Integer port = 5865;
        Integer portCoord = 7385;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.setProperty("java.net.preferIPv4Stack", "true");

        ServerSocket serverSocket = new ServerSocket(portCoord);

        Thread thread = new Thread(new Listener(serverSocket));
        thread.start();
        

        while (true) {
            try {
                System.out.println("\n\n\n\n\nEnter para pedir novamente");
                String next = reader.readLine();

                byte[] b = portCoord.toString().getBytes();
                InetAddress addr = InetAddress.getByName("228.5.6.7");
                DatagramSocket ds = new DatagramSocket();
                DatagramPacket pkg = new DatagramPacket(b, b.length, addr, port);
                ds.send(pkg);
                

            } catch (Exception e) {
                System.out.println("Nao foi possivel enviar a mensagem");
            }
        }

    }

}
