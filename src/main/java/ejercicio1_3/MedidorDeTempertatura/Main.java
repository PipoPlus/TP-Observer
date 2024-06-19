package ejercicio1_3.MedidorDeTempertatura;


public class Main {
    public static void main(String[] args) {

        WeatherChannelService service = new WeatherChannelService();
        Medidor medicion = new Medidor(service);

        var registroTemperatura = new RegistroDeTemperaturaObserver("test.txt");
        var registroConsola = new RegistroEnConsolaObserver();

        medicion.addObserver(registroTemperatura);
        medicion.addObserver(registroConsola);

        medicion.leerTemperatura();


    }
}