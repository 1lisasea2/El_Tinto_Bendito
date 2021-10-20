package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.model.ProductosModel;
import restful.model.ConexionBD;
import javax.swing.JOptionPane;


/**
 *
 * @author odpinerosh
 */
public class ProductosService {
        public ArrayList<ProductosModel> getProductos() {
        ArrayList<ProductosModel> lista = new ArrayList<>();
        ConexionBD conn = new ConexionBD();
        
        String sql = "SELECT * FROM productos";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                //Crear un objeto de la clase Productos
                ProductosModel productos = new ProductosModel();
                System.out.println(rs.getInt("id_prod"));
                productos.setId_prod(rs.getInt("id_prod"));
                productos.setNombre_prod(rs.getString("nombre_prod"));
                productos.setDesc_prod(rs.getString("desc_prod"));
                productos.setId_categoria(rs.getInt("id_categoria"));
                productos.setUrl_img_prod(rs.getString("url_img_prod"));
                productos.setPrecio_prod(rs.getFloat("precio_prod"));
                productos.setDisp_prod(rs.getString("disp_prod"));
                productos.setEstado_prod(rs.getString("estado_prod"));
                //Agrgar objeto al arreglo de objetos
                lista.add(productos);
                
            }
        } catch (SQLException exception) {
            System.out.println("Se presentó un error: " + exception.getMessage());
            return null;
        }
        if (lista.isEmpty()) {
            System.out.println("La tabla está vacía");
        } 
        
        
        return lista;
    }
    
     
     public ProductosModel getProducto(int id) {
         
        ProductosModel producto = new ProductosModel();

        ConexionBD conex = new ConexionBD();
        String Sql = "SELECT * FROM productos WHERE id_prod = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                producto.setId_prod(rs.getInt("id_prod"));
                producto.setNombre_prod(rs.getString("nombre_prod"));
                producto.setDesc_prod(rs.getString("desc_prod"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                producto.setUrl_img_prod(rs.getString("url_img_prod"));
                producto.setPrecio_prod(rs.getFloat("precio_prod"));
                producto.setDisp_prod(rs.getString("disp_prod"));
                producto.setEstado_prod(rs.getString("estado_prod"));
                
            }
        } catch (SQLException exception) {
            System.out.println("Se presentó un error: " + exception.getMessage());
        }

        return producto;
    }

    public ProductosModel addProducto(ProductosModel producto) {
        ConexionBD conex = new ConexionBD();
        String Sql = "INSERT INTO productos (nombre_prod, desc_prod, id_categoria, url_img_prod, precio_prod, disp_prod, estado_prod) ";
        Sql = Sql + "values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            
            pstm.setString(1, producto.getNombre_prod());
            pstm.setString(2, producto.getDesc_prod());
            pstm.setInt(3, producto.getId_categoria());
            pstm.setString(4, producto.getUrl_img_prod());
            pstm.setFloat(5, producto.getPrecio_prod());
            pstm.setString(6, producto.getDisp_prod());
            pstm.setString(7, producto.getEstado_prod());
            
            pstm.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Se presentó un error: " + exception.getMessage());
            return null;
        }
        return producto;
    }
    
    public ProductosModel updateProducto(ProductosModel producto) {
        ConexionBD conn = new ConexionBD();
        String sql = "UPDATE productos SET nombre_prod=?, desc_prod=?, id_categoria=?, url_img_prod=?, precio_prod=?, disp_prod=?, estado_prod=? ";
        sql = sql + "WHERE id_prod= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, producto.getNombre_prod());
            pstm.setString(2, producto.getDesc_prod());
            pstm.setInt(3, producto.getId_categoria());
            pstm.setString(4, producto.getUrl_img_prod());
            pstm.setFloat(5, producto.getPrecio_prod());
            pstm.setString(6, producto.getDisp_prod());
            pstm.setString(7, producto.getEstado_prod());
            pstm.setInt(8, producto.getId_prod());
           
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al modificar  " + excepcion.getMessage());
            return null;
        }
        return producto;
    }
    
    public String delProducto(int id) {
        ConexionBD conn = new ConexionBD();

        String sql = "DELETE FROM productos WHERE id_prod = ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
}
