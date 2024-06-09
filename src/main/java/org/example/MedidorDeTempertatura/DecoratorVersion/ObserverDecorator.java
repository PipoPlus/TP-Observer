package org.example.DecoratorVersion;

import org.example.Observer;

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
