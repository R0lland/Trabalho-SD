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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public String inserirCarro(String json) {

        Gson gson = new Gson();

        Carro car = gson.fromJson(json, Carro.class);

        if(car.getComplemento().equals("")){
            car.setComplemento(null);
        }
        
        try {
            OperacoesBD.adicionaCarro(car);
            return "OK";
        } catch (SQLException ex) {
            return "Error";
        }

        

    }

    @Path("/getTodos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTodos() throws SQLException {

        List<Carro> lista = new ArrayList();
        lista = OperacoesBD.listaCarro();

        Carro car = new Carro();

        String retorno = new Gson().toJson(lista);

        System.out.println("retorno: "+retorno);
        return retorno;

    }

}
