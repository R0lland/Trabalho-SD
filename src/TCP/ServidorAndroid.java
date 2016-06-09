/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import BD.OperacoesBD;
import java.io.IOException;
import Entidades.Carro;
import Entidades.EnviaDados;
import com.sun.org.apache.bcel.internal.Constants;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorAndroid {

 
    public static void main(String[] args) {
        int porta = 4444;
        Carro carro = null;
        
        String sVem = null;
        String sVai = null;
        
        String resposta;

        System.out.println("Servidor Executando");
        ServerSocket ss = null;//cria o socket do servidor
        try {
            ss = new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        Socket s = null;//cria socket para comunicaçao do cliente. cada vez que um cliente comunica cria novo socket.
        try {
            s = ss.accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Conexão iniciada com o cliente "
                    + s.getInetAddress().getHostAddress() + ":" + s.getPort());

        ObjectInputStream vem = null;//objeto que vai receber do cliente
        try {
            vem = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectOutputStream vai = null;//objeto q vai mandar para o servidor
        try {
            vai = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            System.out.println("Aguardando Operacao ...");
            
            //ler o objeto que vira do cliente
            try {
                sVem = (String) vem.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("veio do cliente: " + sVem);
            String[] parts = sVem.split(":");
            
            carro = new Carro(Integer.parseInt(parts[0]), parts[1], parts[2],
                    Integer.parseInt(parts[3]), Float.parseFloat(parts[4]),
                    Float.parseFloat(parts[5]), "Adicionado pelo android");
            
            try {
                OperacoesBD.adicionaCarro(carro);
                System.out.println("Inseriu");
                resposta = new String("Adicionou");
                //System.out.println(sVem);
            } catch (SQLException ex) {
                resposta = new String("Codigo ja existente");
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            try {
                vai.writeObject(resposta);
            } catch (IOException ex) {
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                vai.flush();
            } catch (IOException ex) {
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                s.close();
                break;
            } catch (IOException ex) {
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}