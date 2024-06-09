package org.example.DecoratorVersion;

import org.example.Observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RegistroTemperaturasDecorator extends ObserverDecorator{

    String filePath;

    public RegistroTemperaturasDecorator(Observer observer, String filePath) {
        super(observer);
        this.filePath = filePath;
    }

    @Override
    public void update(String temperatura) {
        super.update(temperatura);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(LocalDateTime.now() + " - " + temperatura + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
