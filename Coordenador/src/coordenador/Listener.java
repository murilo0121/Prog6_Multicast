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
        
        ServerSocket portListener=port;


        while (true) {

            Socket socketCliente = null;
            DataInputStream in = null;
            String recebidoCliente="nada";

            try {

                System.out.println("aguradando");
                socketCliente = port.accept();
                
                in = new DataInputStream(socketCliente.getInputStream());
                recebidoCliente = in.readUTF();

            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(" o Cliente: " + recebidoCliente.trim() + " esta conectado");
        }
        
    }

}
