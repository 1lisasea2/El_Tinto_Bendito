/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author odpinerosh
 */
public class ConexionBD {
    private Connection con;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "localhost:3306";
    private static final String DB = "tintobendito_db";
    private static final String URL = "jdbc:mysql://" + HOST + "/" + DB;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "TePasasRoot&@2021";

    /**
     *
     */
    public ConexionBD() {
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión");
        }
    }

    public Connection getCon() {
        return con;
    }

    public void desconectar() {
        try {
            if (con != null) {
                con.close();
                System.out.println("La desconexion fue exitosa");
            }

        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al desconectar  " + excepcion.getMessage());
        }
    }
}
