package org.example.MedidorDeTempertatura;

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
    public void update(String temperatura) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(LocalDateTime.now() + " - " + temperatura + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
