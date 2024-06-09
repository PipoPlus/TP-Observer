package org.example.DecoratorVersion;

import org.example.Observer;

public class RegistroConsolaDecorator extends ObserverDecorator{

    public RegistroConsolaDecorator(Observer observer) {
        super(observer);
    }

    @Override
    public void update(String temperatura) {
        super.update(temperatura);

        int temp = Integer.parseInt(temperatura);
        if (temp < 12){
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (temp > 17){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }
}
