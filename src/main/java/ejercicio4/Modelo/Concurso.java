package ejercicio4.Modelo;


import ejercicio1_3.MedidorDeTempertatura.Observer;

import java.util.ArrayList;
import java.util.List;

public class Concurso {

    RegistroInscripcion registro;
    List<ObserverConcurso> observers = new ArrayList<>();

    public Concurso (RegistroInscripcion registro){
        this.registro = registro;
    }


    public void inscribirParicipante(Participante participante){
        registro.registrarInscripcion(participante.nombre,participante.region,participante.telefono);
        notifyAllObservers(participante.nombre);
    }

    public void addObserver(ObserverConcurso observer){
        this.observers.add(observer);
    }

    private void notifyAllObservers(String nombreParticipante){
        for (ObserverConcurso observer : observers){
            observer.update(nombreParticipante);
        }
    }

}
