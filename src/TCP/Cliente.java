/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import Entidades.Carro;
import Entidades.EnviaDados;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        int porta = 2006;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        String host = new String("localhost");
        System.out.println("Digite o IP: ");
        try {
            host = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String msg = new String();
        EnviaDados enviaDados = null;
        EnviaDados enviaDadosVolta = null;
        Integer opcao;
        Socket s = null;
        Carro carro = null;
        List<Carro> lista = null;
        

        try {
            s = new Socket(host, porta);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectOutputStream vai = null;
        try {
            vai = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectInputStream vem = null;
        try {
            vem = new ObjectInputStream(s.getInputStream());
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
            } catch (Exception ex) {
                System.out.println("Insira a operacao");
                continue;
                //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                opcao = Integer.parseInt(msg);
            } catch (Exception ex) {
                System.out.println("Insira a operacao");
                continue;
            }

            if (opcao > 7 || opcao < 1) {
                System.out.println("Opção invalida");
                continue;
            }

            if (opcao > 0 && opcao < 8) {
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
                        System.out.println("Dados invalidos, tente novamente");
                        continue;
                    }
                } else if (msg.equals("4")) {
                    System.out.println("Digite o código do carro a deletar: ");
                    try {
                        Integer cod = Integer.parseInt(reader.readLine());
                        carro = new Carro(cod);
                    } catch (Exception ex) {
                        System.out.println("Digite um codigo valido");
                        continue;
                        //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

                    }
                } else if (msg.equals("2")) {
                    System.out.println("Digite o código do carro a consultar: ");
                    try {
                        Integer cod = Integer.parseInt(reader.readLine());
                        carro = new Carro(cod);
                    } catch (Exception ex) {
                        System.out.println("Digite um codigo valido");
                        continue;
                        //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (msg.equals("5")) {
                    try {
                        System.out.println("Digite o modelo: ");
                        String modelo = reader.readLine();
                        System.out.println("Digite o ano: ");
                        Integer ano = Integer.parseInt(reader.readLine());
                        carro = new Carro(modelo, ano);
                    } catch (Exception ex) {
                        System.out.println("Dados Invalidos");
                        continue;
                        //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                enviaDados = new EnviaDados(opcao, carro);
                try {
                    vai.writeObject(enviaDados);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    vai.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Enviou mensagem");
            }

            if (opcao > 0 && opcao < 7) {
                try {
                    enviaDadosVolta = (EnviaDados) vem.readObject();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (opcao != 7)//Se der erro em alguma operaçao, nao retornara nenhum valor
            {
                if (enviaDadosVolta.getOperacao() != null) {
                    System.out.println(enviaDadosVolta.getMsg());
                    continue;
                }
            }

            if (opcao > 0 && opcao < 5) {
                if (msg.equals("2")) {
                    System.out.println(enviaDadosVolta.getCarro().getCodigo() + " - "
                            + enviaDadosVolta.getCarro().getMarca() + " - "
                            + enviaDadosVolta.getCarro().getModelo() + " - "
                            + enviaDadosVolta.getCarro().getAno() + " - "
                            + enviaDadosVolta.getCarro().getCarga() + " - "
                            + enviaDadosVolta.getCarro().getPotencia() + " - "
                            + enviaDadosVolta.getCarro().getComplemento());
                } else {
                    System.out.println(enviaDadosVolta.getMsg());
                }
            }
            if (msg.equals("5") || msg.equals("6")) {
                for (Carro car : enviaDadosVolta.getListaCarro()) {
                    System.out.println(car.getCodigo() + " - "
                            + car.getMarca() + " - "
                            + car.getModelo() + " - "
                            + car.getAno() + " - "
                            + car.getCarga() + " - "
                            + car.getPotencia() + " - "
                            + car.getComplemento());
                }
            }
            if (msg.equals("7")) {
                try {
                    s.close();
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
