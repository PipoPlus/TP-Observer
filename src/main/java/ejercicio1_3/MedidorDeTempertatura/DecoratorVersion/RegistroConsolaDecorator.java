package ejercicio1_3.MedidorDeTempertatura.DecoratorVersion;


import ejercicio1_3.MedidorDeTempertatura.Observer;

public class RegistroConsolaDecorator extends ObserverDecorator{

    public RegistroConsolaDecorator(Observer observer) {
        super(observer);
    }

    @Override
    public void update(int temperatura) {
        super.update(temperatura);

        if (temperatura < 12){
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (temperatura > 17){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }
}
