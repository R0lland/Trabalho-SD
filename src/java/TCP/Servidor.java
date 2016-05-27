/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import BD.OperacoesBD;
import java.io.IOException;
import Entidades.Carro;
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

public class Servidor {

    //teste
    public static void main(String[] args) {
        int porta = 2010;
        Carro carro = null;
        Carro carroVem = null;
        List<Carro> listaCarro = null;
        String msg = null;

        System.out.println("Servidor Executando");
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        Socket s = null;
        try {
            s = ss.accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectInputStream vem = null;
        try {
            vem = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectOutputStream vai = null;
        try {
            vai = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            System.out.println("Aguardando Operacao ...");

            try {
                msg = (String) vem.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            Integer opcao = Integer.parseInt(msg);

            if (opcao > 0 && opcao < 6) {
                try {
                    carro = (Carro) vem.readObject();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (msg.equals("1")) {
                    try {
                        OperacoesBD.adicionaCarro(carro);
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Inseriu");

                    String msg2 = new String("Inseriu");
                    try {
                        vai.writeObject(msg2);
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        vai.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (msg.equals("2")) {
                    try {
                        carroVem = OperacoesBD.consultaCarro(carro.getCodigo());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Consultou");

                    try {
                        vai.writeObject(carroVem);
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        vai.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (msg.equals("3")) {
                    try {
                        OperacoesBD.alteraCarro(carro);
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Alterou");
                    String msg2 = new String("Alterou");
                    try {
                        vai.writeObject(msg2);
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        vai.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (msg.equals("4")) {
                    try {
                        OperacoesBD.deletaCarro(carro);
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Deletou");
                    String msg2 = new String("Deletou");
                    try {
                        vai.writeObject(msg2);
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        vai.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (msg.equals("5")) {
                    try {
                        listaCarro = OperacoesBD.listaAnoModelo(carro.getAno(), carro.getModelo());
                    } catch (SQLException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        vai.writeObject(listaCarro);
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        vai.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            if (msg.equals("6")) {
                try {
                    listaCarro = OperacoesBD.listaCarro();
                } catch (SQLException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    vai.writeObject(listaCarro);
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
                    System.out.println("Cliente encerrou a conexão");
                    s.close();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
