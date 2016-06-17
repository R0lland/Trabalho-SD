/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

// Plain old Java Object it does not extend as class or implements 
import BD.OperacoesBD;
import Entidades.Carro;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

// an interface
// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 
// The browser requests per default the HTML MIME type.
//Sets the path to base URL + /hello
@Path("/carro")
public class RestWS {

    public TwitterFactory carregaTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("FFBLXqPDuWNWsMafY1u3e2VqC")
                .setOAuthConsumerSecret("wO721YIf8ckSH6BjHrLg5t2IiVTE0QCkJYLfssmMF2OqrE5Ckj")
                .setOAuthAccessToken("740316272257343488-GEd5ZsFGLOuEN1PHZZYBuHrZiXG4v7B")
                .setOAuthAccessTokenSecret("hvLeKHes6xak5CUGyNdwJcF6hmurGqcp4IOYJPr2MxXeI");
        TwitterFactory tf = new TwitterFactory(cb.build());

        return tf;
    }

    public String getDataAtual() {

        GregorianCalendar calendar = new GregorianCalendar();
        Integer dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        Integer mes = calendar.get(GregorianCalendar.MONTH);
        mes = mes + 1;
        Integer ano = calendar.get(GregorianCalendar.YEAR);
        Integer hora = calendar.get(GregorianCalendar.HOUR);
        Integer minuto = calendar.get(GregorianCalendar.MINUTE);
        Integer segundo = calendar.get(GregorianCalendar.SECOND);

        String msg = (dia.toString() + mes.toString() + ano.toString() + hora.toString() + minuto.toString() + segundo.toString());

        return msg;

    }

    public String getDataLog() {
        GregorianCalendar calendar = new GregorianCalendar();
        String dia = String.valueOf(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        String mes = String.valueOf((calendar.get(GregorianCalendar.MONTH)) + 1);
        String ano = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        String hora = String.valueOf(calendar.get(GregorianCalendar.HOUR));
        String minuto = String.valueOf(calendar.get(GregorianCalendar.MINUTE));
        String segundo = String.valueOf(calendar.get(GregorianCalendar.SECOND));

        if (Integer.parseInt(dia) < 10) {
            dia = "0" + dia;
        }

        if (Integer.parseInt(mes) < 10) {
            mes = "0" + mes;
        }

        if (Integer.parseInt(hora) < 10) {
            hora = "0" + hora;
        }

        if (Integer.parseInt(minuto) < 10) {
            minuto = "0" + minuto;
        }

        if (Integer.parseInt(segundo) < 10) {
            segundo = "0" + segundo;
        }

        String retorno = dia + "/" + mes + "/" + ano + " " + hora + ":" + minuto + ":" + segundo;

        return retorno;

    }

    public void log(String msg) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\upf\\Documents\\log.txt", true);
        BufferedWriter log = new BufferedWriter(fw);
        log.write(getDataLog() + " - " + msg);
        log.newLine();
        log.close();
    }

    @Path("/inserirCarro")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String inserirCarro(String json) throws SQLException, TwitterException {

        Gson gson = new Gson();

        Carro car = gson.fromJson(json, Carro.class);

        if (car.getComplemento().equals("")) {
            car.setComplemento(null);
        }

        //percorrer pra ver se o código já existe  
        Character flag = jaExiste(car.getCodigo());
        //---------------------------------------------------------------------------------

        if (flag == 's') {

            try {
                log("Erro na inserção: Código " + car.getCodigo() + " já existente na base de dados.");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return "existe";
        } else {
            try {
                OperacoesBD.adicionaCarro(car);
                Twitter twitter = carregaTwitter().getInstance();
                twitter.updateStatus("Msg " + getDataAtual() + " - Novo carro adicionado à base: " + car.getMarca() + " - " + car.getModelo());

                try {
                    log("Carro (Marca: " + car.getMarca() + " - Modelo: " + car.getModelo() + ") inserido com sucesso na base de dados.");
                } catch (Exception e) {
                    System.out.println("Não foi possível logar. Erro: " + e);
                }

                return "OK";
            } catch (SQLException ex) {
                try {
                    log("Erro na inserção do carro na base de dados: "+ex);
                } catch (Exception e) {
                    System.out.println("Não foi possível logar. Erro: " + e);
                }
                return "Error";
            }
        }

    }

    @Path("/getTodos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTodos() throws SQLException {

        List<Carro> lista = new ArrayList();
        lista = OperacoesBD.listaCarro();

        String retorno = new Gson().toJson(lista);

        try {
            log("Pegou todos os carros na função getTodos()");
        } catch (Exception e) {
            System.out.println("Não foi possível logar. Erro: " + e);
        }

        return retorno;

    }

    @Path("/consultaCodigo/{valor}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultaPor(@PathParam("valor") String valor) throws SQLException {
        try {
            Carro car = OperacoesBD.consultaCarro(Integer.parseInt(valor));

            try {
                log("Carro de código " + valor + " consultado na base de dados");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return new Gson().toJson(car);

        } catch (Exception ex) {

            String retorno = "existe";

            try {
                log("Carro de código " + valor + " não encontrado na base de dados");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return new Gson().toJson(retorno);

        }

    }

    @Path("/alterarCarro/{codigo}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String alterarCarro(@PathParam("codigo") Integer codigo, String data) throws SQLException, TwitterException {

        Carro car = new Gson().fromJson(data, Carro.class);
        car.setCodigo(codigo);

        try {
            OperacoesBD.alteraCarro(car);
            Twitter twitter = carregaTwitter().getInstance();
            twitter.updateStatus("Msg " + getDataAtual() + " - Carro de código: " + car.getCodigo() + " alterado na base de dados");

            try {
                log("Carro de código " + car.getCodigo() + " alterado na base de dados.");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return "OK";
        } catch (SQLException ex) {

            try {
                log("Não foi possível alterar o carro de código " + car.getCodigo() + " na base de dados.");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return "Error";
        }
    }

    @Path("/excluirCarro/{codigo}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String excluirCarro(@PathParam("codigo") Integer codigo) throws SQLException, TwitterException {

        Character flag = jaExiste(codigo);
        if (flag == 'n') {

            try {
                log("Carro de código " + codigo + " não encontrado para exclusão da base de dados.");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return "existe";

        } else {
            Carro car = new Carro();

            car.setCodigo(codigo);

            try {
                OperacoesBD.deletaCarro(car);

                Twitter twitter = carregaTwitter().getInstance();
                twitter.updateStatus("Msg " + getDataAtual() + " - Carro de código: " + car.getCodigo() + " excluído da base de dados");

                try {
                    log("Carro de código " + car.getCodigo() + " excluído da base de dados.");
                } catch (Exception e) {
                    System.out.println("Não foi possível logar. Erro: " + e);
                }

                return "OK";
            } catch (SQLException ex) {

                try {
                    log("Não foi possível excluir o carro de código " + car.getCodigo() + " da base de dados.");
                } catch (Exception e) {
                    System.out.println("Não foi possível logar. Erro: " + e);
                }

                return "Error";
            }
        }

    }

    public Character jaExiste(Integer codigo) throws SQLException {
        Character flag = 'n';

        Type listType = new TypeToken<ArrayList<Carro>>() {
        }.getType();

        List<Carro> todosCarros = (List<Carro>) new Gson().fromJson(getTodos(), listType);

        Iterator it = todosCarros.iterator();

        while (it.hasNext()) {
            Carro carIt = (Carro) it.next();

            if (Objects.equals(codigo, carIt.getCodigo())) {
                flag = 's';
            }
        }

        return flag;
    }

    @Path("/listarAnoModelo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String listarAnoModelo(String json) throws SQLException {

        Carro car = new Gson().fromJson(json, Carro.class);

        Integer ano = car.getAno();
        String modelo = car.getModelo();

        List<Carro> lista = OperacoesBD.listaAnoModeloRest(ano, modelo);

        System.out.println("SIZE: " + lista.size());

        if (lista.isEmpty()) {

            try {
                log("Não foram encontrados resultados para a busca com os parâmetros: Ano - " + ano + " e Modelo - " + modelo + " na base de dados");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            String retorno = "existe";
            return new Gson().toJson(retorno);
        } else {

            try {
                log("Consulta por Ano (" + ano + ") e Modelo (" + modelo + ") executada com sucesso");
            } catch (Exception e) {
                System.out.println("Não foi possível logar. Erro: " + e);
            }

            return new Gson().toJson(lista);
        }

    }
}
