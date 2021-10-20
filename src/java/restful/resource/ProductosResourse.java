package restful.resource;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import restful.model.ProductosModel;
import restful.service.ProductosService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 *
 * @author odpinerosh
 */

@Path("productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProductosResourse {
    ProductosService prod_serv = new ProductosService();
    
    @GET
    public ArrayList<ProductosModel> getProductos() {
        return prod_serv.getProductos();
    }
    
    @Path("/{Id_Producto}")
    @GET
    public ProductosModel getProducto(@PathParam("Id_Producto") int id) {
        return prod_serv.getProducto(id);
    }
    
    @POST
    public ProductosModel addProducto(String JSON) {
        //Líneas estandar para crear el archivo JSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        //Hasta aquí.
        ProductosModel producto = gson.fromJson(JSON, ProductosModel.class);
        return prod_serv.addProducto(producto);
    }
    
    @PUT
    public ProductosModel updateProducto(String JSON) {
        //Líneas estandar para crear el archivo JSON
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        //Hasta aquí.
        ProductosModel producto = gson.fromJson(JSON, ProductosModel.class);
        return prod_serv.updateProducto(producto);
    }
    
    @DELETE
    @Path("/{Id_Producto}")
    public String delProducto(@PathParam("Id_Producto") int id) {
        return prod_serv.delProducto(id);
    }
    
    
}
