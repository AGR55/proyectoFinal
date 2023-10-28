package APP;

public abstract class Depositos {
    protected int capacidad;
    protected String estado;
    protected String tipoAbasto;

    public Depositos(int capacidad, String estado, String tipoAbasto) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.tipoAbasto = tipoAbasto;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoAbasto() {
        return tipoAbasto;
    }
}
