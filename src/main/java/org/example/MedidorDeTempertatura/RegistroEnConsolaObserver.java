package org.example.MedidorDeTempertatura;

public class RegistroEnConsolaObserver implements Observer{

    @Override
    public void update(String temperatura) {
        int temp = Integer.parseInt(temperatura);

        if (temp < 12){
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (temp > 17){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }


}
