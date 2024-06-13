package ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PantallaPedido extends JFrame {
    private Pedido pedido;
    private JComboBox<String> comboBebidas;
    private JComboBox<String> comboPlatos;
    private JTextArea areaPedido;
    private JLabel labelTotal;
    private JComboBox<String> comboTarjetas;
    private List<Bebida> listaBebidas;
    private List<PlatoPrincipal> listaPlatosPrincipales;
    private PantallaGerente pantallaGerente;

    public PantallaPedido() {
        setTitle("Realizar Pedido");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pedido = new Pedido();
        listaBebidas = inicializarBebidas();
        listaPlatosPrincipales = inicializarPlatosPrincipales();
        pantallaGerente = new PantallaGerente();

        JPanel panelNorte = new JPanel();
        comboBebidas = new JComboBox<>(listaBebidas.stream().map(Bebida::getNombre).toArray(String[]::new));
        comboPlatos = new JComboBox<>(listaPlatosPrincipales.stream().map(PlatoPrincipal::getNombre).toArray(String[]::new));
        comboTarjetas = new JComboBox<>(new String[]{"Generica", "MasterCard", "Visa"});
        JButton btnAgregarBebida = new JButton("Agregar Bebida");
        JButton btnAgregarPlato = new JButton("Agregar Plato");
        panelNorte.add(new JLabel("Bebidas:"));
        panelNorte.add(comboBebidas);
        panelNorte.add(btnAgregarBebida);
        panelNorte.add(new JLabel("Platos:"));
        panelNorte.add(comboPlatos);
        panelNorte.add(btnAgregarPlato);
        panelNorte.add(new JLabel("Tarjeta:"));
        panelNorte.add(comboTarjetas);

        areaPedido = new JTextArea();
        areaPedido.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaPedido);

        JPanel panelSur = new JPanel();
        labelTotal = new JLabel("Total: $0.0");
        JButton btnConfirmarPedido = new JButton("Confirmar Pedido");
        JButton btnPagar = new JButton("Pagar");
        panelSur.add(labelTotal);
        panelSur.add(btnConfirmarPedido);
        panelSur.add(btnPagar);

        add(panelNorte, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnAgregarBebida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarBebida();
            }
        });

        btnAgregarPlato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPlatoPrincipal();
            }
        });

        btnConfirmarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarPedido();
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPago();
            }
        });

        setVisible(true);
    }

    private List<Bebida> inicializarBebidas() {
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Coca-Cola", 100,false));
        bebidas.add(new Bebida("Jugo de Naranja", 150,false));
        return bebidas;
    }

    private List<PlatoPrincipal> inicializarPlatosPrincipales() {
        List<PlatoPrincipal> platos = new ArrayList<>();
        platos.add(new PlatoPrincipal("Pizza", 500,""));
        platos.add(new PlatoPrincipal("Pasta", 400,""));
        return platos;
    }

    private void agregarBebida() {
        String bebidaSeleccionada = (String) comboBebidas.getSelectedItem();
        for (Bebida bebida : listaBebidas) {
            if (bebida.getNombre().equals(bebidaSeleccionada)) {
                pedido.agregarBebida(bebida);
                areaPedido.append("Bebida: " + bebida.getNombre() + " - $" + bebida.getPrecio() + "\n");
                actualizarTotal();
                break;
            }
        }
    }

    private void agregarPlatoPrincipal() {
        String platoSeleccionado = (String) comboPlatos.getSelectedItem();
        for (PlatoPrincipal plato : listaPlatosPrincipales) {
            if (plato.getNombre().equals(platoSeleccionado)) {
                pedido.agregarPlatoPrincipal(plato);
                areaPedido.append("Plato: " + plato.getNombre() + " - $" + plato.getPrecio() + "\n");
                actualizarTotal();
                break;
            }
        }
    }

    private void actualizarTotal() {
        double total = pedido.calcularCostoTotalBebidas() + pedido.calcularCostoTotalPlatosPrincipales();
        labelTotal.setText("Total: $" + total);
    }

    private void confirmarPedido() {
        areaPedido.append("Pedido confirmado.\n");
    }

    private void realizarPago() {
        String tipoTarjeta = (String) comboTarjetas.getSelectedItem();
        Tarjeta tarjeta = crearTarjeta(tipoTarjeta);
        Pago pago = new Pago(pedido, tarjeta);

        // Añadir la pantalla del gerente como observador
        pago.addObserver(pantallaGerente);

        double montoDescontado = pago.calcularDescuento();
        areaPedido.append("Pago realizado. Descuento aplicado: $" + montoDescontado + "\n");
        actualizarTotal();
    }

    private Tarjeta crearTarjeta(String tipoTarjeta) {
        switch (tipoTarjeta) {
            case "MasterCard":
                return new MasterCard();
            case "Visa":
                return new Visa();
            default:
                return new TarjetaGenerica();
        }
    }

}