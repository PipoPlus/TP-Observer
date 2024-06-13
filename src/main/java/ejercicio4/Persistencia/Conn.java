package ejercicio4.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    private final String username;
    private final String pwd;
    private String conn;

    public Conn(String conn, String username, String pwd) {
        this.conn = conn;
        this.username = username;
        this.pwd = pwd;
    }


    Connection open() {
        try {
            return DriverManager.getConnection(this.conn, username, pwd);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
