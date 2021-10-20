package restful;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author danie
 */
@Path("generic")
public class resourse {

    //@Context
    //private UriInfo context;

    /**
     * Creates a new instance of resourse
     */
    //public resourse() {
    //}

    /**
     * Retrieves representation of an instance of restful.resourse
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       return "Claro, Amigos";
    }

    /**
     * PUT method for updating or creating an instance of resourse
     * @param content representation for the resource
     */
    //@PUT
    //@Consumes(MediaType.APPLICATION_XML)
    //public void putXml(String content) {
    //}
}
