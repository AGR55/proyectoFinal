package APP;

public class Compuestas extends Cisternas{
    private int cantidadCompartimentos;

    public Compuestas(int capacidad, String estado, String tipoAbasto, int cantidadCompartimentos) {
        super(capacidad, estado, tipoAbasto);
        this.cantidadCompartimentos=cantidadCompartimentos;
    }

    public int getCantidadCompartimentos() {
        return cantidadCompartimentos;
    }
}
