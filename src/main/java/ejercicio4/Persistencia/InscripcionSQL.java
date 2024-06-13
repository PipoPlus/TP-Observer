package ejercicio4.Persistencia;

import ejercicio4.Modelo.RegistroInscripcion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscripcionSQL implements RegistroInscripcion {

    private Conn conn;
    public static final String SQL = "insert into participantes(nombre, telefono, region) values(?,?,?)";


    public InscripcionSQL(String url, String user, String pwd){
        this.conn = new Conn(url,user,pwd);
    }

    @Override
    public void registrarInscripcion(String nombreParticipante, String region, String numeroTelefonico) {

        System.out.println("Registrado correctamente");

    }
}
