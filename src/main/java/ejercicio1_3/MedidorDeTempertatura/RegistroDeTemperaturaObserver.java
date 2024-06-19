package ejercicio1_3.MedidorDeTempertatura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RegistroDeTemperaturaObserver implements Observer {
    private String filePath;

    public RegistroDeTemperaturaObserver(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void update(int temperatura) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(LocalDateTime.now() + " - " + temperatura + "°C" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
