package ejercicio5;

import javax.swing.*;
import java.awt.*;

public class PantallaGerente extends JFrame implements VentaObserver {
    private JLabel labelMonto;

    public PantallaGerente() {
        setTitle("Pantalla del Gerente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelMonto = new JLabel("Monto facturado: $0.0");
        labelMonto.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelMonto);
        setVisible(true);
    }

    @Override
    public void update(double monto) {
        labelMonto.setText("Monto facturado: $" + monto);
        if (monto > 300000) {
            labelMonto.setForeground(Color.RED);
        } else {
            labelMonto.setForeground(Color.BLACK);
        }
    }
}

