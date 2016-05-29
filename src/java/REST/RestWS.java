/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

// Plain old Java Object it does not extend as class or implements 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.GET;
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
@Path("/carro/{id}/function/{funcao}")
public class RestWS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCarro(@PathParam("id") Integer id, @PathParam("funcao") String funcao) {

        String retorno = null;
        
        switch (funcao) {
            case "getTodos":
                retorno = getTodos();
                return retorno;
                
            case "getById":
                retorno = getById(id);
                return retorno;
        }

        return null;
    }

 

}
