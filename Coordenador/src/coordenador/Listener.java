/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordenador;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muriloerhardt
 */
public class Listener implements Runnable {

    private static ServerSocket port;

    public Listener(ServerSocket port) {

        this.port = port;

    }

    @Override
    public void run() {
        Integer timeout=10000;
        ServerSocket portListener=port;
        try {
            portListener.setSoTimeout(10000);
        } catch (SocketException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {

            Socket socketCliente = null;
            DataInputStream in = null;
            String recebidoCliente="esperando pedido para ficar ";
            
            try {

                socketCliente = port.accept();
                portListener.setSoTimeout(5000);
                timeout=5;
                in = new DataInputStream(socketCliente.getInputStream());
                recebidoCliente = in.readUTF();

            } catch (IOException ex) {
                System.out.println("\n\n\n\n\n\nTime Out " + timeout + " segundos");
                try {
                    portListener.setSoTimeout(10000);
                    timeout=10;
                } catch (SocketException ex1) {
                    Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

            System.out.println("-----> Cliente Id: " + recebidoCliente.trim() + " conectado");
        }
        
    }

}
