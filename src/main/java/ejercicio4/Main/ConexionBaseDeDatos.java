package ejercicio4.Main;

import java.sql.DriverManager;

public class ConexionBaseDeDatos {


    private final String username;
    private final String pwd;
    private String conn;



    public ConexionBaseDeDatos(String conn, String username, String pwd) {
        this.conn = conn;
        this.username = username;
        this.pwd = pwd;
    }



    public void inicializar() {
        try (var connection = DriverManager.getConnection(conn, username, pwd)) {
            var stmt = connection.createStatement();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
