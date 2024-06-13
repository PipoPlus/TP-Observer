package ejercicio4.Modelo;

public class EnvioMailObserver implements ObserverConcurso {

    @Override
    public void update(String nombreParticipante) {
        System.out.println("Se envio el email a " + nombreParticipante);
    }
}
