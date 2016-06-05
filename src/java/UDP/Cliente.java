/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import Entidades.Carro;
import Entidades.EnviaDados;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args){
        byte[] buf1 = new byte[1000];
        byte[] buf2 = new byte[1000];
        String sEnviaDados;
        String resposta;
        String host = "localhost";
        int port = 2010;
        InetAddress enderecoServidor = null;
        
        try {
            enderecoServidor = InetAddress.getByName(host);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DatagramSocket soc;
        DatagramPacket pct;
        
        
        EnviaDados enviaDados;
        Integer opcao;
        Carro carro;
        List<Carro> lista = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("1 - Adicionar\n"
                        + "2 - Consultar\n"
                        + "3 - Alterar\n"
                        + "4 - Excluir\n"
                        + "5 - Listar Ano e Modelo\n"
                        + "6 - Listar Carros\n");
        
        Scanner scanner = new Scanner( System.in );
            
        while(true){
            System.out.println("Digite a operação:");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("\nOperação inválida!\n");
                continue;
            }

            if (opcao < 1 || opcao > 6 ) {
                System.out.println("\nOperação inválida!\n");
                continue;
            }

            break;
        }

        carro = new Carro();

        switch (opcao) {
            case 1://adicionar
                System.out.println(" Adicionar");
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
                    System.out.println("Não conseguiu adicionar carro");
                }
                break;
            case 2://consultar
                System.out.println(" Consultar");
                System.out.println("Digite o código do carro a consultar: ");
                try {
                    carro.setCodigo(Integer.parseInt(reader.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case 3:                             //alterar
                System.out.println(" Alterar");
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
                    System.out.println("Não conseguiu alterar carro");
                }   break;
            case 4: //excluir
                System.out.println("Excluir");
                System.out.println("Digite o código do carro a deletar: ");
                try {
                    carro.setCodigo(Integer.parseInt(reader.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case 5://listar ano e modelo
                System.out.println("Listar Ano e Modelo");
                try {
                    System.out.println("Digite o modelo: ");
                    carro.setModelo(reader.readLine());
                    System.out.println("Digite o ano: ");
                    carro.setAno(Integer.parseInt(reader.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case 6://listar carros
                System.out.println("Listar Carros");
                break;
            default:
                break;
        }

        sEnviaDados = opcao + ":" +
                      carro.getCodigo() + ":" +
                      carro.getMarca() + ":" +
                      carro.getModelo() + ":" +
                      carro.getAno() + ":" +
                      carro.getPotencia() + ":" +
                      carro.getCarga() + ":" +
                      carro.getComplemento();
        System.out.println(sEnviaDados);
        buf1 = sEnviaDados.getBytes();
        
        try {
            soc = new DatagramSocket();
            pct = new DatagramPacket(buf1, buf1.length, enderecoServidor, port);
            soc.send(pct);
            System.out.println("Enviou mensagem");

            //resposta do servidor
            pct = new DatagramPacket(buf2, buf2.length);
            soc.receive(pct);
            resposta = new String(pct.getData());
            System.out.println("Cliente Recebeu do servidor:\n" + resposta + "\n");
            
            soc.close();
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
