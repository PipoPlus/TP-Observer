package org.example.MedidorDeTempertatura;

import java.util.ArrayList;
import java.util.List;

public class MedidorSubject {

    private List<Observer> observers = new ArrayList<>();
    private String temperatura;

    public void añadirObserver(Observer observer){
        this.observers.add(observer);
    }

    public void eliminarObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void setTemperatura(String temperatura){
        this.temperatura = temperatura;
        notifyAllObservers();
    }

    private void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update(temperatura);
        }
    }

}
