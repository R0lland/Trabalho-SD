/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

// Plain old Java Object it does not extend as class or implements 
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
    @Produces(MediaType.TEXT_PLAIN)
    public String inserirCarro(String teste) {

        System.out.println("REST WS recebeu: "+teste);
        
        return "OK";
        
//        switch (funcao) {
//            case "getTodos":
//                retorno = getTodos();
//                return retorno;
//                
//            case "getById":
//                retorno = getById(id);
//                return retorno;
//        }

    }

}
