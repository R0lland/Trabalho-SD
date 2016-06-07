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
import java.lang.reflect.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// an interface
// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 
// The browser requests per default the HTML MIME type.
//Sets the path to base URL + /hello
@Path("/carro")
public class RestWS {

    @Path("/inserirCarro")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String inserirCarro(String json) throws SQLException {

        Gson gson = new Gson();

        Carro car = gson.fromJson(json, Carro.class);

        if (car.getComplemento().equals("")) {
            car.setComplemento(null);
        }

        //percorrer pra ver se o código já existe  
        Character flag = jaExiste(car.getCodigo());
        //---------------------------------------------------------------------------------

        if (flag == 's') {
            return "existe";
        } else {
            try {
                OperacoesBD.adicionaCarro(car);
                return "OK";
            } catch (SQLException ex) {
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

        return retorno;

    }

    @Path("/consultaCodigo/{valor}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultaPor(@PathParam("valor") String valor) throws SQLException {

        try {
            Carro car = OperacoesBD.consultaCarro(Integer.parseInt(valor));
            return new Gson().toJson(car);
        } catch (Exception ex) {

            String retorno = "existe";

            return new Gson().toJson(retorno);

        }

    }

    @Path("/alterarCarro/{codigo}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String alterarCarro(@PathParam("codigo") Integer codigo, String data) throws SQLException {

        Carro car = new Gson().fromJson(data, Carro.class);
        car.setCodigo(codigo);

        try {
            OperacoesBD.alteraCarro(car);

            return "OK";
        } catch (SQLException ex) {

            return "Error";
        }
    }

    @Path("/excluirCarro/{codigo}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String excluirCarro(@PathParam("codigo") Integer codigo) throws SQLException {

        Character flag = jaExiste(codigo);
        if (flag == 'n') {
            return "existe";
        } else {
            Carro car = new Carro();

            car.setCodigo(codigo);

            try {
                OperacoesBD.deletaCarro(car);
                return "OK";
            } catch (SQLException ex) {
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
            String retorno = "existe";
            return new Gson().toJson(retorno);
        } else {
            return new Gson().toJson(lista);
        }

    }
}
