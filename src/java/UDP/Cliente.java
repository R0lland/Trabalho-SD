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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) throws Exception{
        byte buf[];
        byte buf2[] = new byte[1000];
        String sEnviaDados;
        String recebeDadosString;
        String host = "localhost";
        int port = 2010;
        InetAddress enderecoServidor = InetAddress.getByName(host);
        DatagramSocket soc;
        DatagramPacket pct;
        
        //String msg = new String();
        EnviaDados enviaDados;
        Integer opcao;
        Carro carro;
        List<Carro> lista = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sc;
        while (true) {
            //opcao = null;
            while (true){
                while(true){
                    System.out.println("Digite a operação:          9 para comandos");
                    Scanner scanner = new Scanner( System.in );
                    sc = scanner.nextLine();
                    opcao = Integer.parseInt(sc);
                    if (sc.equals("9"))
                        System.out.println(" 1 - Adicionar\n"
                                         + " 2 - Excluir\n"
                                         + " 3 - Alterar\n"
                                         + " 4 - Excluir\n"
                                         + " 5 - Listar Ano e Modelo\n"
                                         + " 6 - Listar Carros\n"
                                         + " 7 - Sair\n\n");
                    else break;
                }

                if (opcao < 1 || opcao > 7 ) {
                    System.out.println("\nOperação inválida!\n\n");
                }
                else break;
            }
            System.out.println(opcao);
            if (sc.equals("7")){
                System.out.println(" Fechando programa....\n");
                break;
            }
            System.out.println(opcao);
            carro = new Carro();
            
            switch (opcao) {
                case 1:                             //adicionar
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
                case 2:                             //consultar
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
                case 4:                             //excluir
                    System.out.println("Excluir");
                    System.out.println("Digite o código do carro a deletar: ");
                    try {
                        carro.setCodigo(Integer.parseInt(reader.readLine()));
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case 5:                             //listar ano e modelo
                    System.out.println("Listar Ano e Modelo");
                    try {
                        System.out.println("Digite o modelo: ");
                        carro.setModelo(reader.readLine());
                        System.out.println("Digite o ano: ");
                        carro.setAno(Integer.parseInt(reader.readLine()));
                    } catch (IOException ex) {
                        Logger.getLogger(TCP.Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case 6:                             //listar carros
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
            buf = sEnviaDados.getBytes();
            soc = new DatagramSocket();
            pct = new DatagramPacket(buf, buf.length, enderecoServidor, port);
            soc.send(pct);
            
            System.out.println("Enviou mensagem");
            
//                      receber de volta do servidor
//            DatagramPacket pct2 = new DatagramPacket(buf2, buf2.length);
//            soc.receive(pct2);
//            recebeDadosString = new String(pct2.getData());
            
            
        }
    }
}
