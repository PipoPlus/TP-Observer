package ejercicio1_3.MedidorDeTempertatura;

public class RegistroEnConsolaObserver implements Observer{

    @Override
    public void update(int temperatura) {
        if (temperatura < 12){
            System.out.println("Hace frio, se encenderá la caldera");
            System.out.println(temperatura + "°C");
        } else if (temperatura > 17){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
            System.out.println(temperatura + "°C");
        }
    }


}
