package ejercicio1_3.MedidorDeTempertatura;

import java.util.ArrayList;
import java.util.List;

public class Medidor {
    private List<Observer> observers = new ArrayList<>();
    private int temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public void leerTemperatura() {
        //leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        notifyAllObservers();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    private void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update(temperatura);
        }
    }

}
