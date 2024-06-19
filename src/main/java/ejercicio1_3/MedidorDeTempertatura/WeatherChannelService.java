package ejercicio1_3.MedidorDeTempertatura;

import java.util.Random;

public class WeatherChannelService implements ClimaOnline {
    @Override
    public int temperatura() {
        int temp = new Random().nextInt(30);
        return temp;
    }
}

