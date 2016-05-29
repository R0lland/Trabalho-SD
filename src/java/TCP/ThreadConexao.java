/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import BD.OperacoesBD;
import Entidades.Carro;
import Entidades.EnviaDados;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadConexao extends Thread {

    Socket s;
    ObjectInputStream vem;
    ObjectOutputStream vai;
    EnviaDados enviaDados;
    EnviaDados enviaDadosVem;
    String msg;
    Carro carroVem;
    List<Carro> listaCarro;

    public ThreadConexao(Socket s, InputStream vem, OutputStream vai) {
        this.s = s;
        try {
            this.vem = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.vai = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            System.out.println("Aguardando Operacao ...");

            //ler o objeto que vira do cliente
            try {
                enviaDadosVem = (EnviaDados) vem.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            msg = enviaDadosVem.getOperacao().toString();
            Integer opcao = Integer.parseInt(msg);
            //transforma em int pra ficar mais facil de verificar. Essas opcoes sempre vao receber um carro
            if (opcao > 0 && opcao < 7) {
                if (msg.equals("1")) {
                    try {
                        OperacoesBD.adicionaCarro(enviaDadosVem.getCarro());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Inseriu");
                    enviaDados = new EnviaDados("Inseriu");
                }
                if (msg.equals("2")) {
                    try {
                        carroVem = OperacoesBD.consultaCarro(enviaDadosVem.getCarro().getCodigo());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Consultou");
                    enviaDados = new EnviaDados(carroVem);
                }
                if (msg.equals("3")) {
                    try {
                        OperacoesBD.alteraCarro(enviaDadosVem.getCarro());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Alterou");
                    enviaDados = new EnviaDados("Alterou");
                }
                if (msg.equals("4")) {
                    try {
                        OperacoesBD.deletaCarro(enviaDadosVem.getCarro());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Deletou");
                    enviaDados = new EnviaDados("Deletou");
                }
                if (msg.equals("5")) {
                    try {
                        listaCarro = OperacoesBD.listaAnoModelo(enviaDadosVem.getCarro().getAno(), enviaDadosVem.getCarro().getModelo());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    enviaDados = new EnviaDados(listaCarro);
                }
                if (msg.equals("6")) {
                    try {
                        listaCarro = OperacoesBD.listaCarro();
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    enviaDados = new EnviaDados(listaCarro);
                }

                try {
                    vai.writeObject(enviaDados);
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    vai.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (msg.equals("7")) {
                try {
                    System.out.println("Cliente " +
                            s.getInetAddress().getHostAddress() + ":" + s.getPort() + " encerrou a conexao");
                    s.close();
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
