package ejercicio1_3.MedidorDeTempertatura.DecoratorVersion;

import ejercicio1_3.MedidorDeTempertatura.Observer;

public class ObserverDecorator implements Observer {

    private Observer observer;

    public ObserverDecorator(Observer observer){
        this.observer = observer;
    }

    @Override
    public void update(int temperatura) {
        observer.update(temperatura);
    }

}
