package ejercicio5;

import ejercicio4.Modelo.ObserverConcurso;

import java.util.ArrayList;
import java.util.List;

public class Pago {
    private Pedido pedido;
    private Tarjeta tarjeta;
    private List<VentaObserver> observers = new ArrayList<>();


    public Pago(Pedido pedido, Tarjeta tarjeta) {
        this.pedido = pedido;
        this.tarjeta = tarjeta;
    }

    public void addObserver(VentaObserver observer){
        observers.add(observer);
    }

    public double calcularDescuento() {
        double descuentoBebidas = tarjeta.aplicarDescuentoBebidas(pedido.calcularCostoTotalBebidas());
        double descuentoPlatos = tarjeta.aplicarDescuentoPlatosPrincipales(pedido.calcularCostoTotalPlatosPrincipales());
        double montoDescontado = descuentoBebidas + descuentoPlatos;

        pedido.confirmarPedido();
        notifyAllObservers(montoDescontado);

        return montoDescontado;

    }

    private void notifyAllObservers(double monto){
        for (VentaObserver observer : observers){
            observer.update(monto);
        }
    }



}
