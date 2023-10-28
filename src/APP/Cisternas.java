package APP;

public abstract class Cisternas extends Depositos {

    public Cisternas(int capacidad, String estado, String tipoAbasto) {
        super(capacidad, estado, tipoAbasto);
    }

    public abstract String clasificacion();
}
