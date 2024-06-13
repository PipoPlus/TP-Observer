package ejercicio5;

public class PlatoPrincipal extends Item {
    private String tipo; // Por ejemplo: Entrada, Plato principal, Postre

    public PlatoPrincipal(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}
