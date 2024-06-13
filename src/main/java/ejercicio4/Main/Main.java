package ejercicio4.Main;

import ejercicio4.Modelo.Concurso;
import ejercicio4.Modelo.EnvioMailObserver;
import ejercicio4.Persistencia.InscripcionSQL;
import ejercicio4.UI.AgregarParticipante;

import java.awt.*;


public class Main {

    public static final String URL = "jdbc:mysql://localhost:3306/concurso";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        //inicializarDatabase();
        lanzarAplicacion();
    }

    private static void lanzarAplicacion() {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   InscripcionSQL registroInscripciones =
                           new InscripcionSQL(URL, USER, PASSWORD);
                   Concurso concurso = new Concurso(registroInscripciones);

                   EnvioMailObserver envioMailObserver = new EnvioMailObserver();
                   concurso.addObserver(envioMailObserver);

                   new AgregarParticipante(concurso);
               } catch (Exception e) {
                   System.out.println(e);
               }
           }

       })
    ;}

    private static void inicializarDatabase() {
        var jdbc = new ConexionBaseDeDatos(URL, USER, PASSWORD);
        jdbc.inicializar();
    }




}