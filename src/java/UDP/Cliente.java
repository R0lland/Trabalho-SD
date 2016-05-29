/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import Entidades.Carro;
import Entidades.EnviaDados;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) throws Exception{
        byte buf[];
        String host = "localhost";
        int port = 2010;
        InetAddress enderecoServidor = InetAddress.getByName(host);
        DatagramSocket soc = new DatagramSocket();
        DatagramPacket pct = null;
        
        //String msg = new String();
        EnviaDados enviaDados;
        Integer opcao;
        Carro carro;
        List<Carro> lista = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            //opcao = null;
            System.out.println("Operações: ");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar Ano e Modelo");
            System.out.println("6 - Listar Carros");
            System.out.println("7 - Encerrar Conexão");
            
            try {
                opcao = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Operação inválida!");
                continue;
            }
            
            if (opcao > 7 || opcao < 1) {
                System.out.println("Operação inválida!");
                continue;
            }
            
            carro = new Carro();
            
            switch (opcao) {
                case 1:
                case 3:
                    try {
                        System.out.println("Digite o código: ");
                        carro.setCodigo(Integer.parseInt(reader.readLine()));
                        
                        System.out.println("Digite a marca: ");
                        carro.setMarca(reader.readLine());
                        
                        System.out.println("Digite o modelo: ");
                        carro.setModelo(reader.readLine());
                        
                        System.out.println("Digite o ano: ");
                        carro.setAno(Integer.parseInt(reader.readLine()));
                        
                        System.out.println("Digite o potencia: ");
                        carro.setPotencia(Float.parseFloat(reader.readLine()));
                        
                        System.out.println("Digite o carga: ");
                        carro.setCarga(Float.parseFloat(reader.readLine()));
                        
                        System.out.println("Digite o complemento: ");
                        carro.setComplemento(reader.readLine());
                        
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Não conseguiu criar carro");
                    }   break;
                case 4:
                    System.out.println("Digite o código do carro a deletar: ");
                    try {
                        carro.setCodigo(Integer.parseInt(reader.readLine()));
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case 2:
                    System.out.println("Digite o código do carro a consultar: ");
                    try {
                        carro.setCodigo(Integer.parseInt(reader.readLine()));
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case 5:
                    try {
                        System.out.println("Digite o modelo: ");
                        carro.setModelo(reader.readLine());
                        System.out.println("Digite o ano: ");
                        carro.setAno(Integer.parseInt(reader.readLine()));
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                default:
                    break;
            }
            
            enviaDados = new EnviaDados(opcao, carro);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(enviaDados);
            buf = baos.toByteArray();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, enderecoServidor, port);
            soc.send(packet);
            System.out.println("Enviou mensagem");
//
            
            //buf = carro.getBytes();
            //pct = new DatagramPacket(buf, buf.length, end, port);
            
            
            /*enviaDados = new EnviaDados(msg, carro);
            try {
                vai.writeObject(enviaDados);
            } catch (IOException ex) {
                Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                vai.flush();
            } catch (IOException ex) {
                Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            /*

            if (opcao > 0 && opcao < 6) {
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
                } else if (msg.equals("4")) {
                    System.out.println("Digite o código do carro a deletar: ");
                    try {
                        Integer cod = Integer.parseInt(reader.readLine());
                        carro = new Carro(cod);
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (msg.equals("2")) {
                    System.out.println("Digite o código do carro a consultar: ");
                    try {
                        Integer cod = Integer.parseInt(reader.readLine());
                        carro = new Carro(cod);
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (msg.equals("5")) {
                    try {
                        System.out.println("Digite o modelo: ");
                        String modelo = reader.readLine();
                        System.out.println("Digite o ano: ");
                        Integer ano = Integer.parseInt(reader.readLine());
                        carro = new Carro(modelo, ano);
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                enviaDados = new EnviaDados(msg, carro);
                try {
                    vai.writeObject(enviaDados);
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    vai.flush();
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Enviou mensagem");
            }

            if (opcao > 0 && opcao < 7) {
                try {
                    enviaDadosVolta = (EnviaDados) vem.readObject();
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (opcao > 0 && opcao < 5) {
                if(msg.equals("2"))
                    System.out.println(enviaDadosVolta.getCarro());
                else
                    System.out.println(enviaDadosVolta.getDados());
            }
            if (msg.equals("5") || msg.equals("6")) {
                for (Carro car : enviaDadosVolta.getListaCarro()) {
                    System.out.println(car);
                }
            }
            if (msg.equals("7")) {
                try {
                    s.close();
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
        }
        
        /*System.out.println("Cliente Iniciado");
        Scanner entrada = new Scanner (System.in);
        System.out.println("Digite o comando:");
        String msg = new String(entrada.nextLine());
        String msg2;
        
        InetAddress end = InetAddress.getByName(host);
        buf = msg.getBytes();
        DatagramSocket soc = new DatagramSocket();
        DatagramPacket pct = new DatagramPacket(buf, buf.length, end, port);
        soc.send(pct);
        System.out.println("Mensagem Enviada !!!");
        
        DatagramPacket pct2 = new DatagramPacket(buf2, buf2.length);
        soc.receive(pct2);
        msg2 = new String(pct2.getData());
        
        System.out.println("Cliente Recebeu do servidor: " + msg2);
        
        soc.close();*/
        
        
    }
}
