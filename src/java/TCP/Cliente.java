/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import Entidades.Carro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        int porta = 2010;
        String host = new String("localhost");
        String msg = new String();
        String msgvolta = new String();
        Socket s = null;
        Carro carro = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
                s = new Socket(host, porta);
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        System.out.println("Cliente Executando");
        while (true) {
            System.out.println("Operações: ");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar Ano e Modelo");
            System.out.println("6 - Listar Carros");
            System.out.println("7 - Encerrar Conexão");
            try {
                msg = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (msg.equals("1") || msg.equals("3")) {
                try {
                    System.out.println("Digite o código: ");
                    Integer cod = Integer.parseInt(reader.readLine());
                    System.out.println("Digite a marca: ");
                    String marca = reader.readLine();
                    System.out.println("Digite o modelo: ");
                    String modelo = reader.readLine();
                    System.out.println("Digite o ano: ");
                    Integer ano = Integer.parseInt(reader.readLine());
                    System.out.println("Digite o potencia: ");
                    float potencia = Float.parseFloat(reader.readLine());
                    System.out.println("Digite o carga: ");
                    float carga = Float.parseFloat(reader.readLine());
                    System.out.println("Digite o complemento: ");
                    String complemento = reader.readLine();
                    carro = new Carro(cod, marca, modelo, ano, potencia, carga, complemento);
                } catch (Exception e) {
                    System.out.println("Não conseguiu criar carro");
                }
            } 
            else if (msg.equals("4")) {
                System.out.println("Digite o código do carro a deletar: ");
                try {
                    Integer cod = Integer.parseInt(reader.readLine());
                    carro = new Carro(cod);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(msg.equals("2"))
            {
                System.out.println("Digite o código do carro a consultar: ");
                 try {
                    Integer cod = Integer.parseInt(reader.readLine());
                    carro = new Carro(cod);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(msg.equals("5"))
                {                
                 try {
                    System.out.println("Digite o modelo: ");
                    String modelo = reader.readLine();
                    System.out.println("Digite o ano: ");
                    Integer ano = Integer.parseInt(reader.readLine());
                    carro = new Carro(modelo, ano);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(!msg.equals("6") || !msg.equals("7"))
            {
                System.out.println("Digite uma opção valida");
            }
            
            ObjectOutputStream vai = null;
            try {
                vai = new ObjectOutputStream(s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Enviou mensagem");

            try {
                vai.writeObject(carro);
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                vai.flush();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
        ObjectInputStream vem = null;
        try {
            vem = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            msgvolta = (String) vem.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Recebido do servidor: " + msgvolta);
             */

            if (msg.equals("7")) {
                try {
                    s.close();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
