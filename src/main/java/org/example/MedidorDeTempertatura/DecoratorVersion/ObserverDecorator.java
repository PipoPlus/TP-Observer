package org.example.MedidorDeTempertatura.DecoratorVersion;

import org.example.MedidorDeTempertatura.Observer;

public class ObserverDecorator implements Observer {

    private Observer observer;

    public ObserverDecorator(Observer observer){
        this.observer = observer;
    }

    @Override
    public void update(String temperatura) {
        observer.update(temperatura);
    }

}
